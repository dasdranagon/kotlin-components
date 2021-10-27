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

package com.splendo.kaluga.scientific.area

import com.splendo.kaluga.scientific.Area
import com.splendo.kaluga.scientific.Barye
import com.splendo.kaluga.scientific.ImperialArea
import com.splendo.kaluga.scientific.ImperialPressure
import com.splendo.kaluga.scientific.ImperialTonSquareFoot
import com.splendo.kaluga.scientific.ImperialTonSquareInch
import com.splendo.kaluga.scientific.KipSquareFoot
import com.splendo.kaluga.scientific.KipSquareInch
import com.splendo.kaluga.scientific.MeasurementSystem
import com.splendo.kaluga.scientific.MeasurementType
import com.splendo.kaluga.scientific.MetricArea
import com.splendo.kaluga.scientific.MetricMultipleUnit
import com.splendo.kaluga.scientific.MetricPressure
import com.splendo.kaluga.scientific.OunceSquareInch
import com.splendo.kaluga.scientific.Pressure
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.SquareCentimeter
import com.splendo.kaluga.scientific.UKImperialPressure
import com.splendo.kaluga.scientific.USCustomaryPressure
import com.splendo.kaluga.scientific.USTonSquareFoot
import com.splendo.kaluga.scientific.USTonSquareInch
import com.splendo.kaluga.scientific.pressure.times
import kotlin.jvm.JvmName

@JvmName("squareCentimeterTimesBarye")
operator fun ScientificValue<MeasurementType.Area, SquareCentimeter>.times(pressure: ScientificValue<MeasurementType.Pressure, Barye>) = pressure * this
@JvmName("squareCentimeterTimesBaryeMultiple")
operator fun <BaryeUnit> ScientificValue<MeasurementType.Area, SquareCentimeter>.times(pressure: ScientificValue<MeasurementType.Pressure, BaryeUnit>) where BaryeUnit : Pressure, BaryeUnit : MetricMultipleUnit<MeasurementSystem.Metric, MeasurementType.Pressure, Barye> = pressure * this
@JvmName("metricAreaTimesMetricPressure")
operator fun <Pressure : MetricPressure, Area : MetricArea> ScientificValue<MeasurementType.Area, Area>.times(pressure: ScientificValue<MeasurementType.Pressure, Pressure>) = pressure * this
@JvmName("imperialAreaTimesOunceSquareInch")
operator fun <Area : ImperialArea> ScientificValue<MeasurementType.Area, Area>.times(pressure: ScientificValue<MeasurementType.Pressure, OunceSquareInch>) = pressure * this
@JvmName("imperialAreaTimesKipSquareInch")
operator fun <Area : ImperialArea> ScientificValue<MeasurementType.Area, Area>.times(pressure: ScientificValue<MeasurementType.Pressure, KipSquareInch>) = pressure * this
@JvmName("imperialAreaTimesKipSquareFeet")
operator fun <Area : ImperialArea> ScientificValue<MeasurementType.Area, Area>.times(pressure: ScientificValue<MeasurementType.Pressure, KipSquareFoot>) = pressure * this
@JvmName("imperialAreaTimesUsTonSquareInch")
operator fun <Area : ImperialArea> ScientificValue<MeasurementType.Area, Area>.times(pressure: ScientificValue<MeasurementType.Pressure, USTonSquareInch>) = pressure * this
@JvmName("imperialAreaTimesUsTonSquareFeet")
operator fun <Area : ImperialArea> ScientificValue<MeasurementType.Area, Area>.times(pressure: ScientificValue<MeasurementType.Pressure, USTonSquareFoot>) = pressure * this
@JvmName("imperialAreaTimesImperialTonSquareInch")
operator fun <Area : ImperialArea> ScientificValue<MeasurementType.Area, Area>.times(pressure: ScientificValue<MeasurementType.Pressure, ImperialTonSquareInch>) = pressure * this
@JvmName("imperialAreaTimesImperialTonSquareFeet")
operator fun <Area : ImperialArea> ScientificValue<MeasurementType.Area, Area>.times(pressure: ScientificValue<MeasurementType.Pressure, ImperialTonSquareFoot>) = pressure * this
@JvmName("imperialAreaTimesImperialPressure")
operator fun <Pressure : ImperialPressure, Area : ImperialArea> ScientificValue<MeasurementType.Area, Area>.times(pressure: ScientificValue<MeasurementType.Pressure, Pressure>) = pressure * this
@JvmName("imperialAreaTimesUKImperialPressure")
operator fun <Pressure : UKImperialPressure, Area : ImperialArea> ScientificValue<MeasurementType.Area, Area>.times(pressure: ScientificValue<MeasurementType.Pressure, Pressure>) = pressure * this
@JvmName("imperialAreaTimesUSCustomaryPressure")
operator fun <Pressure : USCustomaryPressure, Area : ImperialArea> ScientificValue<MeasurementType.Area, Area>.times(pressure: ScientificValue<MeasurementType.Pressure, Pressure>) = pressure * this
@JvmName("areaTimesPressure")
operator fun <PressureUnit : Pressure, AreaUnit : Area> ScientificValue<MeasurementType.Area, AreaUnit>.times(pressure: ScientificValue<MeasurementType.Pressure, PressureUnit>) = pressure * this
