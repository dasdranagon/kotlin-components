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

package com.splendo.kaluga.scientific.converter.luminousExposure

import com.splendo.kaluga.base.utils.Decimal
import com.splendo.kaluga.scientific.DefaultScientificValue
import com.splendo.kaluga.scientific.PhysicalQuantity
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.byMultiplying
import com.splendo.kaluga.scientific.unit.Illuminance
import com.splendo.kaluga.scientific.unit.LuminousExposure
import com.splendo.kaluga.scientific.unit.Time
import kotlin.jvm.JvmName

@JvmName("luminousExposureFromIlluminanceAndTimeDefault")
fun <
    LuminousExposureUnit : LuminousExposure,
    TimeUnit : Time,
    IlluminanceUnit : Illuminance
    > LuminousExposureUnit.luminousExposure(
    illuminance: ScientificValue<PhysicalQuantity.Illuminance, IlluminanceUnit>,
    time: ScientificValue<PhysicalQuantity.Time, TimeUnit>
) = luminousExposure(illuminance, time, ::DefaultScientificValue)

@JvmName("luminousExposureFromIlluminanceAndTime")
fun <
    LuminousExposureUnit : LuminousExposure,
    TimeUnit : Time,
    IlluminanceUnit : Illuminance,
    Value : ScientificValue<PhysicalQuantity.LuminousExposure, LuminousExposureUnit>
    > LuminousExposureUnit.luminousExposure(
    illuminance: ScientificValue<PhysicalQuantity.Illuminance, IlluminanceUnit>,
    time: ScientificValue<PhysicalQuantity.Time, TimeUnit>,
    factory: (Decimal, LuminousExposureUnit) -> Value
) = byMultiplying(illuminance, time, factory)
