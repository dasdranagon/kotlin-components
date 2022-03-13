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
import com.splendo.kaluga.scientific.unit.Length
import com.splendo.kaluga.scientific.unit.Speed
import com.splendo.kaluga.scientific.unit.Time
import kotlin.jvm.JvmName

@JvmName("distanceFromSpeedAndTimeDefault")
fun <
    LengthUnit : Length,
    TimeUnit : Time,
    SpeedUnit : Speed
    > LengthUnit.distance(
    speed: ScientificValue<PhysicalQuantity.Speed, SpeedUnit>,
    time: ScientificValue<PhysicalQuantity.Time, TimeUnit>
) = distance(speed, time, ::DefaultScientificValue)

@JvmName("distanceFromSpeedAndTime")
fun <
    LengthUnit : Length,
    TimeUnit : Time,
    SpeedUnit : Speed,
    Value : ScientificValue<PhysicalQuantity.Length, LengthUnit>
    > LengthUnit.distance(
    speed: ScientificValue<PhysicalQuantity.Speed, SpeedUnit>,
    time: ScientificValue<PhysicalQuantity.Time, TimeUnit>,
    factory: (Decimal, LengthUnit) -> Value
) = byMultiplying(speed, time, factory)
