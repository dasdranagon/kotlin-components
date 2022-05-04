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

package com.splendo.kaluga.base.text

import com.splendo.kaluga.base.utils.KalugaDate
import com.splendo.kaluga.base.utils.Locale
import com.splendo.kaluga.base.utils.Locale.Companion.defaultLocale
import com.splendo.kaluga.base.utils.TimeZone
import com.splendo.kaluga.base.utils.enUsPosix

/**
 * Style used for formatting a [KalugaDate] to and from a [String]
 */
enum class DateFormatStyle {
    /**
     * Short style pattern
     */
    Short,

    /**
     * Medium style pattern
     */
    Medium,

    /**
     * Long style pattern
     */
    Long,

    /**
     * Full style pattern
     */
    Full
}

/**
 * Class for parsing and formatting a [KalugaDate] from/to a [String].
 */
expect class KalugaDateFormatter {

    companion object {
        /**
         * Creates a [KalugaDateFormatter] that only formats the date components of a [KalugaDate]
         * @param style The [DateFormatStyle] used for formatting the date components of the [KalugaDate]. Defaults to [DateFormatStyle.Medium].
         * @param timeZone The [TimeZone] for which the date should be formatted. Defaults to [TimeZone.current].
         * @param locale The [Locale] for which the date should be formatted. Defaults to [Locale.defaultLocale].
         */
        fun dateFormat(
            style: DateFormatStyle = DateFormatStyle.Medium,
            timeZone: TimeZone = TimeZone.current(),
            locale: Locale = defaultLocale
        ): KalugaDateFormatter

        /**
         * Creates a [KalugaDateFormatter] that only formats the time components of a [KalugaDate]
         * @param style The [DateFormatStyle] used for formatting the time components of the [KalugaDate]. Defaults to [DateFormatStyle.Medium].
         * @param timeZone The [TimeZone] for which the date should be formatted. Defaults to [TimeZone.current].
         * @param locale The [Locale] for which the date should be formatted. Defaults to [Locale.defaultLocale].
         */
        fun timeFormat(
            style: DateFormatStyle = DateFormatStyle.Medium,
            timeZone: TimeZone = TimeZone.current(),
            locale: Locale = defaultLocale
        ): KalugaDateFormatter

        /**
         * Creates a [KalugaDateFormatter] that formats both date and time components of a [KalugaDate]
         * @param dateStyle The [DateFormatStyle] used for formatting the date components of the [KalugaDate]. Defaults to [DateFormatStyle.Medium].
         * @param timeStyle The [DateFormatStyle] used for formatting the time components of the [KalugaDate]. Defaults to [DateFormatStyle.Medium].
         * @param timeZone The [TimeZone] for which the date should be formatted. Defaults to [TimeZone.current].
         * @param locale The [Locale] for which the date should be formatted. Defaults to [Locale.defaultLocale].
         */
        fun dateTimeFormat(
            dateStyle: DateFormatStyle = DateFormatStyle.Medium,
            timeStyle: DateFormatStyle = DateFormatStyle.Medium,
            timeZone: TimeZone = TimeZone.current(),
            locale: Locale = defaultLocale
        ): KalugaDateFormatter

        /**
         * Creates a [KalugaDateFormatter] using a custom Date format pattern.
         * On iOS some user settings may take precedent over the format (i.e. using 12 hour clock).
         * To prevent this, ensure that the provided [locale] is of a `POSIX` type.
         * A convenience [fixedPatternFormat] method exists to default to this behaviour.
         * @param pattern The pattern to apply.
         * @param timeZone The [TimeZone] for which the date should be formatted. Defaults to [TimeZone.current].
         * @param locale The [Locale] for which the date should be formatted. Defaults to [Locale.defaultLocale].
         */
        fun patternFormat(
            pattern: String,
            timeZone: TimeZone = TimeZone.current(),
            locale: Locale = defaultLocale
        ): KalugaDateFormatter
    }

    var pattern: String

    /**
     * The [TimeZone] this [KalugaDateFormatter] formats its dates to.
     */
    var timeZone: TimeZone

    /**
     * A list containing the names of all eras used by this date formatter.
     */
    var eras: List<String>

    /**
     * A list containing the names of all months used by this date formatter.
     */
    var months: List<String>

    /**
     * A list containing the shortened names of all months used by this date formatter.
     */
    var shortMonths: List<String>

    /**
     * A list containing the names of all weekdays used by this date formatter.
     */
    var weekdays: List<String>
    /**
     * A list containing the shortened names of all weekdays used by this date formatter.
     */
    var shortWeekdays: List<String>

    /**
     * The name used to describe A.M. when using a twelve hour clock.
     */
    var amString: String

    /**
     * The name used to describe P.M. when using a twelve hour clock.
     */
    var pmString: String

    /**
     * Formats a given [KalugaDate] to a [String] using the format described by this [KalugaDateFormatter].
     * @param date The [KalugaDate] to format.
     * @return The formatted [KalugaDate] as a [String]
     */
    fun format(date: KalugaDate): String

    /**
     * Attempts to parse a given [String] into a [KalugaDate] using the format described.
     * @param string The [String] to parse.
     * @return A [KalugaDate] matching the format described by [string] or `null` if no such match could be made.
     */
    fun parse(string: String): KalugaDate?
}

