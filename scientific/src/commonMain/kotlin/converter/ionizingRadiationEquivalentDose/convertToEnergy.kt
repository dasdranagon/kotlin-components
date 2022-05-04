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

package com.splendo.kaluga.scientific.converter.ionizingRadiationEquivalentDose

import com.splendo.kaluga.scientific.PhysicalQuantity
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.converter.energy.energy
import com.splendo.kaluga.scientific.unit.Erg
import com.splendo.kaluga.scientific.unit.FootPoundForce
import com.splendo.kaluga.scientific.unit.Gram
import com.splendo.kaluga.scientific.unit.ImperialWeight
import com.splendo.kaluga.scientific.unit.IonizingRadiationEquivalentDose
import com.splendo.kaluga.scientific.unit.Joule
import com.splendo.kaluga.scientific.unit.MeasurementSystem
import com.splendo.kaluga.scientific.unit.MetricMultipleUnit
import com.splendo.kaluga.scientific.unit.RoentgenEquivalentMan
import com.splendo.kaluga.scientific.unit.UKImperialWeight
import com.splendo.kaluga.scientific.unit.USCustomaryWeight
import com.splendo.kaluga.scientific.unit.Weight
import kotlin.jvm.JvmName

@JvmName("roentgenEquivalentManTimesGram")
infix operator fun ScientificValue<PhysicalQuantity.IonizingRadiationEquivalentDose, RoentgenEquivalentMan>.times(
    weight: ScientificValue<PhysicalQuantity.Weight, Gram>
) = Erg.energy(this, weight)

@JvmName("roentgenEquivalentManMultipleTimesGram")
infix operator fun <EquivalentDoseUnit> ScientificValue<PhysicalQuantity.IonizingRadiationEquivalentDose, EquivalentDoseUnit>.times(
    weight: ScientificValue<PhysicalQuantity.Weight, Gram>
) where EquivalentDoseUnit : IonizingRadiationEquivalentDose, EquivalentDoseUnit : MetricMultipleUnit<MeasurementSystem.MetricAndImperial, PhysicalQuantity.IonizingRadiationEquivalentDose, RoentgenEquivalentMan> =
    Erg.energy(this, weight)

@JvmName("equivalentDoseTimesImperialWeight")
infix operator fun <EquivalentDoseUnit : IonizingRadiationEquivalentDose, WeightUnit : ImperialWeight> ScientificValue<PhysicalQuantity.IonizingRadiationEquivalentDose, EquivalentDoseUnit>.times(
    weight: ScientificValue<PhysicalQuantity.Weight, WeightUnit>
) = FootPoundForce.energy(this, weight)

@JvmName("equivalentDoseTimesUKImperialWeight")
infix operator fun <EquivalentDoseUnit : IonizingRadiationEquivalentDose, WeightUnit : UKImperialWeight> ScientificValue<PhysicalQuantity.IonizingRadiationEquivalentDose, EquivalentDoseUnit>.times(
    weight: ScientificValue<PhysicalQuantity.Weight, WeightUnit>
) = FootPoundForce.energy(this, weight)

@JvmName("equivalentDoseTimesUSCustomaryWeight")
infix operator fun <EquivalentDoseUnit : IonizingRadiationEquivalentDose, WeightUnit : USCustomaryWeight> ScientificValue<PhysicalQuantity.IonizingRadiationEquivalentDose, EquivalentDoseUnit>.times(
    weight: ScientificValue<PhysicalQuantity.Weight, WeightUnit>
) = FootPoundForce.energy(this, weight)

@JvmName("equivalentDoseTimesWeight")
infix operator fun <EquivalentDoseUnit : IonizingRadiationEquivalentDose, WeightUnit : Weight> ScientificValue<PhysicalQuantity.IonizingRadiationEquivalentDose, EquivalentDoseUnit>.times(
    weight: ScientificValue<PhysicalQuantity.Weight, WeightUnit>
) = Joule.energy(this, weight)
