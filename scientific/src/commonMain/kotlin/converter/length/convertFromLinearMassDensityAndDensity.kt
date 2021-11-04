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
import com.splendo.kaluga.scientific.AreaDensity
import com.splendo.kaluga.scientific.DefaultScientificValue
import com.splendo.kaluga.scientific.Length
import com.splendo.kaluga.scientific.LinearMassDensity
import com.splendo.kaluga.scientific.MeasurementType
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.byDividing
import kotlin.jvm.JvmName

@JvmName("lengthFromLinearMassDensityAndDensityDefault")
fun <
    AreaDensityUnit : AreaDensity,
    LengthUnit : Length,
    LinearMassDensityUnit : LinearMassDensity
> LengthUnit.length(
    linearMassDensity: ScientificValue<MeasurementType.LinearMassDensity, LinearMassDensityUnit>,
    areaDensity: ScientificValue<MeasurementType.AreaDensity, AreaDensityUnit>
) = length(linearMassDensity, areaDensity, ::DefaultScientificValue)

@JvmName("lengthFromLinearMassDensityAndDensity")
fun <
    AreaDensityUnit : AreaDensity,
    LengthUnit : Length,
    LinearMassDensityUnit : LinearMassDensity,
    Value : ScientificValue<MeasurementType.Length, LengthUnit>
> LengthUnit.length(
    linearMassDensity: ScientificValue<MeasurementType.LinearMassDensity, LinearMassDensityUnit>,
    areaDensity: ScientificValue<MeasurementType.AreaDensity, AreaDensityUnit>,
    factory: (Decimal, LengthUnit) -> Value
) = byDividing(linearMassDensity, areaDensity, factory)
