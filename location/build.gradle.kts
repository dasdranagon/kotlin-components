plugins {
    kotlin("multiplatform")
    id("jacoco")
    id("convention.publication")
    id("com.android.library")
    id("org.jetbrains.dokka")
    id("org.jlleitschuh.gradle.ktlint")
    id("kotlinx-atomicfu")
}

publishableComponent()

dependencies {
    implementationDependency(Dependencies.Android.PlayServices.Location)
    implementationDependency(Dependencies.KotlinX.Coroutines.PlayServices)
    implementationDependency(Dependencies.KotlinX.AtomicFu)
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":service"))
                api(project(":base", ""))
                api(project(":location-permissions", ""))
            }
        }
        commonTest {
            dependencies {
                implementation(project(":test-utils-location", ""))
            }
        }
    }
}
