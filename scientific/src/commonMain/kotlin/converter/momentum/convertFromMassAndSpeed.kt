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

package com.splendo.kaluga.scientific.converter.momentum

import com.splendo.kaluga.base.utils.Decimal
import com.splendo.kaluga.scientific.DefaultScientificValue
import com.splendo.kaluga.scientific.MeasurementType
import com.splendo.kaluga.scientific.Momentum
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.Speed
import com.splendo.kaluga.scientific.Weight
import com.splendo.kaluga.scientific.byMultiplying
import kotlin.jvm.JvmName

@JvmName("momentumFromMassAndSpeedDefault")
fun <
    WeightUnit : Weight,
    SpeedUnit : Speed,
    MomentumUnit : Momentum
> MomentumUnit.momentum(
    mass: ScientificValue<MeasurementType.Weight, WeightUnit>,
    speed: ScientificValue<MeasurementType.Speed, SpeedUnit>
) = momentum(mass, speed, ::DefaultScientificValue)

@JvmName("momentumFromMassAndSpeed")
fun <
    WeightUnit : Weight,
    SpeedUnit : Speed,
    MomentumUnit : Momentum,
    Value : ScientificValue<MeasurementType.Momentum, MomentumUnit>
> MomentumUnit.momentum(
    mass: ScientificValue<MeasurementType.Weight, WeightUnit>,
    speed: ScientificValue<MeasurementType.Speed, SpeedUnit>,
    factory: (Decimal, MomentumUnit) -> Value
) = byMultiplying(mass, speed, factory)
