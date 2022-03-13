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

package com.splendo.kaluga.scientific.converter.luminousFlux

import com.splendo.kaluga.scientific.PhysicalQuantity
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.converter.solidAngle.solidAngle
import com.splendo.kaluga.scientific.unit.LuminousFlux
import com.splendo.kaluga.scientific.unit.LuminousIntensity
import com.splendo.kaluga.scientific.unit.Steradian
import kotlin.jvm.JvmName

@JvmName("luminousFluxDivIntensity")
infix operator fun <FluxUnit : LuminousFlux, IntensityUnit : LuminousIntensity> ScientificValue<PhysicalQuantity.LuminousFlux, FluxUnit>.div(
    intensity: ScientificValue<PhysicalQuantity.LuminousIntensity, IntensityUnit>
) = Steradian.solidAngle(this, intensity)
