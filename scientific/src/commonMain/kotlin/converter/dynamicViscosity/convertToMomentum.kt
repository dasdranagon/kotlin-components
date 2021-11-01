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

package com.splendo.kaluga.scientific.converter.dynamicViscosity

import com.splendo.kaluga.scientific.Area
import com.splendo.kaluga.scientific.DynamicViscosity
import com.splendo.kaluga.scientific.ImperialArea
import com.splendo.kaluga.scientific.ImperialDynamicViscosity
import com.splendo.kaluga.scientific.MeasurementType
import com.splendo.kaluga.scientific.MetricArea
import com.splendo.kaluga.scientific.MetricDynamicViscosity
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.UKImperialDynamicViscosity
import com.splendo.kaluga.scientific.USCustomaryDynamicViscosity
import com.splendo.kaluga.scientific.converter.force.times
import com.splendo.kaluga.scientific.converter.momentum.momentum
import com.splendo.kaluga.scientific.converter.pressure.times
import com.splendo.kaluga.scientific.invoke
import kotlin.jvm.JvmName

@JvmName("metricDynamicViscosityTimesMetricArea")
infix operator fun <AreaUnit : MetricArea> ScientificValue<MeasurementType.DynamicViscosity, MetricDynamicViscosity>.times(area: ScientificValue<MeasurementType.Area, AreaUnit>) = ((1(unit.pressure) * area) * 1(unit.time)).unit.momentum(this, area)
@JvmName("imperialDynamicViscosityTimesImperialArea")
infix operator fun <AreaUnit : ImperialArea> ScientificValue<MeasurementType.DynamicViscosity, ImperialDynamicViscosity>.times(area: ScientificValue<MeasurementType.Area, AreaUnit>) = ((1(unit.pressure) * area) * 1(unit.time)).unit.momentum(this, area)
@JvmName("ukImperialDynamicViscosityTimesImperialArea")
infix operator fun <AreaUnit : ImperialArea> ScientificValue<MeasurementType.DynamicViscosity, UKImperialDynamicViscosity>.times(area: ScientificValue<MeasurementType.Area, AreaUnit>) = ((1(unit.pressure) * area) * 1(unit.time)).unit.momentum(this, area)
@JvmName("usCustomaryDynamicViscosityTimesImperialArea")
infix operator fun <AreaUnit : ImperialArea> ScientificValue<MeasurementType.DynamicViscosity, USCustomaryDynamicViscosity>.times(area: ScientificValue<MeasurementType.Area, AreaUnit>) = ((1(unit.pressure) * area) * 1(unit.time)).unit.momentum(this, area)
@JvmName("dynamicViscosityTimesArea")
infix operator fun <DynamicViscosityUnit : DynamicViscosity, AreaUnit : Area> ScientificValue<MeasurementType.DynamicViscosity, DynamicViscosityUnit>.times(area: ScientificValue<MeasurementType.Area, AreaUnit>) = ((1(unit.pressure) * area) * 1(unit.time)).unit.momentum(this, area)
