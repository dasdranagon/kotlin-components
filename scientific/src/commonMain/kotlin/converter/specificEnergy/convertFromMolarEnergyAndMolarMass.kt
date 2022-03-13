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

package com.splendo.kaluga.scientific.converter.specificEnergy

import com.splendo.kaluga.base.utils.Decimal
import com.splendo.kaluga.scientific.DefaultScientificValue
import com.splendo.kaluga.scientific.PhysicalQuantity
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.byDividing
import com.splendo.kaluga.scientific.unit.MolarEnergy
import com.splendo.kaluga.scientific.unit.MolarMass
import com.splendo.kaluga.scientific.unit.SpecificEnergy
import kotlin.jvm.JvmName

@JvmName("specificEnergyFromMolarEnergyAndMolarMassDefault")
fun <
    MolarEnergyUnit : MolarEnergy,
    MolarMassUnit : MolarMass,
    SpecificEnergyUnit : SpecificEnergy
    > SpecificEnergyUnit.specificEnergy(
    molarEnergy: ScientificValue<PhysicalQuantity.MolarEnergy, MolarEnergyUnit>,
    molarMass: ScientificValue<PhysicalQuantity.MolarMass, MolarMassUnit>
) = specificEnergy(molarEnergy, molarMass, ::DefaultScientificValue)

@JvmName("specificEnergyFromMolarEnergyAndMolarMass")
fun <
    MolarEnergyUnit : MolarEnergy,
    MolarMassUnit : MolarMass,
    SpecificEnergyUnit : SpecificEnergy,
    Value : ScientificValue<PhysicalQuantity.SpecificEnergy, SpecificEnergyUnit>
    > SpecificEnergyUnit.specificEnergy(
    molarEnergy: ScientificValue<PhysicalQuantity.MolarEnergy, MolarEnergyUnit>,
    molarMass: ScientificValue<PhysicalQuantity.MolarMass, MolarMassUnit>,
    factory: (Decimal, SpecificEnergyUnit) -> Value
) = byDividing(molarEnergy, molarMass, factory)
