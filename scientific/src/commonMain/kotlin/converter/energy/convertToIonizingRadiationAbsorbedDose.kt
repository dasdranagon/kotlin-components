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
import com.splendo.kaluga.scientific.converter.ionizingRadiationAbsorbedDose.absorbedDose
import com.splendo.kaluga.scientific.unit.Energy
import com.splendo.kaluga.scientific.unit.Erg
import com.splendo.kaluga.scientific.unit.Gram
import com.splendo.kaluga.scientific.unit.Gray
import com.splendo.kaluga.scientific.unit.MeasurementSystem
import com.splendo.kaluga.scientific.unit.MetricMultipleUnit
import com.splendo.kaluga.scientific.unit.Rad
import com.splendo.kaluga.scientific.unit.Weight
import kotlin.jvm.JvmName

@JvmName("ergAbsorbedByGram")
infix fun ScientificValue<PhysicalQuantity.Energy, Erg>.absorbedBy(gram: ScientificValue<PhysicalQuantity.Weight, Gram>) =
    Rad.absorbedDose(this, gram)

@JvmName("ergMultipleAbsorbedByGram")
infix fun <ErgUnit> ScientificValue<PhysicalQuantity.Energy, ErgUnit>.absorbedBy(gram: ScientificValue<PhysicalQuantity.Weight, Gram>) where ErgUnit : Energy, ErgUnit : MetricMultipleUnit<MeasurementSystem.Metric, PhysicalQuantity.Energy, Erg> =
    Rad.absorbedDose(this, gram)

@JvmName("energyAbsorbedByWeight")
infix fun <EnergyUnit : Energy, WeightUnit : Weight> ScientificValue<PhysicalQuantity.Energy, EnergyUnit>.absorbedBy(
    weight: ScientificValue<PhysicalQuantity.Weight, WeightUnit>
) = Gray.absorbedDose(this, weight)
