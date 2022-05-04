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
val kotlinx_coroutines_version = ext["kotlinx_coroutines_version"]!!

dependencies {
    val play_services_version = (gradle as ExtensionAware).extra["play_services_version"]
    implementation("com.google.android.gms:play-services-location:$play_services_version")
}

kotlin {
    js {
        nodejs()
    }

    sourceSets {
        getByName("commonMain") {
            val ext = (gradle as ExtensionAware).extra

            dependencies {
                implementation(project(":logging", ""))
                api(project(":base", ""))
                api(project(":base-permissions", ""))
            }
        }
        getByName("commonTest") {
            dependencies {
                api(project(":test-utils", ""))
            }
        }
    }
}
