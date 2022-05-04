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

package com.splendo.kaluga.scientific.converter.solidAngle

import com.splendo.kaluga.base.utils.Decimal
import com.splendo.kaluga.scientific.DefaultScientificValue
import com.splendo.kaluga.scientific.PhysicalQuantity
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.byDividing
import com.splendo.kaluga.scientific.unit.LuminousFlux
import com.splendo.kaluga.scientific.unit.LuminousIntensity
import com.splendo.kaluga.scientific.unit.SolidAngle
import kotlin.jvm.JvmName

@JvmName("solidAngleFromLuminousFluxAndIntensityDefault")
fun <
    IntensityUnit : LuminousIntensity,
    SolidAngleUnit : SolidAngle,
    FluxUnit : LuminousFlux
    > SolidAngleUnit.solidAngle(
    flux: ScientificValue<PhysicalQuantity.LuminousFlux, FluxUnit>,
    intensity: ScientificValue<PhysicalQuantity.LuminousIntensity, IntensityUnit>
) = solidAngle(flux, intensity, ::DefaultScientificValue)

@JvmName("solidAngleFromLuminousFluxAndIntensity")
fun <
    IntensityUnit : LuminousIntensity,
    SolidAngleUnit : SolidAngle,
    FluxUnit : LuminousFlux,
    Value : ScientificValue<PhysicalQuantity.SolidAngle, SolidAngleUnit>
    > SolidAngleUnit.solidAngle(
    flux: ScientificValue<PhysicalQuantity.LuminousFlux, FluxUnit>,
    intensity: ScientificValue<PhysicalQuantity.LuminousIntensity, IntensityUnit>,
    factory: (Decimal, SolidAngleUnit) -> Value
) = byDividing(flux, intensity, factory)
