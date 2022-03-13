plugins {
    kotlin("multiplatform")
    id("jacoco")
    id("convention.publication")
    id("com.android.library")
    id("org.jlleitschuh.gradle.ktlint")
}

val ext = (gradle as ExtensionAware).extra

apply(from = "../gradle/publishable_component.gradle")

group = "com.splendo.kaluga"
version = ext["library_version"]!!

val androidx_arch_core_testing_version = ext["androidx_arch_core_testing_version"]!!

dependencies {
    implementation("androidx.arch.core:core-testing:$androidx_arch_core_testing_version")
}

kotlin {
    js {
        nodejs()
    }

    sourceSets {
        commonMain {
            dependencies {
                val ext = (gradle as ExtensionAware).extra

                // these are not coming from component.gradle because they need to be in the main scope
                api(kotlin("test"))
                api(kotlin("test-junit"))

                implementation("org.jetbrains.kotlin:kotlin-reflect:" + ext["kotlin_version"])

                // these dependencies make test linking slow, but Kotlin/Native cannot handle `compileOnly`
                // https://github.com/splendo/kaluga/issues/208
                implementation(project(":alerts", ""))
                implementation(project(":architecture", ""))
                implementation(project(":base", ""))
                implementation(project(":bluetooth", ""))
                implementation(project(":hud", ""))
                implementation(project(":keyboard", ""))
                implementation(project(":logging", ""))
                implementation(project(":base-permissions", ""))
                implementation(project(":camera-permissions", ""))
                implementation(project(":contacts-permissions", ""))
                implementation(project(":microphone-permissions", ""))
                implementation(project(":notifications-permissions", ""))
                implementation(project(":storage-permissions", ""))
                implementation(project(":bluetooth-permissions", ""))
                implementation(project(":location-permissions", ""))
                implementation(project(":calendar-permissions", ""))
                implementation(project(":resources", ""))
                implementation("io.insert-koin:koin-core:" + ext["koin_version"])
                implementation("org.mockito:mockito-core:" + ext["mockito_version"]) {
                    exclude(group = "net.bytebuddy")
                }
            }
        }

        getByName("androidLibMain") {
            val ext = (gradle as ExtensionAware).extra
            dependencies {
                // import needed for android KeyboardHostingView implementation.
                implementation("androidx.compose.ui:ui:${ext["androidx_compose_version"]}")
            }
        }

        getByName("jsMain") {
            dependencies {
                api(kotlin("test-js"))
            }
        }

        getByName("jvmMain") {
            val ext = (gradle as ExtensionAware).extra

            dependencies {
                api("org.jetbrains.kotlinx:kotlinx-coroutines-test:" + ext["kotlinx_coroutines_version"])
                api("org.jetbrains.kotlinx:kotlinx-coroutines-debug:" + ext["kotlinx_coroutines_version"])
            }
        }
    }
}

android {
    dependencies {
        val ext = (gradle as ExtensionAware).extra
        api("org.jetbrains.kotlinx:kotlinx-coroutines-test:" + ext["kotlinx_coroutines_version"])
        api("org.jetbrains.kotlinx:kotlinx-coroutines-debug:" + ext["kotlinx_coroutines_version"])
    }
}
