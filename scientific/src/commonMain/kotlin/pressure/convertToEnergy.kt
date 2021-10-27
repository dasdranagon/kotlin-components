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

package com.splendo.kaluga.scientific.pressure

import com.splendo.kaluga.scientific.Barye
import com.splendo.kaluga.scientific.CubicCentimeter
import com.splendo.kaluga.scientific.CubicFoot
import com.splendo.kaluga.scientific.CubicInch
import com.splendo.kaluga.scientific.Erg
import com.splendo.kaluga.scientific.FootPoundForce
import com.splendo.kaluga.scientific.ImperialPressure
import com.splendo.kaluga.scientific.ImperialTonSquareInch
import com.splendo.kaluga.scientific.ImperialVolume
import com.splendo.kaluga.scientific.InchOunceForce
import com.splendo.kaluga.scientific.InchPoundForce
import com.splendo.kaluga.scientific.Joule
import com.splendo.kaluga.scientific.KiloPoundSquareInch
import com.splendo.kaluga.scientific.KipSquareInch
import com.splendo.kaluga.scientific.MeasurementSystem
import com.splendo.kaluga.scientific.MeasurementType
import com.splendo.kaluga.scientific.MetricMultipleUnit
import com.splendo.kaluga.scientific.MetricPressure
import com.splendo.kaluga.scientific.MetricVolume
import com.splendo.kaluga.scientific.OunceSquareInch
import com.splendo.kaluga.scientific.PoundSquareFoot
import com.splendo.kaluga.scientific.PoundSquareInch
import com.splendo.kaluga.scientific.Pressure
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.UKImperialPressure
import com.splendo.kaluga.scientific.UKImperialVolume
import com.splendo.kaluga.scientific.USCustomaryPressure
import com.splendo.kaluga.scientific.USCustomaryVolume
import com.splendo.kaluga.scientific.USTonSquareInch
import com.splendo.kaluga.scientific.Volume
import com.splendo.kaluga.scientific.energy.energy
import kotlin.jvm.JvmName

