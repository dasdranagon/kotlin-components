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

package com.splendo.kaluga.scientific.converter.power

import com.splendo.kaluga.scientific.PhysicalQuantity
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.converter.thermalResistance.times
import com.splendo.kaluga.scientific.unit.ImperialPower
import com.splendo.kaluga.scientific.unit.MetricAndImperialPower
import com.splendo.kaluga.scientific.unit.MetricAndUKImperialThermalResistance
import com.splendo.kaluga.scientific.unit.MetricPower
import com.splendo.kaluga.scientific.unit.MetricThermalResistance
import com.splendo.kaluga.scientific.unit.Power
import com.splendo.kaluga.scientific.unit.ThermalResistance
import com.splendo.kaluga.scientific.unit.UKImperialThermalResistance
import com.splendo.kaluga.scientific.unit.USCustomaryThermalResistance
import kotlin.jvm.JvmName

@JvmName("powerTimesMetricAndUKImperialThermalResistance")
infix operator fun <PowerUnit : Power> ScientificValue<PhysicalQuantity.Power, PowerUnit>.times(
    thermalResistance: ScientificValue<PhysicalQuantity.ThermalResistance, MetricAndUKImperialThermalResistance>
) = thermalResistance * this

@JvmName("metricAndImperialPowerTimesMetricThermalResistance")
infix operator fun <PowerUnit : MetricAndImperialPower> ScientificValue<PhysicalQuantity.Power, PowerUnit>.times(
    thermalResistance: ScientificValue<PhysicalQuantity.ThermalResistance, MetricThermalResistance>
) = thermalResistance * this

@JvmName("metricPowerTimesMetricThermalResistance")
infix operator fun <PowerUnit : MetricPower> ScientificValue<PhysicalQuantity.Power, PowerUnit>.times(thermalResistance: ScientificValue<PhysicalQuantity.ThermalResistance, MetricThermalResistance>) =
    thermalResistance * this

@JvmName("metricAndImperialPowerTimesUKImperialThermalResistance")
infix operator fun <PowerUnit : MetricAndImperialPower> ScientificValue<PhysicalQuantity.Power, PowerUnit>.times(
    thermalResistance: ScientificValue<PhysicalQuantity.ThermalResistance, UKImperialThermalResistance>
) = thermalResistance * this

@JvmName("imperialPowerTimesUKImperialThermalResistance")
infix operator fun <PowerUnit : ImperialPower> ScientificValue<PhysicalQuantity.Power, PowerUnit>.times(thermalResistance: ScientificValue<PhysicalQuantity.ThermalResistance, UKImperialThermalResistance>) =
    thermalResistance * this

@JvmName("metricAndImperialPowerTimesUSCustomaryThermalResistance")
infix operator fun <PowerUnit : MetricAndImperialPower> ScientificValue<PhysicalQuantity.Power, PowerUnit>.times(
    thermalResistance: ScientificValue<PhysicalQuantity.ThermalResistance, USCustomaryThermalResistance>
) = thermalResistance * this

@JvmName("imperialPowerTimesUSCustomaryThermalResistance")
infix operator fun <PowerUnit : ImperialPower> ScientificValue<PhysicalQuantity.Power, PowerUnit>.times(thermalResistance: ScientificValue<PhysicalQuantity.ThermalResistance, USCustomaryThermalResistance>) =
    thermalResistance * this

@JvmName("powerTimesThermalResistance")
infix operator fun <ThermalResistanceUnit : ThermalResistance, PowerUnit : Power> ScientificValue<PhysicalQuantity.Power, PowerUnit>.times(
    thermalResistance: ScientificValue<PhysicalQuantity.ThermalResistance, ThermalResistanceUnit>
) = thermalResistance * this
