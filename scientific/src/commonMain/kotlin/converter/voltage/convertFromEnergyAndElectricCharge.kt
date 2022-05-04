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

package com.splendo.kaluga.scientific.converter.voltage

import com.splendo.kaluga.base.utils.Decimal
import com.splendo.kaluga.scientific.DefaultScientificValue
import com.splendo.kaluga.scientific.PhysicalQuantity
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.byDividing
import com.splendo.kaluga.scientific.unit.ElectricCharge
import com.splendo.kaluga.scientific.unit.Energy
import com.splendo.kaluga.scientific.unit.Voltage
import kotlin.jvm.JvmName

@JvmName("voltageFromEnergyAndChargeDefault")
fun <
    VoltageUnit : Voltage,
    EnergyUnit : Energy,
    ChargeUnit : ElectricCharge
    > VoltageUnit.voltage(
    energy: ScientificValue<PhysicalQuantity.Energy, EnergyUnit>,
    charge: ScientificValue<PhysicalQuantity.ElectricCharge, ChargeUnit>
) = voltage(energy, charge, ::DefaultScientificValue)

@JvmName("voltageFromEnergyAndCharge")
fun <
    VoltageUnit : Voltage,
    EnergyUnit : Energy,
    ChargeUnit : ElectricCharge,
    Value : ScientificValue<PhysicalQuantity.Voltage, VoltageUnit>
    > VoltageUnit.voltage(
    energy: ScientificValue<PhysicalQuantity.Energy, EnergyUnit>,
    charge: ScientificValue<PhysicalQuantity.ElectricCharge, ChargeUnit>,
    factory: (Decimal, VoltageUnit) -> Value
) = byDividing(energy, charge, factory)
