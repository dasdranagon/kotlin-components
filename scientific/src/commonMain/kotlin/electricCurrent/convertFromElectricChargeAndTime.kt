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

package com.splendo.kaluga.scientific.electricCurrent

import com.splendo.kaluga.scientific.ElectricCharge
import com.splendo.kaluga.scientific.ElectricCurrent
import com.splendo.kaluga.scientific.MeasurementType
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.Time
import com.splendo.kaluga.scientific.byDividing
import kotlin.jvm.JvmName

@JvmName("currentFromChargeAndTime")
fun <
    CurrentUnit : ElectricCurrent,
    TimeUnit : Time,
    ChargeUnit : ElectricCharge
    >
    CurrentUnit.current(
    charge: ScientificValue<MeasurementType.ElectricCharge, ChargeUnit>,
    per: ScientificValue<MeasurementType.Time, TimeUnit>
) : ScientificValue<MeasurementType.ElectricCurrent, CurrentUnit> = byDividing(charge, per)
