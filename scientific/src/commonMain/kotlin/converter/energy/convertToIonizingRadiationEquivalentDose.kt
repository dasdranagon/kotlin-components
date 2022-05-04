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

package com.splendo.kaluga.scientific.converter.energy

import com.splendo.kaluga.scientific.PhysicalQuantity
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.converter.ionizingRadiationEquivalentDose.equivalentDose
import com.splendo.kaluga.scientific.unit.Energy
import com.splendo.kaluga.scientific.unit.Erg
import com.splendo.kaluga.scientific.unit.Gram
import com.splendo.kaluga.scientific.unit.MeasurementSystem
import com.splendo.kaluga.scientific.unit.MetricMultipleUnit
import com.splendo.kaluga.scientific.unit.RoentgenEquivalentMan
import com.splendo.kaluga.scientific.unit.Sievert
import com.splendo.kaluga.scientific.unit.Weight
import kotlin.jvm.JvmName

@JvmName("ergEquivalentDoseByGram")
infix fun ScientificValue<PhysicalQuantity.Energy, Erg>.equivalentDoseBy(gram: ScientificValue<PhysicalQuantity.Weight, Gram>) =
    RoentgenEquivalentMan.equivalentDose(this, gram)

@JvmName("ergMultipleEquivalentDoseByGram")
infix fun <ErgUnit> ScientificValue<PhysicalQuantity.Energy, ErgUnit>.equivalentDoseBy(gram: ScientificValue<PhysicalQuantity.Weight, Gram>) where ErgUnit : Energy, ErgUnit : MetricMultipleUnit<MeasurementSystem.Metric, PhysicalQuantity.Energy, Erg> =
    RoentgenEquivalentMan.equivalentDose(this, gram)

@JvmName("energyEquivalentDoseByWeight")
infix fun <EnergyUnit : Energy, WeightUnit : Weight> ScientificValue<PhysicalQuantity.Energy, EnergyUnit>.equivalentDoseBy(
    weight: ScientificValue<PhysicalQuantity.Weight, WeightUnit>
) = Sievert.equivalentDose(this, weight)
