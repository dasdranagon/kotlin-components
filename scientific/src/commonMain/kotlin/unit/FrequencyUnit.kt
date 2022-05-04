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

package com.splendo.kaluga.scientific.unit

import com.splendo.kaluga.base.utils.Decimal
import com.splendo.kaluga.base.utils.div
import com.splendo.kaluga.base.utils.times
import com.splendo.kaluga.base.utils.toDecimal
import com.splendo.kaluga.scientific.PhysicalQuantity
import kotlinx.serialization.Serializable

val FrequencyUnits: Set<Frequency> get() = setOf(
    Hertz,
    Nanohertz,
    Microhertz,
    Millihertz,
    Centihertz,
    Decihertz,
    Decahertz,
    Hectohertz,
    Kilohertz,
    Megahertz,
    Gigahertz,
    BeatsPerMinute
)

@Serializable
sealed class Frequency : ScientificUnit<PhysicalQuantity.Frequency>, MetricAndImperialScientificUnit<PhysicalQuantity.Frequency>

object Hertz : Frequency(), MetricBaseUnit<MeasurementSystem.MetricAndImperial, PhysicalQuantity.Frequency> {
    override val symbol: String = "Hz"
    override val system = MeasurementSystem.MetricAndImperial
    override val quantity = PhysicalQuantity.Frequency
    override fun fromSIUnit(value: Decimal): Decimal = value
    override fun toSIUnit(value: Decimal): Decimal = value
}

@Serializable
object Nanohertz : Frequency(), MetricMultipleUnit<MeasurementSystem.MetricAndImperial, PhysicalQuantity.Frequency, Hertz> by Nano(Hertz)
@Serializable
object Microhertz : Frequency(), MetricMultipleUnit<MeasurementSystem.MetricAndImperial, PhysicalQuantity.Frequency, Hertz> by Micro(Hertz)
@Serializable
object Millihertz : Frequency(), MetricMultipleUnit<MeasurementSystem.MetricAndImperial, PhysicalQuantity.Frequency, Hertz> by Milli(Hertz)
@Serializable
object Centihertz : Frequency(), MetricMultipleUnit<MeasurementSystem.MetricAndImperial, PhysicalQuantity.Frequency, Hertz> by Centi(Hertz)
@Serializable
object Decihertz : Frequency(), MetricMultipleUnit<MeasurementSystem.MetricAndImperial, PhysicalQuantity.Frequency, Hertz> by Deci(Hertz)
@Serializable
object Decahertz : Frequency(), MetricMultipleUnit<MeasurementSystem.MetricAndImperial, PhysicalQuantity.Frequency, Hertz> by Deca(Hertz)
@Serializable
object Hectohertz : Frequency(), MetricMultipleUnit<MeasurementSystem.MetricAndImperial, PhysicalQuantity.Frequency, Hertz> by Hecto(Hertz)
@Serializable
object Kilohertz : Frequency(), MetricMultipleUnit<MeasurementSystem.MetricAndImperial, PhysicalQuantity.Frequency, Hertz> by Kilo(Hertz)
@Serializable
object Megahertz : Frequency(), MetricMultipleUnit<MeasurementSystem.MetricAndImperial, PhysicalQuantity.Frequency, Hertz> by Mega(Hertz)
@Serializable
object Gigahertz : Frequency(), MetricMultipleUnit<MeasurementSystem.MetricAndImperial, PhysicalQuantity.Frequency, Hertz> by Giga(Hertz)
@Serializable
object BeatsPerMinute : Frequency() {
    override val symbol: String = "bpm"
    override val system = MeasurementSystem.MetricAndImperial
    override val quantity = PhysicalQuantity.Frequency
    override fun fromSIUnit(value: Decimal): Decimal = value * 60.0.toDecimal()
    override fun toSIUnit(value: Decimal): Decimal = value / 60.0.toDecimal()
}
