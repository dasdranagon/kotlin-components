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
import com.splendo.kaluga.scientific.PhysicalQuantity
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.byMultiplying
import com.splendo.kaluga.scientific.unit.Force
import com.splendo.kaluga.scientific.unit.Momentum
import com.splendo.kaluga.scientific.unit.Time
import kotlin.jvm.JvmName

@JvmName("momentumFromForceAndTimeDefault")
fun <
    ForceUnit : Force,
    TimeUnit : Time,
    MomentumUnit : Momentum
    > MomentumUnit.momentum(
    force: ScientificValue<PhysicalQuantity.Force, ForceUnit>,
    time: ScientificValue<PhysicalQuantity.Time, TimeUnit>
) = momentum(force, time, ::DefaultScientificValue)

@JvmName("momentumFromForceAndTime")
fun <
    ForceUnit : Force,
    TimeUnit : Time,
    MomentumUnit : Momentum,
    Value : ScientificValue<PhysicalQuantity.Momentum, MomentumUnit>
    > MomentumUnit.momentum(
    force: ScientificValue<PhysicalQuantity.Force, ForceUnit>,
    time: ScientificValue<PhysicalQuantity.Time, TimeUnit>,
    factory: (Decimal, MomentumUnit) -> Value
) = byMultiplying(force, time, factory)
