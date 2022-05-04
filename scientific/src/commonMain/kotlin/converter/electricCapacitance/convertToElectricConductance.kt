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

package com.splendo.kaluga.scientific.converter.electricCapacitance

import com.splendo.kaluga.scientific.PhysicalQuantity
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.converter.electricConductance.conductance
import com.splendo.kaluga.scientific.unit.Abfarad
import com.splendo.kaluga.scientific.unit.Absiemens
import com.splendo.kaluga.scientific.unit.ElectricCapacitance
import com.splendo.kaluga.scientific.unit.Frequency
import com.splendo.kaluga.scientific.unit.Siemens
import kotlin.jvm.JvmName

@JvmName("abfaradTimesFrequency")
infix operator fun <FrequencyUnit : Frequency> ScientificValue<PhysicalQuantity.ElectricCapacitance, Abfarad>.times(
    frequency: ScientificValue<PhysicalQuantity.Frequency, FrequencyUnit>
) = Absiemens.conductance(this, frequency)

@JvmName("capacitanceTimesFrequency")
infix operator fun <CapacitanceUnit : ElectricCapacitance, FrequencyUnit : Frequency> ScientificValue<PhysicalQuantity.ElectricCapacitance, CapacitanceUnit>.times(
    frequency: ScientificValue<PhysicalQuantity.Frequency, FrequencyUnit>
) = Siemens.conductance(this, frequency)
