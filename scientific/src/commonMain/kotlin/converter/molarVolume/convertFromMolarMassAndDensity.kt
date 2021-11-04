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

package com.splendo.kaluga.scientific.converter.molarVolume

import com.splendo.kaluga.base.utils.Decimal
import com.splendo.kaluga.scientific.DefaultScientificValue
import com.splendo.kaluga.scientific.Density
import com.splendo.kaluga.scientific.MeasurementType
import com.splendo.kaluga.scientific.MolarMass
import com.splendo.kaluga.scientific.MolarVolume
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.byDividing
import kotlin.jvm.JvmName

@JvmName("molarVolumeFromMolarMassAndDensityDefault")
fun <
    MolarMassUnit : MolarMass,
    DensityUnit : Density,
    MolarVolumeUnit : MolarVolume
> MolarVolumeUnit.molarVolume(
    molarMass: ScientificValue<MeasurementType.MolarMass, MolarMassUnit>,
    density: ScientificValue<MeasurementType.Density, DensityUnit>
) = molarVolume(molarMass, density, ::DefaultScientificValue)

@JvmName("molarVolumeFromMolarMassAndDensity")
fun <
    MolarMassUnit : MolarMass,
    DensityUnit : Density,
    MolarVolumeUnit : MolarVolume,
    Value : ScientificValue<MeasurementType.MolarVolume, MolarVolumeUnit>
> MolarVolumeUnit.molarVolume(
    molarMass: ScientificValue<MeasurementType.MolarMass, MolarMassUnit>,
    density: ScientificValue<MeasurementType.Density, DensityUnit>,
    factory: (Decimal, MolarVolumeUnit) -> Value
) = byDividing(molarMass, density, factory)
