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
import kotlin.math.PI

val AngleUnits: Set<Angle> get() = setOf(
    Radian,
    Nanoradian,
    Microradian,
    Milliradian,
    Centiradian,
    Deciradian,
    Turn,
    Nanoturn,
    Microturn,
    Milliturn,
    Centiturn,
    Deciturn,
    Degree,
    Gradian,
    ArcMinute,
    ArcSecond
)

@Serializable
sealed class Angle : AbstractScientificUnit<PhysicalQuantity.Angle>(), MetricAndImperialScientificUnit<PhysicalQuantity.Angle>

@Serializable
object Radian : Angle(), MetricBaseUnit<MeasurementSystem.MetricAndImperial, PhysicalQuantity.Angle> {
    override val symbol = "rad"
    override val system = MeasurementSystem.MetricAndImperial
    override val quantity = PhysicalQuantity.Angle
    override fun fromSIUnit(value: Decimal): Decimal = value
    override fun toSIUnit(value: Decimal): Decimal = value
}

@Serializable
object Nanoradian : Angle(), MetricMultipleUnit<MeasurementSystem.MetricAndImperial, PhysicalQuantity.Angle, Radian> by Nano(Radian)
@Serializable
object Microradian : Angle(), MetricMultipleUnit<MeasurementSystem.MetricAndImperial, PhysicalQuantity.Angle, Radian> by Micro(Radian)
@Serializable
object Milliradian : Angle(), MetricMultipleUnit<MeasurementSystem.MetricAndImperial, PhysicalQuantity.Angle, Radian> by Milli(Radian)
@Serializable
object Centiradian : Angle(), MetricMultipleUnit<MeasurementSystem.MetricAndImperial, PhysicalQuantity.Angle, Radian> by Centi(Radian)
@Serializable
object Deciradian : Angle(), MetricMultipleUnit<MeasurementSystem.MetricAndImperial, PhysicalQuantity.Angle, Radian> by Deci(Radian)

@Serializable
object Turn : Angle(), MetricBaseUnit<MeasurementSystem.MetricAndImperial, PhysicalQuantity.Angle> {
    private const val RADIAN_IN_TURN = 2.0 * PI
    override val symbol = "tr"
    override val system = MeasurementSystem.MetricAndImperial
    override val quantity = PhysicalQuantity.Angle
    override fun fromSIUnit(value: Decimal): Decimal = value / RADIAN_IN_TURN.toDecimal()
    override fun toSIUnit(value: Decimal): Decimal = value * RADIAN_IN_TURN.toDecimal()
}

@Serializable
object Nanoturn : Angle(), MetricMultipleUnit<MeasurementSystem.MetricAndImperial, PhysicalQuantity.Angle, Turn> by Nano(Turn)
@Serializable
object Microturn : Angle(), MetricMultipleUnit<MeasurementSystem.MetricAndImperial, PhysicalQuantity.Angle, Turn> by Micro(Turn)
@Serializable
object Milliturn : Angle(), MetricMultipleUnit<MeasurementSystem.MetricAndImperial, PhysicalQuantity.Angle, Turn> by Milli(Turn)
@Serializable
object Centiturn : Angle(), MetricMultipleUnit<MeasurementSystem.MetricAndImperial, PhysicalQuantity.Angle, Turn> by Centi(Turn)
@Serializable
object Deciturn : Angle(), MetricMultipleUnit<MeasurementSystem.MetricAndImperial, PhysicalQuantity.Angle, Turn> by Deci(Turn)

@Serializable
object Degree : Angle() {
    private const val DEGREE_IN_TURN = 360.0
    override val symbol = "°"
    override val system = MeasurementSystem.MetricAndImperial
    override val quantity = PhysicalQuantity.Angle
    override fun fromSIUnit(value: Decimal): Decimal = Turn.fromSIUnit(value) * DEGREE_IN_TURN.toDecimal()
    override fun toSIUnit(value: Decimal): Decimal = Turn.toSIUnit(value / DEGREE_IN_TURN.toDecimal())
}

@Serializable
object Gradian : Angle() {
    private const val GRADIAN_IN_TURN = 400.0
    override val symbol = "gon"
    override val system = MeasurementSystem.MetricAndImperial
    override val quantity = PhysicalQuantity.Angle
    override fun fromSIUnit(value: Decimal): Decimal = Turn.fromSIUnit(value) * GRADIAN_IN_TURN.toDecimal()
    override fun toSIUnit(value: Decimal): Decimal = Turn.toSIUnit(value / GRADIAN_IN_TURN.toDecimal())
}

@Serializable
object ArcMinute : Angle() {
    private const val ARCMINUTE_IN_TURN = 21600.0
    override val symbol = "′"
    override val system = MeasurementSystem.MetricAndImperial
    override val quantity = PhysicalQuantity.Angle
    override fun fromSIUnit(value: Decimal): Decimal = Turn.fromSIUnit(value) * ARCMINUTE_IN_TURN.toDecimal()
    override fun toSIUnit(value: Decimal): Decimal = Turn.toSIUnit(value / ARCMINUTE_IN_TURN.toDecimal())
}

@Serializable
object ArcSecond : Angle() {
    private const val ARCSECOND_IN_TURN = 1296000.0
    override val symbol = "″"
    override val system = MeasurementSystem.MetricAndImperial
    override val quantity = PhysicalQuantity.Angle
    override fun fromSIUnit(value: Decimal): Decimal = Turn.fromSIUnit(value) * ARCSECOND_IN_TURN.toDecimal()
    override fun toSIUnit(value: Decimal): Decimal = Turn.toSIUnit(value / ARCSECOND_IN_TURN.toDecimal())
}
