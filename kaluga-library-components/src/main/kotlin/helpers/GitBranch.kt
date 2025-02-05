/*
 Copyright 2024 Splendo Consulting B.V. The Netherlands

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

package com.splendo.kaluga.plugin.helpers

import org.gradle.api.Project
import java.util.Locale

data class GitBranch(private val branch: String, private val kalugaBranchPostfix: String) {

    companion object {
        val gitBranch by lazy<GitBranch> {
            val githubGitBranch = System.getenv("GITHUB_REF_NAME") // could also be a tag name
            val mavenCentralRelease = System.getenv("MAVEN_CENTRAL_RELEASE")
            val branchFromGit = run {
                try {
                    val process = ProcessBuilder().command("git rev-parse --abbrev-ref HEAD".split(" ")).start()
                    process.inputStream.bufferedReader().readText()
                } catch (e: Exception) {
                    println("Unable to determine current branch through git CLI: ${e.message}")
                    "unknown"
                }
            }

            // favour user definition of kaluga_branch (if present), otherwise take it from GIT branch:
            // - if running on CI: favour github's branch detection
            // - else: try to get it via the `git` CLI.
            val branch = (githubGitBranch ?: branchFromGit).replace('/', '-').trim().lowercase(Locale.ENGLISH).also {
                if (it == "HEAD") {
                    println("Unable to determine current branch: Project is checked out with detached head!")
                }
            }

            val release = mavenCentralRelease?.lowercase(Locale.ENGLISH)?.trim() == "true" || branch == "master" || branch == "main"

            val kalugaBranchPostfix = (
                when (branch) {
                    "master", "main", "develop" -> ""
                    else -> "-$branch"
                } + if (!release) "-SNAPSHOT" else ""
                ).also {
                    println(
                        "decided branch: '$branch' to postfix '$it', " +
                            "isRelease: $release (" +
                            "from: GITHUB_REF_NAME env: $githubGitBranch, " +
                            "MAVEN_CENTRAL_RELEASE env: $mavenCentralRelease , " +
                            "git cli: $branchFromGit" +
                            ")",
                    )
                }
            GitBranch(branch, kalugaBranchPostfix)
        }
    }

    fun toVersion(baseVersion: String): String =
        if (baseVersion.endsWith("-SNAPSHOT"))
            baseVersion
        else
            baseVersion + kalugaBranchPostfix
}

val Project.gitBranch: GitBranch get() = GitBranch.gitBranch
