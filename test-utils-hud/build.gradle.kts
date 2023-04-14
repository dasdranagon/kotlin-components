plugins {
    kotlin("multiplatform")
    id("jacoco")
    id("convention.publication")
    id("com.android.library")
    id("org.jetbrains.dokka")
    id("org.jlleitschuh.gradle.ktlint")
}

publishableComponent("test.hud")

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(project(":test-utils-architecture"))
                api(project(":hud"))
            }
        }
    }
}
