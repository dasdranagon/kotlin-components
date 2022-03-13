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

package com.splendo.kaluga.scientific.converter.frequency

import com.splendo.kaluga.scientific.PhysicalQuantity
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.converter.electricCapacitance.times
import com.splendo.kaluga.scientific.unit.Abfarad
import com.splendo.kaluga.scientific.unit.ElectricCapacitance
import com.splendo.kaluga.scientific.unit.Frequency
import kotlin.jvm.JvmName

@JvmName("frequencyTimesAbfarad")
infix operator fun <FrequencyUnit : Frequency> ScientificValue<PhysicalQuantity.Frequency, FrequencyUnit>.times(
    capacitance: ScientificValue<PhysicalQuantity.ElectricCapacitance, Abfarad>
) = capacitance * this

@JvmName("frequencyTimesCapacitance")
infix operator fun <CapacitanceUnit : ElectricCapacitance, FrequencyUnit : Frequency> ScientificValue<PhysicalQuantity.Frequency, FrequencyUnit>.times(
    capacitance: ScientificValue<PhysicalQuantity.ElectricCapacitance, CapacitanceUnit>
) = capacitance * this
