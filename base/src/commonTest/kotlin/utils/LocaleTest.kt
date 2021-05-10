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

import com.splendo.kaluga.base.utils.Locale
import com.splendo.kaluga.base.utils.UnitSystem
import kotlin.test.Test
import kotlin.test.assertEquals

class LocaleTest {

    @Test
    fun testLocaleUnitSystem() {
        val usLocale = Locale.createLocale("en", "US")
        assertEquals(UnitSystem.IMPERIAL, usLocale.unitSystem)
        val ukLocale = Locale.createLocale("en", "GB")
        assertEquals(UnitSystem.MIXED, ukLocale.unitSystem)
        val ruLocale = Locale.createLocale("ru", "RU")
        assertEquals(UnitSystem.METRIC, ruLocale.unitSystem)
    }
}
