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

import com.splendo.kaluga.scientific.converter.electricCapacitance.times
import com.splendo.kaluga.scientific.converter.electricCurrent.div
import com.splendo.kaluga.scientific.converter.electricResistance.conductance
import com.splendo.kaluga.scientific.converter.frequency.times
import com.splendo.kaluga.scientific.invoke
import kotlin.test.Test
import kotlin.test.assertEquals

class ElectricConductanceUnitTest {

    @Test
    fun electricConductanceConversionTest() {
        assertScientificConversion(1, Siemens, 1e+9, Nanosiemens)
        assertScientificConversion(1, Siemens, 1e+6, Microsiemens)
        assertScientificConversion(1, Siemens, 1000.0, Millisiemens)
        assertScientificConversion(1, Siemens, 100.0, Centisiemens)
        assertScientificConversion(1, Siemens, 10.0, Decisiemens)
        assertScientificConversion(1, Siemens, 0.1, Decasiemens)
        assertScientificConversion(1, Siemens, 0.01, Hectosiemens)
        assertScientificConversion(1, Siemens, 0.001, Kilosiemens)
        assertScientificConversion(1, Siemens, 1e-6, Megasiemens)
        assertScientificConversion(1, Siemens, 1e-9, Gigasiemens)
        assertScientificConversion(1, Siemens, 1e-9, Absiemens)
    }

    @Test
    fun conductanceFromCapacitanceAndFrequencyTest() {
        assertEquals(4(Absiemens), 2(Abfarad) * 2(Hertz))
        assertEquals(4(Absiemens), 2(Hertz) * 2(Abfarad))
        assertEquals(4(Siemens), 2(Farad) * 2(Hertz))
        assertEquals(4(Siemens), 2(Hertz) * 2(Farad))
        assertEquals(4(Absiemens), 2(Abfarad) * 2(Hertz))
        assertEquals(4(Absiemens), 2(Hertz) * 2(Abfarad))
    }

    @Test
    fun conductanceFromCurrentAndVoltageTest() {
        assertEquals(1(Absiemens), 2(Abampere) / 2(Abvolt))
        assertEquals(1(Absiemens), 2(Biot) / 2(Abvolt))
        assertEquals(1(Siemens), 2(Ampere) / 2(Volt))
        assertEquals(1(Absiemens), 2(Abampere) / 2(Abvolt))
    }

    @Test
    fun electricConductanceFromInvertedResistanceTest() {
        assertEquals(1(Absiemens), 1(Abohm).conductance())
        assertEquals(1(Siemens), 1(Ohm).conductance())
        assertEquals(1(Absiemens), 1(Abohm).conductance())
    }
}
