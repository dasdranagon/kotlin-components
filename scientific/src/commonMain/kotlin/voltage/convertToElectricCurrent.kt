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

package com.splendo.kaluga.scientific.voltage

import com.splendo.kaluga.scientific.Abampere
import com.splendo.kaluga.scientific.Abohm
import com.splendo.kaluga.scientific.Absiemens
import com.splendo.kaluga.scientific.Abvolt
import com.splendo.kaluga.scientific.Ampere
import com.splendo.kaluga.scientific.ElectricConductance
import com.splendo.kaluga.scientific.ElectricResistance
import com.splendo.kaluga.scientific.MeasurementType
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.Voltage
import com.splendo.kaluga.scientific.electricConductance.times
import com.splendo.kaluga.scientific.electricCurrent.current
import kotlin.jvm.JvmName

@JvmName("abvoltTimesAbsiemens")
infix operator fun ScientificValue<MeasurementType.Voltage, Abvolt>.times(conductance: ScientificValue<MeasurementType.ElectricConductance, Absiemens>) = conductance * this
@JvmName("voltageTimesConductance")
infix operator fun <ConductanceUnit : ElectricConductance, VoltageUnit : Voltage> ScientificValue<MeasurementType.Voltage, VoltageUnit>.times(conductance: ScientificValue<MeasurementType.ElectricConductance, ConductanceUnit>) = conductance * this

@JvmName("abvoltDivAbohm")
infix operator fun ScientificValue<MeasurementType.Voltage, Abvolt>.div(resistance: ScientificValue<MeasurementType.ElectricResistance, Abohm>) = Abampere.current(this, resistance)
@JvmName("voltageDivResistance")
infix operator fun <VoltageUnit : Voltage, ResistanceUnit : ElectricResistance> ScientificValue<MeasurementType.Voltage, VoltageUnit>.div(resistance: ScientificValue<MeasurementType.ElectricResistance, ResistanceUnit>) = Ampere.current(this, resistance)
