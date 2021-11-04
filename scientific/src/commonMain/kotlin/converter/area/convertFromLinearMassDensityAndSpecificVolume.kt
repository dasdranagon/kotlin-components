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

package com.splendo.kaluga.scientific.converter.area

import com.splendo.kaluga.base.utils.Decimal
import com.splendo.kaluga.scientific.Area
import com.splendo.kaluga.scientific.DefaultScientificValue
import com.splendo.kaluga.scientific.LinearMassDensity
import com.splendo.kaluga.scientific.MeasurementType
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.SpecificVolume
import com.splendo.kaluga.scientific.byMultiplying
import kotlin.jvm.JvmName

@JvmName("areaFromLinearMassDensityAndSpecificVolumeDefault")
fun <
    SpecificVolumeUnit : SpecificVolume,
    AreaUnit : Area,
    LinearMassDensityUnit : LinearMassDensity
> AreaUnit.area(
    specificVolume: ScientificValue<MeasurementType.SpecificVolume, SpecificVolumeUnit>,
    linearMassDensity: ScientificValue<MeasurementType.LinearMassDensity, LinearMassDensityUnit>
) = area(specificVolume, linearMassDensity, ::DefaultScientificValue)

@JvmName("areaFromLinearMassDensityAndSpecificVolume")
fun <
    SpecificVolumeUnit : SpecificVolume,
    AreaUnit : Area,
    LinearMassDensityUnit : LinearMassDensity,
    Value : ScientificValue<MeasurementType.Area, AreaUnit>
> AreaUnit.area(
    specificVolume: ScientificValue<MeasurementType.SpecificVolume, SpecificVolumeUnit>,
    linearMassDensity: ScientificValue<MeasurementType.LinearMassDensity, LinearMassDensityUnit>,
    factory: (Decimal, AreaUnit) -> Value
) = byMultiplying(specificVolume, linearMassDensity, factory)
