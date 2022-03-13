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

package com.splendo.kaluga.scientific.converter.electricResistance

import com.splendo.kaluga.base.utils.Decimal
import com.splendo.kaluga.scientific.DefaultScientificValue
import com.splendo.kaluga.scientific.PhysicalQuantity
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.byDividing
import com.splendo.kaluga.scientific.unit.ElectricCurrent
import com.splendo.kaluga.scientific.unit.ElectricResistance
import com.splendo.kaluga.scientific.unit.Voltage
import kotlin.jvm.JvmName

@JvmName("resistanceFromVoltageAndCurrentDefault")
fun <
    CurrentUnit : ElectricCurrent,
    VoltageUnit : Voltage,
    ResistanceUnit : ElectricResistance
    > ResistanceUnit.resistance(
    voltage: ScientificValue<PhysicalQuantity.Voltage, VoltageUnit>,
    current: ScientificValue<PhysicalQuantity.ElectricCurrent, CurrentUnit>
) = resistance(voltage, current, ::DefaultScientificValue)

@JvmName("resistanceFromVoltageAndCurrent")
fun <
    CurrentUnit : ElectricCurrent,
    VoltageUnit : Voltage,
    ResistanceUnit : ElectricResistance,
    Value : ScientificValue<PhysicalQuantity.ElectricResistance, ResistanceUnit>
    > ResistanceUnit.resistance(
    voltage: ScientificValue<PhysicalQuantity.Voltage, VoltageUnit>,
    current: ScientificValue<PhysicalQuantity.ElectricCurrent, CurrentUnit>,
    factory: (Decimal, ResistanceUnit) -> Value
) = byDividing(voltage, current, factory)
