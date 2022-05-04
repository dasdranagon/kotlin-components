/*
 Copyright 2020 Splendo Consulting B.V. The Netherlands

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

package com.splendo.kaluga.base.utils

// TODO Implement with proper timezone solution for Java Script
actual class TimeZone internal constructor() {

    actual companion object {
        actual fun get(identifier: String): TimeZone? = TimeZone()
        actual fun current(): TimeZone = TimeZone()
        actual val availableIdentifiers: List<String> = emptyList()
    }

    actual val identifier: String = ""
    actual fun displayName(style: TimeZoneNameStyle, withDaylightSavings: Boolean, locale: Locale): String = ""
    actual val offsetFromGMTInMilliseconds = 0L
    actual val daylightSavingsOffsetInMilliseconds: Long = 0L
    actual fun offsetFromGMTAtDateInMilliseconds(date: KalugaDate): Long = 0L
    actual fun usesDaylightSavingsTime(date: KalugaDate): Boolean = false
    actual fun copy(): TimeZone = TimeZone()
}
