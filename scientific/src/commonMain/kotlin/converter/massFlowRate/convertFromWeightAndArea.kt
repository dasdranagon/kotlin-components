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

package com.splendo.kaluga.scientific.converter.massFlowRate

import com.splendo.kaluga.base.utils.Decimal
import com.splendo.kaluga.scientific.DefaultScientificValue
import com.splendo.kaluga.scientific.MassFlowRate
import com.splendo.kaluga.scientific.MeasurementType
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.Time
import com.splendo.kaluga.scientific.Weight
import com.splendo.kaluga.scientific.byDividing
import kotlin.jvm.JvmName

@JvmName("massFlowRateFromWeightAndAreaDefault")
fun <
    WeightUnit : Weight,
    TimeUnit : Time,
    MassFlowRateUnit : MassFlowRate
> MassFlowRateUnit.massFlowRate(
    weight: ScientificValue<MeasurementType.Weight, WeightUnit>,
    time: ScientificValue<MeasurementType.Time, TimeUnit>
) = massFlowRate(weight, time, ::DefaultScientificValue)

@JvmName("massFlowRateFromWeightAndArea")
fun <
    WeightUnit : Weight,
    TimeUnit : Time,
    MassFlowRateUnit : MassFlowRate,
    Value : ScientificValue<MeasurementType.MassFlowRate, MassFlowRateUnit>
> MassFlowRateUnit.massFlowRate(
    weight: ScientificValue<MeasurementType.Weight, WeightUnit>,
    time: ScientificValue<MeasurementType.Time, TimeUnit>,
    factory: (Decimal, MassFlowRateUnit) -> Value
) = byDividing(weight, time, factory)
