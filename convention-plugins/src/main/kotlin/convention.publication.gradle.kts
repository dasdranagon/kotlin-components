/*
 Copyright 2021 Splendo Consulting B.V. The Netherlands

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

 */

import org.gradle.api.publish.maven.MavenPublication
import org.gradle.api.tasks.bundling.Jar
import org.gradle.kotlin.dsl.`maven-publish`
import org.gradle.kotlin.dsl.signing

plugins {
    `maven-publish`
    signing
}

val signingKeyId: String? by project
val signingPassword: String? by project
val signingSecretKeyRingFile: String? by project
val ossrhUsername: String? by project
val ossrhPassword: String? by project

// Stub secrets to let the project sync and build without the publication values set up
ext["signing.keyId"] = signingKeyId
ext["signing.password"] = signingPassword
ext["signing.secretKeyRingFile"] = signingSecretKeyRingFile
ext["ossrhUsername"] = ossrhUsername
ext["ossrhPassword"] = ossrhPassword

signing {
    setRequired(
        {
            gradle.taskGraph.hasTask("publish") && signingSecretKeyRingFile != null
        }
    )
}

val javadocJar by tasks.registering(Jar::class) {
    archiveClassifier.set("javadoc")
}

fun getExtraString(name: String) = ext[name]?.toString()

publishing {
    // Configure maven central repository
    repositories {
        maven {
            name = "sonatype"
            setUrl("https://oss.sonatype.org/service/local/staging/deploy/maven2/")
            credentials {
                username = getExtraString("ossrhUsername")
                password = getExtraString("ossrhPassword")
            }
        }
    }

    // Configure all publications
    publications.withType<MavenPublication> {

        // Stub javadoc.jar artifact
        artifact(javadocJar.get())

        // Provide artifacts information requited by Maven Central
        pom {
            name.set(project.name)
            description.set("Collection of Kotlin Flow based libraries")
            url.set("https://github.com/splendo/kaluga")

            licenses {
                license {
                    name.set("The Apache Software License, Version 2.0")
                    url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    distribution.set("repo")
                }
            }
            developers {
                developer {
                    id.set("splendo")
                    name.set("Splendo BV")
                }
            }
            scm {
                url.set("https://github.com/splendo/kaluga")
            }
        }
    }
}

// Signing artifacts. Signing.* extra properties values will be used

signing {
    sign(publishing.publications)
}
