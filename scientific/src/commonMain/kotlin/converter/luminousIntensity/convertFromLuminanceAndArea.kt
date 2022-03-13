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

package com.splendo.kaluga.scientific.converter.luminousIntensity

import com.splendo.kaluga.base.utils.Decimal
import com.splendo.kaluga.scientific.DefaultScientificValue
import com.splendo.kaluga.scientific.PhysicalQuantity
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.byMultiplying
import com.splendo.kaluga.scientific.unit.Area
import com.splendo.kaluga.scientific.unit.Luminance
import com.splendo.kaluga.scientific.unit.LuminousIntensity
import kotlin.jvm.JvmName

@JvmName("luminousIntensityFromLuminanceAndAreaDefault")
fun <
    LuminousIntensityUnit : LuminousIntensity,
    AreaUnit : Area,
    LuminanceUnit : Luminance
    > LuminousIntensityUnit.luminousIntensity(
    luminance: ScientificValue<PhysicalQuantity.Luminance, LuminanceUnit>,
    area: ScientificValue<PhysicalQuantity.Area, AreaUnit>
) = luminousIntensity(luminance, area, ::DefaultScientificValue)

@JvmName("luminousIntensityFromLuminanceAndArea")
fun <
    LuminousIntensityUnit : LuminousIntensity,
    AreaUnit : Area,
    LuminanceUnit : Luminance,
    Value : ScientificValue<PhysicalQuantity.LuminousIntensity, LuminousIntensityUnit>
    > LuminousIntensityUnit.luminousIntensity(
    luminance: ScientificValue<PhysicalQuantity.Luminance, LuminanceUnit>,
    area: ScientificValue<PhysicalQuantity.Area, AreaUnit>,
    factory: (Decimal, LuminousIntensityUnit) -> Value
) = byMultiplying(luminance, area, factory)
