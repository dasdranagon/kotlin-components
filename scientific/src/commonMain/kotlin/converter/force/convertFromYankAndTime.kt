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

package com.splendo.kaluga.scientific.converter.force

import com.splendo.kaluga.base.utils.Decimal
import com.splendo.kaluga.scientific.DefaultScientificValue
import com.splendo.kaluga.scientific.Force
import com.splendo.kaluga.scientific.MeasurementType
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.Time
import com.splendo.kaluga.scientific.Yank
import com.splendo.kaluga.scientific.byMultiplying
import kotlin.jvm.JvmName

@JvmName("forceFromYankAndTimeDefault")
fun <
    ForceUnit : Force,
    TimeUnit : Time,
    YankUnit : Yank
> ForceUnit.force(
    yank: ScientificValue<MeasurementType.Yank, YankUnit>,
    time: ScientificValue<MeasurementType.Time, TimeUnit>
) = force(yank, time, ::DefaultScientificValue)

@JvmName("forceFromYankAndTime")
fun <
    ForceUnit : Force,
    TimeUnit : Time,
    YankUnit : Yank,
    Value : ScientificValue<MeasurementType.Force, ForceUnit>
> ForceUnit.force(
    yank: ScientificValue<MeasurementType.Yank, YankUnit>,
    time: ScientificValue<MeasurementType.Time, TimeUnit>,
    factory: (Decimal, ForceUnit) -> Value
) = byMultiplying(yank, time, factory)
