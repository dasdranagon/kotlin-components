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

import com.splendo.kaluga.scientific.Density
import com.splendo.kaluga.scientific.ImperialDensity
import com.splendo.kaluga.scientific.ImperialLength
import com.splendo.kaluga.scientific.Length
import com.splendo.kaluga.scientific.MeasurementType
import com.splendo.kaluga.scientific.MetricDensity
import com.splendo.kaluga.scientific.MetricLength
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.UKImperialDensity
import com.splendo.kaluga.scientific.USCustomaryDensity
import com.splendo.kaluga.scientific.converter.density.times
import kotlin.jvm.JvmName

@JvmName("metricLengthTimesMetricDensity")
infix operator fun <LengthUnit : MetricLength> ScientificValue<MeasurementType.Length, LengthUnit>.times(density: ScientificValue<MeasurementType.Density, MetricDensity>) = density * this
@JvmName("imperialLengthTimesImperialDensity")
infix operator fun <LengthUnit : ImperialLength> ScientificValue<MeasurementType.Length, LengthUnit>.times(density: ScientificValue<MeasurementType.Density, ImperialDensity>) = density * this
@JvmName("imperialLengthTimesUKImperialDensity")
infix operator fun <LengthUnit : ImperialLength> ScientificValue<MeasurementType.Length, LengthUnit>.times(density: ScientificValue<MeasurementType.Density, UKImperialDensity>) = density * this
@JvmName("imperialLengthTimesUSCustomaryDensity")
infix operator fun <LengthUnit : ImperialLength> ScientificValue<MeasurementType.Length, LengthUnit>.times(density: ScientificValue<MeasurementType.Density, USCustomaryDensity>) = density * this
@JvmName("lengthTimesDensity")
infix operator fun <DensityUnit : Density, LengthUnit : Length> ScientificValue<MeasurementType.Length, LengthUnit>.times(density: ScientificValue<MeasurementType.Density, DensityUnit>) = density * this
