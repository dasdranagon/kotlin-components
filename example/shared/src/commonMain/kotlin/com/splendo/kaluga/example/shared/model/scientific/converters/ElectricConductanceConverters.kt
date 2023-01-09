/*
 Copyright 2023 Splendo Consulting B.V. The Netherlands

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

package com.splendo.kaluga.example.shared.model.scientific.converters

import com.splendo.kaluga.scientific.DefaultScientificValue
import com.splendo.kaluga.scientific.PhysicalQuantity
import com.splendo.kaluga.scientific.converter.electricConductance.div
import com.splendo.kaluga.scientific.converter.electricConductance.times
import com.splendo.kaluga.scientific.unit.Absiemens
import com.splendo.kaluga.scientific.unit.Abvolt
import com.splendo.kaluga.scientific.unit.ElectricCapacitance
import com.splendo.kaluga.scientific.unit.ElectricCapacitanceUnits
import com.splendo.kaluga.scientific.unit.ElectricConductance
import com.splendo.kaluga.scientific.unit.Frequency
import com.splendo.kaluga.scientific.unit.FrequencyUnits
import com.splendo.kaluga.scientific.unit.Voltage
import com.splendo.kaluga.scientific.unit.VoltageUnits

val PhysicalQuantity.ElectricConductance.converters get() = listOf<QuantityConverter<PhysicalQuantity.ElectricConductance, *, *>>(
    QuantityConverter("Electric Capacitance from Frequency", QuantityConverter.Type.Division, FrequencyUnits) { (leftValue, leftUnit), (rightValue, rightUnit) ->
        when {
            leftUnit is Absiemens && rightUnit is Frequency -> DefaultScientificValue(leftValue, leftUnit) / DefaultScientificValue(rightValue, rightUnit)
            leftUnit is ElectricConductance && rightUnit is Frequency -> DefaultScientificValue(leftValue, leftUnit) / DefaultScientificValue(rightValue, rightUnit)
            else -> throw RuntimeException("Unexpected units: $leftUnit, $rightUnit")
        }
    },
    QuantityConverter("Electric Current from Voltage", QuantityConverter.Type.Division, VoltageUnits) { (leftValue, leftUnit), (rightValue, rightUnit) ->
        when {
            leftUnit is Absiemens && rightUnit is Abvolt -> DefaultScientificValue(leftValue, leftUnit) * DefaultScientificValue(rightValue, rightUnit)
            leftUnit is ElectricConductance && rightUnit is Voltage -> DefaultScientificValue(leftValue, leftUnit) * DefaultScientificValue(rightValue, rightUnit)
            else -> throw RuntimeException("Unexpected units: $leftUnit, $rightUnit")
        }
    },
    QuantityConverter("Frequency from Electric Capacitance", QuantityConverter.Type.Division, ElectricCapacitanceUnits) { (leftValue, leftUnit), (rightValue, rightUnit) ->
        when {
            leftUnit is ElectricConductance && rightUnit is ElectricCapacitance -> DefaultScientificValue(leftValue, leftUnit) / DefaultScientificValue(rightValue, rightUnit)
            else -> throw RuntimeException("Unexpected units: $leftUnit, $rightUnit")
        }
    }
)