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

package com.splendo.kaluga.scientific.unit

import com.splendo.kaluga.scientific.converter.illuminance.times
import com.splendo.kaluga.scientific.converter.luminousEnergy.div
import com.splendo.kaluga.scientific.converter.luminousFlux.times
import com.splendo.kaluga.scientific.invoke
import kotlin.test.Test
import kotlin.test.assertEquals

class LuminousExposureUnitTest {

    @Test
    fun luminousExposureConversionTest() {
        // assertEquals(0.092903, (Lux x Minute).convert(2, FootCandle x Minute, 6)) FIXME find if expect is correct
    }

    @Test
    fun luminousExposureFromIlluminanceAndTimeTest() {
        assertEquals(4(Lux x Second), 2(Lux) * 2(Second))
        assertEquals(4(FootCandle x Second), 2(FootCandle) * 2(Second))
    }

    @Test
    fun luminousExposureFromLuminousEnergyAndAreaTest() {
        // assertEquals(1(Lux x Second), 2(Lumen x Second) / 2(SquareMeter)) FIXME
        // assertEquals(1(FootCandle x Second), 2(Lumen x Second) / 2(SquareFoot)) FIXME
    }
}
