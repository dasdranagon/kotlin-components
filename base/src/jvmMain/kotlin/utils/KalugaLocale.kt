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

import com.splendo.kaluga.base.text.upperCased

/**
 * Default implementation of [BaseLocale]
 */
actual data class KalugaLocale internal constructor(internal val locale: java.util.Locale) : BaseLocale() {
    actual companion object {

        /**
         * Creates a [KalugaLocale] based on a `language` ISO 639 alpha-2 or alpha-3 code
         * @param language a `language` ISO 639 alpha-2 or alpha-3 code.
         * @return The [KalugaLocale] for the given [language]
         */
        actual fun createLocale(language: String): KalugaLocale = KalugaLocale(
            java.util.Locale.Builder()
                .setLanguage(language)
                .build(),
        )

        /**
         * Creates a [KalugaLocale] based on a ISO 639 alpha-2 or alpha-3 `language` code and ISO 3166 alpha-2 `country` code.
         * @param language a ISO 639 alpha-2 or alpha-3 `language` code.
         * @param country a ISO 3166 alpha-2 `country` code.
         * @return The [KalugaLocale] for the given [language] and [country]
         */
        actual fun createLocale(language: String, country: String): KalugaLocale = KalugaLocale(
            java.util.Locale.Builder()
                .setLanguage(language)
                .setRegion(country)
                .build(),
        )

        /**
         * Creates a [KalugaLocale] based on a ISO 639 alpha-2 or alpha-3 `language` code, ISO 3166 alpha-2 `country` code, and variant code.
         * @param language a ISO 639 alpha-2 or alpha-3 `language` code.
         * @param country a ISO 3166 alpha-2 `country` code.
         * @param variant Arbitrary value used to indicate a variation of a [KalugaLocale]
         * @return The [KalugaLocale] for the given [language], [country], and [variant]
         */
        actual fun createLocale(language: String, country: String, variant: String): KalugaLocale = KalugaLocale(
            java.util.Locale.Builder()
                .setLanguage(language)
                .setRegion(country)
                .setVariant(variant)
                .build(),
        )

        /**
         * The default [KalugaLocale] of the user
         */
        actual val defaultLocale: KalugaLocale get() = KalugaLocale(java.util.Locale.getDefault())

        /**
         * A list of [KalugaLocale] available to the user.
         */
        actual val availableLocales: List<KalugaLocale> = java.util.Locale.getAvailableLocales().asList().map { KalugaLocale(it) }
    }

    override val countryCode: String
        get() = locale.country
    override val languageCode: String
        get() = locale.language
    override val scriptCode: String
        get() = locale.script
    override val variantCode: String
        get() = locale.variant
    override val unitSystem: UnitSystem
        get() = UnitSystem.withCountryCode(countryCode.upperCased(this))

    override fun name(forLocale: KalugaLocale): String = locale.getDisplayName(forLocale.locale)
    override fun countryName(forLocale: KalugaLocale): String = locale.getDisplayCountry(forLocale.locale)
    override fun languageName(forLocale: KalugaLocale): String = locale.getDisplayLanguage(forLocale.locale)
    override fun variantName(forLocale: KalugaLocale): String = locale.getDisplayVariant(forLocale.locale)
    override fun scriptName(forLocale: KalugaLocale): String = locale.getDisplayScript(forLocale.locale)

    override val quotationStart: String = "\""
    override val quotationEnd: String = "\""
    override val alternateQuotationStart: String = "\""
    override val alternateQuotationEnd: String = "\""
}
