plugins {
    kotlin("multiplatform")
    id("jacoco")
    id("convention.publication")
    id("com.android.library")
    id("org.jlleitschuh.gradle.ktlint")
}

publishableComponent()

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(project(":test-utils-base"))
                api(project(":test-utils-architecture"))
                expose(Dependencies.Koin.Core)
            }
        }
        commonTest {
            dependencies {
            }
        }
    }
}
