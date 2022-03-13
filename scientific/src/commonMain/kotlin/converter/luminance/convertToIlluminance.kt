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

package com.splendo.kaluga.scientific.converter.luminance

import com.splendo.kaluga.scientific.PhysicalQuantity
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.converter.illuminance.illuminance
import com.splendo.kaluga.scientific.unit.FootCandle
import com.splendo.kaluga.scientific.unit.ImperialLuminance
import com.splendo.kaluga.scientific.unit.Lambert
import com.splendo.kaluga.scientific.unit.Luminance
import com.splendo.kaluga.scientific.unit.Lux
import com.splendo.kaluga.scientific.unit.MetricLuminance
import com.splendo.kaluga.scientific.unit.Phot
import com.splendo.kaluga.scientific.unit.SolidAngle
import com.splendo.kaluga.scientific.unit.Stilb
import kotlin.jvm.JvmName

@JvmName("stilbTimesSolidAngle")
infix operator fun <SolidAngleUnit : SolidAngle> ScientificValue<PhysicalQuantity.Luminance, Stilb>.times(
    solidAngle: ScientificValue<PhysicalQuantity.SolidAngle, SolidAngleUnit>
) = Phot.illuminance(this, solidAngle)

@JvmName("lambertTimesSolidAngle")
infix operator fun <SolidAngleUnit : SolidAngle> ScientificValue<PhysicalQuantity.Luminance, Lambert>.times(
    solidAngle: ScientificValue<PhysicalQuantity.SolidAngle, SolidAngleUnit>
) = Phot.illuminance(this, solidAngle)

@JvmName("metricLuminanceTimesSolidAngle")
infix operator fun <LuminanceUnit : MetricLuminance, SolidAngleUnit : SolidAngle> ScientificValue<PhysicalQuantity.Luminance, LuminanceUnit>.times(
    solidAngle: ScientificValue<PhysicalQuantity.SolidAngle, SolidAngleUnit>
) = Lux.illuminance(this, solidAngle)

@JvmName("imperialLuminanceTimesSolidAngle")
infix operator fun <LuminanceUnit : ImperialLuminance, SolidAngleUnit : SolidAngle> ScientificValue<PhysicalQuantity.Luminance, LuminanceUnit>.times(
    solidAngle: ScientificValue<PhysicalQuantity.SolidAngle, SolidAngleUnit>
) = FootCandle.illuminance(this, solidAngle)

@JvmName("luminanceTimesSolidAngle")
infix operator fun <LuminanceUnit : Luminance, SolidAngleUnit : SolidAngle> ScientificValue<PhysicalQuantity.Luminance, LuminanceUnit>.times(
    solidAngle: ScientificValue<PhysicalQuantity.SolidAngle, SolidAngleUnit>
) = Lux.illuminance(this, solidAngle)
