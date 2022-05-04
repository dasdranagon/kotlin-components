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

package com.splendo.kaluga.scientific.converter.length

import com.splendo.kaluga.base.utils.Decimal
import com.splendo.kaluga.scientific.DefaultScientificValue
import com.splendo.kaluga.scientific.PhysicalQuantity
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.byMultiplying
import com.splendo.kaluga.scientific.unit.AreaDensity
import com.splendo.kaluga.scientific.unit.Length
import com.splendo.kaluga.scientific.unit.SpecificVolume
import kotlin.jvm.JvmName

@JvmName("lengthFromAreaDensityAndSpecificVolumeDefault")
fun <
    SpecificVolumeUnit : SpecificVolume,
    LengthUnit : Length,
    AreaDensityUnit : AreaDensity
    > LengthUnit.length(
    specificVolume: ScientificValue<PhysicalQuantity.SpecificVolume, SpecificVolumeUnit>,
    areaDensity: ScientificValue<PhysicalQuantity.AreaDensity, AreaDensityUnit>
) = length(specificVolume, areaDensity, ::DefaultScientificValue)

@JvmName("lengthFromAreaDensityAndSpecificVolume")
fun <
    SpecificVolumeUnit : SpecificVolume,
    LengthUnit : Length,
    AreaDensityUnit : AreaDensity,
    Value : ScientificValue<PhysicalQuantity.Length, LengthUnit>
    > LengthUnit.length(
    specificVolume: ScientificValue<PhysicalQuantity.SpecificVolume, SpecificVolumeUnit>,
    areaDensity: ScientificValue<PhysicalQuantity.AreaDensity, AreaDensityUnit>,
    factory: (Decimal, LengthUnit) -> Value
) = byMultiplying(specificVolume, areaDensity, factory)