@Deprecated("Due to name clashes with platform classes and API changes this class has been renamed and changed to an interface. It will be removed in a future release.", ReplaceWith("KalugaState"))
typealias DateFormatter = KalugaDateFormatter

/**
 * Creates a fixed [KalugaDateFormatter] using a custom Date format pattern, localized by the [Locale.enUsPosix] [Locale].
 * Use this to ensure that displaying time in 12 or 24 hour format is not overridden by the user.
 * @param pattern The pattern to apply.
 * @param timeZone The [TimeZone] for which the date should be formatted. Defaults to [TimeZone.current].
 */
fun KalugaDateFormatter.Companion.fixedPatternFormat(pattern: String, timeZone: TimeZone = TimeZone.current()) = patternFormat(pattern, timeZone, Locale.enUsPosix)

/**
 * Creates a [KalugaDateFormatter] that formats time according to the ISo 8601 format.
 * @param timeZone The [TimeZone] for which the date should be formatted. Defaults to [TimeZone.current].
 */
fun KalugaDateFormatter.Companion.iso8601Pattern(timeZone: TimeZone = TimeZone.current()) = fixedPatternFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", timeZone)

/**
 * Creates a [KalugaDateFormatter] that only formats the date components of a [KalugaDate]
 * @param style The [DateFormatStyle] used for formatting the date components of the [KalugaDate]. Defaults to [DateFormatStyle.Medium].
 * @param excludeYear When [true] the year will not be part of the format.
 * @param timeZone The [TimeZone] for which the date should be formatted. Defaults to [TimeZone.current].
 * @param locale The [Locale] for which the date should be formatted. Defaults to [Locale.defaultLocale].
 */
fun KalugaDateFormatter.Companion.dateFormat(
    style: DateFormatStyle = DateFormatStyle.Medium,
    excludeYear: Boolean,
    timeZone: TimeZone = TimeZone.current(),
    locale: Locale = defaultLocale
): KalugaDateFormatter {
    val formatWithYear = dateFormat(style, timeZone, locale)
    return if (excludeYear) {
        patternFormat(patternWithoutYear(formatWithYear.pattern), timeZone, locale)
    } else {
        formatWithYear
    }
}

/**
 * Creates a [KalugaDateFormatter] that formats both date and time components of a [KalugaDate]
 * @param dateStyle The [DateFormatStyle] used for formatting the date components of the [KalugaDate]. Defaults to [DateFormatStyle.Medium].
 * @param excludeYear When [true] the year will not be part of the format.
 * @param timeStyle The [DateFormatStyle] used for formatting the time components of the [KalugaDate]. Defaults to [DateFormatStyle.Medium].
 * @param timeZone The [TimeZone] for which the date should be formatted. Defaults to [TimeZone.current].
 * @param locale The [Locale] for which the date should be formatted. Defaults to [Locale.defaultLocale].
 */
fun KalugaDateFormatter.Companion.dateTimeFormat(
    dateStyle: DateFormatStyle = DateFormatStyle.Medium,
    excludeYear: Boolean,
    timeStyle: DateFormatStyle = DateFormatStyle.Medium,
    timeZone: TimeZone = TimeZone.current(),
    locale: Locale = defaultLocale
): KalugaDateFormatter {
    val formatWithYear = dateTimeFormat(dateStyle, timeStyle, timeZone, locale)
    return if (excludeYear) {
        val datePatternWithYear = dateFormat(dateStyle, timeZone, locale).pattern
        val datePatternWithoutYear = patternWithoutYear(datePatternWithYear)
        patternFormat(formatWithYear.pattern.replace(datePatternWithYear, datePatternWithoutYear), timeZone, locale)
    } else {
        formatWithYear
    }
}

internal fun KalugaDateFormatter.Companion.patternWithoutYear(pattern: String): String = pattern.replace("\\W*[Yy]+\\W*".toRegex(), "")
