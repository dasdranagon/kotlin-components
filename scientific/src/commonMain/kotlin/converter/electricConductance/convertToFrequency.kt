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

package com.splendo.kaluga.scientific.converter.electricConductance

import com.splendo.kaluga.scientific.PhysicalQuantity
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.converter.frequency.frequency
import com.splendo.kaluga.scientific.unit.ElectricCapacitance
import com.splendo.kaluga.scientific.unit.ElectricConductance
import com.splendo.kaluga.scientific.unit.Hertz
import kotlin.jvm.JvmName

@JvmName("conductanceDivCapacitance")
infix operator fun <ConductanceUnit : ElectricConductance, CapacitanceUnit : ElectricCapacitance> ScientificValue<PhysicalQuantity.ElectricConductance, ConductanceUnit>.div(
    capacitance: ScientificValue<PhysicalQuantity.ElectricCapacitance, CapacitanceUnit>
) = Hertz.frequency(this, capacitance)
