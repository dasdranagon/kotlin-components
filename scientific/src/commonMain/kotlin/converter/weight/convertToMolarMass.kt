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

package com.splendo.kaluga.scientific.converter.weight

import com.splendo.kaluga.scientific.PhysicalQuantity
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.converter.molarMass.molarMass
import com.splendo.kaluga.scientific.unit.AmountOfSubstance
import com.splendo.kaluga.scientific.unit.ImperialWeight
import com.splendo.kaluga.scientific.unit.Kilogram
import com.splendo.kaluga.scientific.unit.MetricWeight
import com.splendo.kaluga.scientific.unit.UKImperialWeight
import com.splendo.kaluga.scientific.unit.USCustomaryWeight
import com.splendo.kaluga.scientific.unit.Weight
import com.splendo.kaluga.scientific.unit.per
import kotlin.jvm.JvmName

@JvmName("metricWeightDivAmountOfSubstance")
infix operator fun <WeightUnit : MetricWeight, AmountOfSubstanceUnit : AmountOfSubstance> ScientificValue<PhysicalQuantity.Weight, WeightUnit>.div(
    amountOfSubstance: ScientificValue<PhysicalQuantity.AmountOfSubstance, AmountOfSubstanceUnit>
) = (unit per amountOfSubstance.unit).molarMass(this, amountOfSubstance)

@JvmName("imperialWeightDivAmountOfSubstance")
infix operator fun <WeightUnit : ImperialWeight, AmountOfSubstanceUnit : AmountOfSubstance> ScientificValue<PhysicalQuantity.Weight, WeightUnit>.div(
    amountOfSubstance: ScientificValue<PhysicalQuantity.AmountOfSubstance, AmountOfSubstanceUnit>
) = (unit per amountOfSubstance.unit).molarMass(this, amountOfSubstance)

@JvmName("ukImperialWeightDivAmountOfSubstance")
infix operator fun <WeightUnit : UKImperialWeight, AmountOfSubstanceUnit : AmountOfSubstance> ScientificValue<PhysicalQuantity.Weight, WeightUnit>.div(
    amountOfSubstance: ScientificValue<PhysicalQuantity.AmountOfSubstance, AmountOfSubstanceUnit>
) = (unit per amountOfSubstance.unit).molarMass(this, amountOfSubstance)

@JvmName("usCustomaryWeightDivAmountOfSubstance")
infix operator fun <WeightUnit : USCustomaryWeight, AmountOfSubstanceUnit : AmountOfSubstance> ScientificValue<PhysicalQuantity.Weight, WeightUnit>.div(
    amountOfSubstance: ScientificValue<PhysicalQuantity.AmountOfSubstance, AmountOfSubstanceUnit>
) = (unit per amountOfSubstance.unit).molarMass(this, amountOfSubstance)

@JvmName("weightDivAmountOfSubstance")
infix operator fun <WeightUnit : Weight, AmountOfSubstanceUnit : AmountOfSubstance> ScientificValue<PhysicalQuantity.Weight, WeightUnit>.div(
    amountOfSubstance: ScientificValue<PhysicalQuantity.AmountOfSubstance, AmountOfSubstanceUnit>
) = (Kilogram per amountOfSubstance.unit).molarMass(this, amountOfSubstance)
