/***********************************************
 *
 * Changes made to this file should also be reflected in the `settings.gradle` under [example/ios/Supporting Files]
 *
 * Also any new modules should be added to the build matrix in [.git/workflows]
 *
 ***********************************************/

pluginManagement {

    repositories {
        gradlePluginPortal()
        google()
    }

    resolutionStrategy {
        eachPlugin {

            val kalugaAndroidGradlePluginVersion =
                settings.extra["kaluga.androidGradlePluginVersion"]
            val kalugaKotlinVersion = settings.extra["kaluga.kotlinVersion"]
            val kalugaKotlinterGradlePluginVersion = settings.extra["kaluga.kotlinterGradlePluginVersion"]
            val kalugaGoogleServicesGradlePluginVersion = settings.extra["kaluga.googleServicesGradlePluginVersion"]
            val kalugaAtomicFuGradlePluginVersion = settings.extra["kaluga.atomicFuGradlePluginVersion"]
            val kalugaBinaryCompatibilityValidatorVersion = settings.extra["kaluga.binaryCompatibilityValidatorVersion"]
            val kalugaDokkaVersion = settings.extra["kaluga.dokkaVersion"]

            when (requested.id.id) {
                "org.jetbrains.kotlin.multiplatform",
                "org.jetbrains.kotlin.plugin.serialization",
                "org.jetbrains.kotlin.android",
                "org.jetbrains.kotlin.kapt"
                -> useVersion("$kalugaKotlinVersion")
                "org.jetbrains.dokka"
                -> useVersion("$kalugaDokkaVersion")
                "com.android.library",
                "com.android.application"
                -> useVersion("$kalugaAndroidGradlePluginVersion")
                "org.jmailen.kotlinter"
                -> useVersion("$kalugaKotlinterGradlePluginVersion")
                "com.google.gms:google-services"
                -> useVersion("com.google.gms:google-services:$kalugaGoogleServicesGradlePluginVersion")
                "org.jetbrains.kotlinx.binary-compatibility-validator"
                -> useVersion("$kalugaBinaryCompatibilityValidatorVersion")
                "org.jetbrains.kotlinx.atomicfu" -> useVersion("$kalugaAtomicFuGradlePluginVersion")
            }
        }
    }
}

includeBuild("kaluga-library-components")
includeBuild("convention-plugins")
includeBuild("gradle-test-recorder/plugin-build/")

rootProject.name = "Kaluga"

/* REMINDER (see header), files should be kept up to date with Gradle and the [.git/workflows] */

include(":base")
include(":beacons")
include(":bluetooth")
include(":architecture")
include(":architecture-compose")
include(":alerts")
include(":date-time")
include(":date-time-picker")
include(":logging")
include(":hud")
include(":base-permissions")
include(":bluetooth-permissions")
include(":calendar-permissions")
include(":location-permissions")
include(":storage-permissions")
include(":notifications-permissions")
include(":contacts-permissions")
include(":microphone-permissions")
include(":camera-permissions")
include(":permissions")
include(":location")
include(":keyboard")
include(":keyboard-compose")
include(":links")
include(":media")
include(":resources")
include(":resources-compose")
include(":resources-databinding")
include(":review")
include(":scientific")
include(":service")
include(":system")
// Test Utils
include(":test-utils")
include(":test-utils-base")
include(":test-utils-alerts")
include(":test-utils-architecture")
include(":test-utils-bluetooth")
include(":test-utils-date-time-picker")
include(":test-utils-hud")
include(":test-utils-keyboard")
include(":test-utils-koin")
include(":test-utils-location")
include(":test-utils-media")
include(":test-utils-permissions")
include(":test-utils-resources")
include(":test-utils-service")
include(":test-utils-system")
