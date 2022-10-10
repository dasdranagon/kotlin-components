plugins {
    kotlin("multiplatform")
    id("jacoco")
    id("convention.publication")
    id("com.android.library")
    id("org.jlleitschuh.gradle.ktlint")
}

publishableComponent()

dependencies {
    implement(Dependencies.BLEScanner)
    implementation(project(":location", ""))
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(project(":bluetooth-permissions", ""))
                implement(Dependencies.Stately.Concurrency)
            }
        }
        commonTest {
            dependencies {
                implementation(project(":test-utils-bluetooth", ""))
            }
        }
    }
}