@JvmName("baryeTimesCubicCentimeter")
infix operator fun ScientificValue<MeasurementType.Pressure, Barye>.times(volume: ScientificValue<MeasurementType.Volume, CubicCentimeter>) = Erg.energy(this, volume)
@JvmName("baryeMultipleTimesCubicCentimeter")
infix operator fun <BaryeUnit> ScientificValue<MeasurementType.Pressure, BaryeUnit>.times(volume: ScientificValue<MeasurementType.Volume, CubicCentimeter>) where BaryeUnit : Pressure, BaryeUnit : MetricMultipleUnit<MeasurementSystem.Metric, MeasurementType.Pressure, Barye> = Erg.energy(this, volume)
@JvmName("metricPressureTimesMetricVolume")
infix operator fun <PressureUnit : MetricPressure, VolumeUnit : MetricVolume> ScientificValue<MeasurementType.Pressure, PressureUnit>.times(volume: ScientificValue<MeasurementType.Volume, VolumeUnit>) = Joule.energy(this, volume)
@JvmName("poundSquareFootTimesCubicFoot")
infix operator fun ScientificValue<MeasurementType.Pressure, PoundSquareFoot>.times(volume: ScientificValue<MeasurementType.Volume, CubicFoot>) = FootPoundForce.energy(this, volume)
@JvmName("poundSquareInchTimesCubicInch")
infix operator fun ScientificValue<MeasurementType.Pressure, PoundSquareInch>.times(volume: ScientificValue<MeasurementType.Volume, CubicInch>) = InchPoundForce.energy(this, volume)
@JvmName("ounceSquareInchTimesCubicInch")
infix operator fun ScientificValue<MeasurementType.Pressure, OunceSquareInch>.times(volume: ScientificValue<MeasurementType.Volume, CubicInch>) = InchOunceForce.energy(this, volume)
@JvmName("kilopoundSquareInchTimesCubicInch")
infix operator fun ScientificValue<MeasurementType.Pressure, KiloPoundSquareInch>.times(volume: ScientificValue<MeasurementType.Volume, CubicInch>) = InchPoundForce.energy(this, volume)
@JvmName("kipSquareInchTimesCubicInch")
infix operator fun ScientificValue<MeasurementType.Pressure, KipSquareInch>.times(volume: ScientificValue<MeasurementType.Volume, CubicInch>) = InchPoundForce.energy(this, volume)
@JvmName("usTonSquareInchTimesCubicInch")
infix operator fun ScientificValue<MeasurementType.Pressure, USTonSquareInch>.times(volume: ScientificValue<MeasurementType.Volume, CubicInch>) = InchPoundForce.energy(this, volume)
@JvmName("imperialTonSquareInchTimesCubicInch")
infix operator fun ScientificValue<MeasurementType.Pressure, ImperialTonSquareInch>.times(volume: ScientificValue<MeasurementType.Volume, CubicInch>) = InchPoundForce.energy(this, volume)
@JvmName("imperialPressureTimesImperialVolume")
infix operator fun <PressureUnit : ImperialPressure, VolumeUnit : ImperialVolume> ScientificValue<MeasurementType.Pressure, PressureUnit>.times(volume: ScientificValue<MeasurementType.Volume, VolumeUnit>) = FootPoundForce.energy(this, volume)
@JvmName("imperialPressureTimesUKImperialVolume")
infix operator fun <PressureUnit : ImperialPressure, VolumeUnit : UKImperialVolume> ScientificValue<MeasurementType.Pressure, PressureUnit>.times(volume: ScientificValue<MeasurementType.Volume, VolumeUnit>) = FootPoundForce.energy(this, volume)
@JvmName("imperialPressureTimesUSCustomaryVolume")
infix operator fun <PressureUnit : ImperialPressure, VolumeUnit : USCustomaryVolume> ScientificValue<MeasurementType.Pressure, PressureUnit>.times(volume: ScientificValue<MeasurementType.Volume, VolumeUnit>) = FootPoundForce.energy(this, volume)
@JvmName("ukImperialPressureTimesImperialVolume")
infix operator fun <PressureUnit : UKImperialPressure, VolumeUnit : ImperialVolume> ScientificValue<MeasurementType.Pressure, PressureUnit>.times(volume: ScientificValue<MeasurementType.Volume, VolumeUnit>) = FootPoundForce.energy(this, volume)
@JvmName("ukImperialPressureTimesUKImperialVolume")
infix operator fun <PressureUnit : UKImperialPressure, VolumeUnit : UKImperialVolume> ScientificValue<MeasurementType.Pressure, PressureUnit>.times(volume: ScientificValue<MeasurementType.Volume, VolumeUnit>) = FootPoundForce.energy(this, volume)
@JvmName("ukImperialPressureTimesUSCustomaryVolume")
infix operator fun <PressureUnit : UKImperialPressure, VolumeUnit : USCustomaryVolume> ScientificValue<MeasurementType.Pressure, PressureUnit>.times(volume: ScientificValue<MeasurementType.Volume, VolumeUnit>) = FootPoundForce.energy(this, volume)
@JvmName("usCustomaryPressureTimesImperialVolume")
infix operator fun <PressureUnit : USCustomaryPressure, VolumeUnit : ImperialVolume> ScientificValue<MeasurementType.Pressure, PressureUnit>.times(volume: ScientificValue<MeasurementType.Volume, VolumeUnit>) = FootPoundForce.energy(this, volume)
@JvmName("usCustomaryPressureTimesUKImperialVolume")
infix operator fun <PressureUnit : USCustomaryPressure, VolumeUnit : UKImperialVolume> ScientificValue<MeasurementType.Pressure, PressureUnit>.times(volume: ScientificValue<MeasurementType.Volume, VolumeUnit>) = FootPoundForce.energy(this, volume)
@JvmName("usCustomaryPressureTimesUSCustomaryVolume")
infix operator fun <PressureUnit : USCustomaryPressure, VolumeUnit : USCustomaryVolume> ScientificValue<MeasurementType.Pressure, PressureUnit>.times(volume: ScientificValue<MeasurementType.Volume, VolumeUnit>) = FootPoundForce.energy(this, volume)
@JvmName("pressureTimesVolume")
infix operator fun <PressureUnit : Pressure, VolumeUnit : Volume> ScientificValue<MeasurementType.Pressure, PressureUnit>.times(volume: ScientificValue<MeasurementType.Volume, VolumeUnit>) = Joule.energy(this, volume)
