plugins {
    kotlin("multiplatform")
    id("jacoco")
    id("convention.publication")
    id("com.android.library")
    id("org.jetbrains.dokka")
    id("org.jlleitschuh.gradle.ktlint")
}

publishableComponent()

dependencies { }

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":logging"))
                implementation(project(":base"))
                implementation(project(":test-utils-base"))
            }
        }
        commonTest {
            dependencies {
            }
        }
    }
}
