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
import com.splendo.kaluga.scientific.byDividing
import com.splendo.kaluga.scientific.unit.Force
import com.splendo.kaluga.scientific.unit.Length
import com.splendo.kaluga.scientific.unit.SurfaceTension
import kotlin.jvm.JvmName

@JvmName("lengthFromForceAndSurfaceTensionDefault")
fun <
    ForceUnit : Force,
    LengthUnit : Length,
    SurfaceTensionUnit : SurfaceTension
    > LengthUnit.length(
    force: ScientificValue<PhysicalQuantity.Force, ForceUnit>,
    surfaceTension: ScientificValue<PhysicalQuantity.SurfaceTension, SurfaceTensionUnit>
) = length(force, surfaceTension, ::DefaultScientificValue)

@JvmName("lengthFromForceAndSurfaceTension")
fun <
    ForceUnit : Force,
    LengthUnit : Length,
    SurfaceTensionUnit : SurfaceTension,
    Value : ScientificValue<PhysicalQuantity.Length, LengthUnit>
    > LengthUnit.length(
    force: ScientificValue<PhysicalQuantity.Force, ForceUnit>,
    surfaceTension: ScientificValue<PhysicalQuantity.SurfaceTension, SurfaceTensionUnit>,
    factory: (Decimal, LengthUnit) -> Value
) = byDividing(force, surfaceTension, factory)
