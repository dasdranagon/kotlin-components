/*
 Copyright 2022 Splendo Consulting B.V. The Netherlands

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

import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds

actual typealias KalugaDateHolder = kotlin.js.Date

// TODO Implement with proper date solution for Java Script
/**
 * Default implementation of [KalugaDate]
 */
actual class DefaultKalugaDate internal constructor(actual override val date: KalugaDateHolder) : KalugaDate() {

    actual companion object {

        /**
         * Creates a [KalugaDate] relative to the current time
         * @param offset The [Duration] from the current time. Defaults to 0 milliseconds
         * @param timeZone The [KalugaTimeZone] in which the Date is set. Defaults to [KalugaTimeZone.current]
         * @param locale The [KalugaLocale] for which the Date is configured. Defaults to [KalugaLocale.defaultLocale]
         * @return A [KalugaDate] relative to the current time
         */
        actual fun now(offset: Duration, timeZone: KalugaTimeZone, locale: KalugaLocale): KalugaDate = DefaultKalugaDate(
            kotlin.js.Date(kotlin.js.Date.now() + offset.inWholeMilliseconds),
        )

        /**
         * Creates a [KalugaDate] relative to January 1st 1970 00:00:00 GMT
         * @param offset The [Duration] from the epoch time. Defaults to 0 milliseconds
         * @param timeZone The [KalugaTimeZone] in which the Date is set. Defaults to [KalugaTimeZone.current]
         * @param locale The [KalugaLocale] for which the Date is configured. Defaults to [KalugaLocale.defaultLocale]
         * @return A [KalugaDate] relative to the current time
         */
        actual fun epoch(offset: Duration, timeZone: KalugaTimeZone, locale: KalugaLocale): KalugaDate = DefaultKalugaDate(kotlin.js.Date(offset.inWholeMilliseconds))
    }

    actual override var timeZone: KalugaTimeZone
        get() = KalugaTimeZone()
        set(_) { }

    actual override var era: Int
        get() = 0
        set(_) { }
    actual override var year: Int
        get() = date.getFullYear()
        set(_) { }
    actual override var month: Int
        get() = date.getMonth()
        set(_) { }
    actual override val daysInMonth: Int = 0
    actual override var weekOfYear: Int
        get() = 0
        set(_) { }
    actual override var weekOfMonth: Int
        get() = 0
        set(_) { }
    actual override var day: Int
        get() = 0
        set(_) { }
    actual override var dayOfYear: Int
        get() = date.getDay()
        set(_) { }
    actual override var weekDay: Int
        get() = date.getDate() + 1
        set(_) { }
    actual override var firstWeekDay: Int
        get() = 1
        set(_) { }

    actual override var hour: Int
        get() = date.getHours()
        set(_) { }
    actual override var minute: Int
        get() = date.getMinutes()
        set(_) { }
    actual override var second: Int
        get() = date.getSeconds()
        set(_) { }
    actual override var millisecond: Int
        get() = date.getMilliseconds()
        set(_) { }
    actual override var durationSinceEpoch: Duration
        get() = date.getTime().milliseconds
        set(_) { }

    actual override fun copy(): KalugaDate = DefaultKalugaDate(kotlin.js.Date(date.getMilliseconds()))

    actual override fun equals(other: Any?): Boolean {
        return (other as? KalugaDate)?.let {
            timeZone == other.timeZone && durationSinceEpoch == other.durationSinceEpoch
        } ?: false
    }

    actual override fun compareTo(other: KalugaDate): Int {
        return when {
            date.getMilliseconds() < other.millisecond -> -1
            date.getMilliseconds() == other.millisecond -> 0
            else -> 1
        }
    }

    actual override fun hashCode(): Int {
        return date.hashCode()
    }
}
