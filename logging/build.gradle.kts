plugins {
    kotlin("multiplatform")
    id("jacoco")
    id("com.android.library")
    id("convention.publication")
    id("org.jlleitschuh.gradle.ktlint")
}

publishableComponent()

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implement(Dependencies.Napier)
            }
        }
        commonTest {
            dependencies {
                api(project(":test-utils-base", ""))
            }
        }
    }
}
