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

package com.splendo.kaluga.scientific.converter.molarMass

import com.splendo.kaluga.base.utils.Decimal
import com.splendo.kaluga.scientific.DefaultScientificValue
import com.splendo.kaluga.scientific.PhysicalQuantity
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.byMultiplying
import com.splendo.kaluga.scientific.unit.Density
import com.splendo.kaluga.scientific.unit.MolarMass
import com.splendo.kaluga.scientific.unit.MolarVolume
import kotlin.jvm.JvmName

@JvmName("molarMassFromDensityAndMolarVolumeDefault")
fun <
    MolarMassUnit : MolarMass,
    DensityUnit : Density,
    MolarVolumeUnit : MolarVolume
    > MolarMassUnit.molarMass(
    molarVolume: ScientificValue<PhysicalQuantity.MolarVolume, MolarVolumeUnit>,
    density: ScientificValue<PhysicalQuantity.Density, DensityUnit>
) = molarMass(molarVolume, density, ::DefaultScientificValue)

@JvmName("molarMassFromDensityAndMolarVolume")
fun <
    MolarMassUnit : MolarMass,
    DensityUnit : Density,
    MolarVolumeUnit : MolarVolume,
    Value : ScientificValue<PhysicalQuantity.MolarMass, MolarMassUnit>
    > MolarMassUnit.molarMass(
    molarVolume: ScientificValue<PhysicalQuantity.MolarVolume, MolarVolumeUnit>,
    density: ScientificValue<PhysicalQuantity.Density, DensityUnit>,
    factory: (Decimal, MolarMassUnit) -> Value
) = byMultiplying(molarVolume, density, factory)
