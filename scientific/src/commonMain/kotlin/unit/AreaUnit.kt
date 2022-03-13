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

val MetricAreaUnits: Set<MetricArea> get() = setOf(
    SquareMeter,
    SquareNanometer,
    SquareMicrometer,
    SquareMillimeter,
    SquareCentimeter,
    SquareDecimeter,
    SquareDecameter,
    SquareHectometer,
    SquareKilometer,
    Hectare
)

val ImperialAreaUnits: Set<ImperialArea> get() = setOf(
    SquareInch,
    SquareFoot,
    SquareYard,
    SquareMile,
    Acre
)

val AreaUnits: Set<Area> get() = MetricAreaUnits + ImperialAreaUnits

@Serializable
sealed class Area : AbstractScientificUnit<PhysicalQuantity.Area>()

@Serializable
sealed class MetricArea : Area(), MetricScientificUnit<PhysicalQuantity.Area>

@Serializable
sealed class ImperialArea : Area(), ImperialScientificUnit<PhysicalQuantity.Area>

class Square<S : MeasurementSystem, U : SystemScientificUnit<S, PhysicalQuantity.Length>>(private val unit: U) : SystemScientificUnit<S, PhysicalQuantity.Area> {
    override val symbol: String = "${unit.symbol}2"
    override val system: S = unit.system
    override val quantity = PhysicalQuantity.Area
    override fun fromSIUnit(value: Decimal): Decimal = unit.fromSIUnit(unit.fromSIUnit(value))
    override fun toSIUnit(value: Decimal): Decimal = unit.toSIUnit(unit.toSIUnit(value))
}

// Metric Volume
@Serializable
object SquareMeter : MetricArea(), SystemScientificUnit<MeasurementSystem.Metric, PhysicalQuantity.Area> by Square(Meter)

@Serializable
object SquareDecimeter : MetricArea(), SystemScientificUnit<MeasurementSystem.Metric, PhysicalQuantity.Area> by Square(Deci(Meter))

@Serializable
object SquareCentimeter : MetricArea(), SystemScientificUnit<MeasurementSystem.Metric, PhysicalQuantity.Area> by Square(Centi(Meter))

@Serializable
object SquareMillimeter : MetricArea(), SystemScientificUnit<MeasurementSystem.Metric, PhysicalQuantity.Area> by Square(Milli(Meter))

@Serializable
object SquareMicrometer : MetricArea(), SystemScientificUnit<MeasurementSystem.Metric, PhysicalQuantity.Area> by Square(Micro(Meter))

@Serializable
object SquareNanometer : MetricArea(), SystemScientificUnit<MeasurementSystem.Metric, PhysicalQuantity.Area> by Square(Nano(Meter))

@Serializable
object SquareDecameter : MetricArea(), SystemScientificUnit<MeasurementSystem.Metric, PhysicalQuantity.Area> by Square(Deca(Meter))

@Serializable
object SquareHectometer : MetricArea(), SystemScientificUnit<MeasurementSystem.Metric, PhysicalQuantity.Area> by Square(Hecto(Meter))

@Serializable
object Hectare : MetricArea(), SystemScientificUnit<MeasurementSystem.Metric, PhysicalQuantity.Area> by Square(Hecto(Meter)) {
    override val symbol: String = "ha"
}

@Serializable
object SquareKilometer : MetricArea(), SystemScientificUnit<MeasurementSystem.Metric, PhysicalQuantity.Area> by Square(Kilo(Meter))

@Serializable
object SquareMegameter : MetricArea(), SystemScientificUnit<MeasurementSystem.Metric, PhysicalQuantity.Area> by Square(Mega(Meter))

@Serializable
object SquareGigameter : MetricArea(), SystemScientificUnit<MeasurementSystem.Metric, PhysicalQuantity.Area> by Square(Giga(Meter))

@Serializable
object SquareMile : ImperialArea(), SystemScientificUnit<MeasurementSystem.Imperial, PhysicalQuantity.Area> by Square(Mile) {
    override val symbol: String = "sq. mi"
}

@Serializable
object SquareYard : ImperialArea(), SystemScientificUnit<MeasurementSystem.Imperial, PhysicalQuantity.Area> by Square(Yard) {
    override val symbol: String = "sq. yd"
}

@Serializable
object SquareFoot : ImperialArea(), SystemScientificUnit<MeasurementSystem.Imperial, PhysicalQuantity.Area> by Square(Foot) {
    override val symbol: String = "sq. fr"
}

@Serializable
object SquareInch : ImperialArea(), SystemScientificUnit<MeasurementSystem.Imperial, PhysicalQuantity.Area> by Square(Inch) {
    override val symbol: String = "sq. in"
}

@Serializable
object Acre : ImperialArea() {
    override val symbol: String = "acre"
    val ACRES_IN_SQUARE_MILE = 640.0
    override val quantity = PhysicalQuantity.Area
    override val system = MeasurementSystem.Imperial
    override fun toSIUnit(value: Decimal): Decimal = SquareMile.toSIUnit(value / ACRES_IN_SQUARE_MILE.toDecimal())
    override fun fromSIUnit(value: Decimal): Decimal = SquareMile.fromSIUnit(value) * ACRES_IN_SQUARE_MILE.toDecimal()
}
