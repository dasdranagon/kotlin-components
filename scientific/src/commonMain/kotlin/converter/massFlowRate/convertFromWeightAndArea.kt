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

package com.splendo.kaluga.scientific.converter.massFlowRate

import com.splendo.kaluga.base.utils.Decimal
import com.splendo.kaluga.scientific.DefaultScientificValue
import com.splendo.kaluga.scientific.PhysicalQuantity
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.byDividing
import com.splendo.kaluga.scientific.unit.MassFlowRate
import com.splendo.kaluga.scientific.unit.Power
import com.splendo.kaluga.scientific.unit.SpecificEnergy
import kotlin.jvm.JvmName

@JvmName("massFlowRateFromPowerAndSpecificEnergyDefault")
fun <
    PowerUnit : Power,
    SpecificEnergyUnit : SpecificEnergy,
    MassFlowRateUnit : MassFlowRate,
    > MassFlowRateUnit.massFlowRate(
    power: ScientificValue<PhysicalQuantity.Power, PowerUnit>,
    specificEnergy: ScientificValue<PhysicalQuantity.SpecificEnergy, SpecificEnergyUnit>,
) = massFlowRate(power, specificEnergy, ::DefaultScientificValue)

@JvmName("massFlowRateFromPowerAndSpecificEnergy")
fun <
    PowerUnit : Power,
    SpecificEnergyUnit : SpecificEnergy,
    MassFlowRateUnit : MassFlowRate,
    Value : ScientificValue<PhysicalQuantity.MassFlowRate, MassFlowRateUnit>,
    > MassFlowRateUnit.massFlowRate(
    power: ScientificValue<PhysicalQuantity.Power, PowerUnit>,
    specificEnergy: ScientificValue<PhysicalQuantity.SpecificEnergy, SpecificEnergyUnit>,
    factory: (Decimal, MassFlowRateUnit) -> Value,
) = byDividing(power, specificEnergy, factory)
