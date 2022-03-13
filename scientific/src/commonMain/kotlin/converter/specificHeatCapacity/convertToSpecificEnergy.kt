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

package com.splendo.kaluga.scientific.converter.specificHeatCapacity

import com.splendo.kaluga.scientific.PhysicalQuantity
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.converter.specificEnergy.specificEnergy
import com.splendo.kaluga.scientific.unit.Joule
import com.splendo.kaluga.scientific.unit.Kilogram
import com.splendo.kaluga.scientific.unit.MetricAndUKImperialTemperature
import com.splendo.kaluga.scientific.unit.MetricSpecificHeatCapacity
import com.splendo.kaluga.scientific.unit.SpecificHeatCapacity
import com.splendo.kaluga.scientific.unit.Temperature
import com.splendo.kaluga.scientific.unit.UKImperialSpecificHeatCapacity
import com.splendo.kaluga.scientific.unit.USCustomarySpecificHeatCapacity
import com.splendo.kaluga.scientific.unit.USCustomaryTemperature
import com.splendo.kaluga.scientific.unit.per
import kotlin.jvm.JvmName

@JvmName("metricSpecificHeatCapacityTimesMetricAndUKImperialTemperature")
infix operator fun <TemperatureUnit : MetricAndUKImperialTemperature> ScientificValue<PhysicalQuantity.SpecificHeatCapacity, MetricSpecificHeatCapacity>.times(
    temperature: ScientificValue<PhysicalQuantity.Temperature, TemperatureUnit>
) = (unit.heatCapacity.energy per unit.perWeight).specificEnergy(this, temperature)

@JvmName("ukImperialSpecificHeatCapacityTimesMetricAndUKImperialTemperature")
infix operator fun <TemperatureUnit : MetricAndUKImperialTemperature> ScientificValue<PhysicalQuantity.SpecificHeatCapacity, UKImperialSpecificHeatCapacity>.times(
    temperature: ScientificValue<PhysicalQuantity.Temperature, TemperatureUnit>
) = (unit.heatCapacity.energy per unit.perWeight).specificEnergy(this, temperature)

@JvmName("usCustomarySpecificHeatCapacityTimesUSCustomaryTemperature")
infix operator fun <TemperatureUnit : USCustomaryTemperature> ScientificValue<PhysicalQuantity.SpecificHeatCapacity, USCustomarySpecificHeatCapacity>.times(
    temperature: ScientificValue<PhysicalQuantity.Temperature, TemperatureUnit>
) = (unit.heatCapacity.energy per unit.perWeight).specificEnergy(this, temperature)

@JvmName("heatCapacityTimesTemperature")
infix operator fun <SpecificHeatCapacityUnit : SpecificHeatCapacity, TemperatureUnit : Temperature> ScientificValue<PhysicalQuantity.SpecificHeatCapacity, SpecificHeatCapacityUnit>.times(
    temperature: ScientificValue<PhysicalQuantity.Temperature, TemperatureUnit>
) = (Joule per Kilogram).specificEnergy(this, temperature)
