import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

buildscript {

    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        // mostly migrated to new style plugin declarations, but some cross plugin interaction still requires this
        classpath("com.android.tools.build:gradle:${project.extra["kaluga.androidGradlePluginVersion"]}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${project.extra["kaluga.kotlinVersion"]}")
        classpath("org.jetbrains.kotlinx:atomicfu-gradle-plugin:${project.extra["kaluga.atomicFuGradlePluginVersion"]}")
    }
}

plugins {
    id("kaluga-library-components")
    id("convention.publication")
    id("org.jmailen.kotlinter")
    id("org.jetbrains.dokka")
    id("org.jetbrains.kotlin.multiplatform") apply false
    id("org.jetbrains.kotlinx.binary-compatibility-validator")
}

allprojects {
    repositories {
        mavenCentral()
        google()
        // only enable temporarily if needed:
        /* mavenLocal() */
    }

    tasks.withType<Test> {
        testLogging {
            events = setOf(TestLogEvent.STANDARD_OUT, TestLogEvent.STARTED, TestLogEvent.PASSED, TestLogEvent.SKIPPED, TestLogEvent.FAILED)
        }
        testLogging.exceptionFormat = TestExceptionFormat.FULL
    }

    // Workaround for Kapt not setting the proper JVM target
    // See https://youtrack.jetbrains.com/issue/KT-55947/Unable-to-set-kapt-jvm-target-version
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        kotlinOptions.jvmTarget = "11"
    }
}

apiValidation {

    subprojects.forEach {
        val name = it.name

        ignoredClasses.add("com.splendo.kaluga.$name.BuildConfig".toString())
        ignoredClasses.add("com.splendo.kaluga.${name.replace("-", ".")}.BuildConfig".toString())
        ignoredClasses.add("com.splendo.kaluga.${name.replace("-", "")}.BuildConfig".toString())
        ignoredClasses.add("com.splendo.kaluga.permissions.${name.replace("-permissions", "")}.BuildConfig".toString())
    }

    ignoredClasses.add("com.splendo.kaluga.permissions.BuildConfig")
    ignoredClasses.add("com.splendo.kaluga.test.BuildConfig")
    ignoredClasses.add("com.splendo.kaluga.datetime.timer.BuildConfig")
}

apply(from = "gradle/newModule.gradle.kts")
apply(from = "gradle/copyReports.gradle.kts")

group = Library.group
version = Library.version
