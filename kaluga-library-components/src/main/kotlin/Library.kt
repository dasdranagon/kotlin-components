/*
 Copyright 2022 Splendo Consulting B.V. The Netherlands

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

 */

import org.gradle.api.Project
import org.gradle.api.logging.Logger
import org.gradle.kotlin.dsl.extra
import org.jetbrains.kotlin.konan.file.File
import org.jetbrains.kotlin.konan.properties.Properties
import org.jetbrains.kotlin.konan.properties.loadProperties
import java.io.IOException

private val libraries: MutableMap<Project, LibraryImpl> = mutableMapOf()

/**
 * Gets a [LibraryImpl] for the [Project]. Only creates a new instance of the Library if none exist yet, to speed up the build process
 */
val Project.Library get() = libraries.getOrPut(this) { LibraryImpl(this) }

class LibraryImpl(project: Project) {

    private val props: Properties = File("${project.rootProject.buildDir.absolutePath}/../local.properties").let { file ->
        if (file.exists) {
            file.loadProperties()
        } else {
            Properties()
        }
    }
    private val logger = project.logger
    private val baseVersion = "1.2.0"
    val group = "com.splendo.kaluga"
    val version: String by lazy {
        val libraryVersionLocalProperties: String? = props["kaluga.libraryVersion"] as? String
        (libraryVersionLocalProperties ?: "$baseVersion${project.GitBranch.kalugaBranchPostfix}").also {
            println("Library version $it")
        }
    }
    val kotlinVersion = project.extra["kaluga.kotlinVersion"] as? String ?: kotlin.run {
        logger.lifecycle("Missing kotlin version")
        throw IOException("Provide kaluga.kotlinVersion in your gradle.properties")
    }

    object Android {
        const val minSdk = 23
        const val compileSdk = 33
        const val targetSdk = 33
        const val buildTools = "33.0.2"
        const val composeCompiler = "1.4.5"
    }

    class IOSLibrary(props: Properties, logger: Logger) {
        // based on https://github.com/Kotlin/xcode-compat/blob/d677a43edc46c50888bca0a7890a81f976a42809/xcode-compat/src/main/kotlin/org/jetbrains/kotlin/xcodecompat/XcodeCompatPlugin.kt#L16
        val sdkName = System.getenv("SDK_NAME") ?: "unknown"
        val isRealIOSDevice = sdkName.startsWith("iphoneos").also {
            logger.lifecycle("Run on real ios device: $it from sdk: $sdkName")
        }

        // Run on IntelliJ
        val ideaActive = (System.getProperty("idea.active") == "true").also {
            logger.lifecycle("Run on IntelliJ: $it")
        }

        // Run on apple silicon
        val isAppleSilicon = (System.getProperty("os.arch") == "aarch64").also {
            logger.lifecycle("Run on apple silicon: $it")
        }

        val targets = when {
            !ideaActive -> IOSTarget.values().toSet()
            isRealIOSDevice -> setOf(IOSTarget.Arm64)
            isAppleSilicon -> setOf(IOSTarget.SimulatorArm64)
            else -> setOf(IOSTarget.X64)
        }.also { targets ->
            logger.lifecycle("Run on ios targets: ${targets.joinToString(" ") { it.name }}")
        }

        val TestRunnerDeviceId by lazy {
            if (System.getenv().containsKey("IOS_TEST_RUNNER_DEVICE_ID")) {
                System.getenv()["IOS_TEST_RUNNER_DEVICE_ID"].also {
                    logger.lifecycle("System env IOS_TEST_RUNNER_DEVICE_ID set to ${System.getenv()["IOS_TEST_RUNNER_DEVICE_ID"]}, using $it")
                }!!
            } else {
                // load some more from local.properties or set defaults.
                val iosTestRunnerDeviceIdLocalProperty: String? =
                    props["kaluga.iosTestRunnerDeviceIdLocalProperty"] as? String
                iosTestRunnerDeviceIdLocalProperty?.also {
                    logger.lifecycle("local.properties read (kaluga.iosTestRunnerDeviceIdLocalProperty=$iosTestRunnerDeviceIdLocalProperty, using $it)")
                }
                    ?: "iPhone 14".also {
                        logger.lifecycle("local.properties not found, using default value ($it)")
                    }
            }
        }
    }
    val IOS = IOSLibrary(props, logger)

    val connectCheckExpansion = (System.getenv().containsKey("CONNECTED_CHECK_EXPANSION") or System.getenv().containsKey("CI")).also {
        if (it) {
            logger.lifecycle("Adding extra dependend task to connected checks of similarly named modules (CONNECTED_CHECK_EXPANSION env present: ${ System.getenv().containsKey("CONNECTED_CHECK_EXPANSION") })")
        }
    }
}

enum class IOSTarget {
    X64,
    Arm64,
    SimulatorArm64,
}
