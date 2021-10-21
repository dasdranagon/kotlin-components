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

package com.splendo.kaluga.scientific

import com.splendo.kaluga.base.utils.Decimal
import kotlinx.serialization.Serializable

@Serializable
sealed class ElectricConductance : AbstractScientificUnit<MeasurementType.ElectricConductance>(), MetricAndImperialScientificUnit<MeasurementType.ElectricConductance>

@Serializable
object Siemens : ElectricConductance(), BaseMetricUnit<MeasurementType.ElectricConductance, MeasurementSystem.MetricAndImperial> {
    override val symbol = "S"
    override val system = MeasurementSystem.MetricAndImperial
    override val type = MeasurementType.ElectricConductance
    override fun fromSIUnit(value: Decimal): Decimal = value
    override fun toSIUnit(value: Decimal): Decimal = value
}

@Serializable
object NanoSiemens : ElectricConductance(), SystemScientificUnit<MeasurementSystem.MetricAndImperial, MeasurementType.ElectricConductance> by Nano(Siemens)
@Serializable
object MicroSiemens : ElectricConductance(), SystemScientificUnit<MeasurementSystem.MetricAndImperial, MeasurementType.ElectricConductance> by Micro(Siemens)
@Serializable
object MilliSiemens : ElectricConductance(), SystemScientificUnit<MeasurementSystem.MetricAndImperial, MeasurementType.ElectricConductance> by Milli(Siemens)
@Serializable
object CentiSiemens : ElectricConductance(), SystemScientificUnit<MeasurementSystem.MetricAndImperial, MeasurementType.ElectricConductance> by Centi(Siemens)
@Serializable
object DeciSiemens : ElectricConductance(), SystemScientificUnit<MeasurementSystem.MetricAndImperial, MeasurementType.ElectricConductance> by Deci(Siemens)
@Serializable
object DecaSiemens : ElectricConductance(), SystemScientificUnit<MeasurementSystem.MetricAndImperial, MeasurementType.ElectricConductance> by Deca(Siemens)
@Serializable
object HectoSiemens : ElectricConductance(), SystemScientificUnit<MeasurementSystem.MetricAndImperial, MeasurementType.ElectricConductance> by Hecto(Siemens)
@Serializable
object KiloSiemens : ElectricConductance(), SystemScientificUnit<MeasurementSystem.MetricAndImperial, MeasurementType.ElectricConductance> by Kilo(Siemens)
@Serializable
object MegaSiemens : ElectricConductance(), SystemScientificUnit<MeasurementSystem.MetricAndImperial, MeasurementType.ElectricConductance> by Mega(Siemens)
@Serializable
object GigaSiemens : ElectricConductance(), SystemScientificUnit<MeasurementSystem.MetricAndImperial, MeasurementType.ElectricConductance> by Giga(Siemens)

fun <
    ResistanceUnit : ElectricResistance,
    ConductanceUnit : ElectricConductance
    > ConductanceUnit.conductance(resistance: ScientificValue<MeasurementType.ElectricResistance, ResistanceUnit>): ScientificValue<MeasurementType.ElectricConductance, ConductanceUnit> = byInverting(resistance)

fun <
    CurrentUnit : ElectricCurrent,
    VoltageUnit : Voltage,
    ConductanceUnit : ElectricConductance
    > ConductanceUnit.conductance(
    current: ScientificValue<MeasurementType.ElectricCurrent, CurrentUnit>,
    voltage: ScientificValue<MeasurementType.Voltage, VoltageUnit>
): ScientificValue<MeasurementType.ElectricConductance, ConductanceUnit> = byDividing(current, voltage)

fun <ResistanceUnit : ElectricResistance> ScientificValue<MeasurementType.ElectricResistance, ResistanceUnit>.conductance() = Siemens.conductance(this)
infix operator fun <CurrentUnit : ElectricCurrent, VoltageUnit : Voltage> ScientificValue<MeasurementType.ElectricCurrent, CurrentUnit>.div(voltage: ScientificValue<MeasurementType.Voltage, VoltageUnit>) = Siemens.conductance(this, voltage)
