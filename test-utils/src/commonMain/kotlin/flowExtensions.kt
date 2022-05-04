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

package com.splendo.kaluga.test

import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.withTimeout
import kotlin.time.Duration

/**
 * Returns a list of flow items captured for [duration]
 * @param duration of capturing
 * @return a list of flow items captured for [duration]
 */
suspend fun <T> Flow<T>.captureFor(duration: Duration): List<T> {
    val output = mutableListOf<T>()

    try {
        withTimeout(duration) {
            collect { output += it }
        }
    } catch (e: TimeoutCancellationException) {
        // ignore
    }
    return output
}
