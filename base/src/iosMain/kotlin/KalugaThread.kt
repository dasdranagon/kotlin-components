/*
 * Copyright 2022 Splendo Consulting B.V. The Netherlands
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package com.splendo.kaluga.base

import platform.Foundation.NSThread

actual data class KalugaThread(val thread: NSThread) {

    actual companion object {
        actual val currentThread: KalugaThread get() = KalugaThread(NSThread.currentThread)
        private val threadDescriptionRegex = "^.*\\{(.*)}\$".toRegex()
        actual val MIN_PRIORITY: Int = 1
        actual val MAX_PRIORITY: Int = 10
    }

    actual var name: String get() = thread.name.orEmpty().ifEmpty {
        // On iOS the Thread name is not actually always accessible via name (only if set via custom setter)
        // To still grab the name, we should parse the thread description
        val descriptionBody = threadDescriptionRegex.matchEntire(thread.description.orEmpty())?.let { result ->
            result.groups[1]?.value
        }.orEmpty()
        val threadDescription = descriptionBody.split(",").associate { line ->
            val keyValue = line.split("=")
            keyValue[0].trim() to keyValue[1].trim().replace("(null)", "")
        }
        threadDescription["name"].orEmpty().ifEmpty {
            "Thread ${(threadDescription["number"] ?: threadDescription["num"]).orEmpty().ifEmpty { "Unknown" }}"
        }
    }
    set(value) { thread.name = value }
    actual var priority: Int
        get() = (thread.threadPriority * MAX_PRIORITY + MIN_PRIORITY).toInt()
        set(value) {
            require(value in MIN_PRIORITY..MAX_PRIORITY)
            thread.setThreadPriority((value - MIN_PRIORITY).toDouble() / MAX_PRIORITY)
        }
    actual val isMainThread: Boolean get() = thread.isMainThread
    actual val isAlive: Boolean get() = thread.isExecuting()
}
