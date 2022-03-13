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
import com.splendo.kaluga.scientific.PhysicalQuantity
import kotlinx.serialization.Serializable

val MetricMolarityUnits: Set<MetricMolarity> get() = AmountOfSubstanceUnits.flatMap { amountOfSubstance ->
    MetricVolumeUnits.map { amountOfSubstance per it }
}.toSet()

val ImperialMolarityUnits: Set<ImperialMolarity> get() = AmountOfSubstanceUnits.flatMap { amountOfSubstance ->
    ImperialVolumeUnits.map { amountOfSubstance per it }
}.toSet()

val UKImperialMolarityUnits: Set<UKImperialMolarity> get() = AmountOfSubstanceUnits.flatMap { amountOfSubstance ->
    UKImperialVolumeUnits.map { amountOfSubstance per it }
}.toSet()

val USCustomaryMolarityUnits: Set<USCustomaryMolarity> get() = AmountOfSubstanceUnits.flatMap { amountOfSubstance ->
    USCustomaryVolumeUnits.map { amountOfSubstance per it }
}.toSet()

val MolarityUnits: Set<Molarity> get() = MetricMolarityUnits +
    ImperialMolarityUnits +
    UKImperialMolarityUnits.filter { it.per !is UKImperialImperialVolumeWrapper }.toSet() +
    USCustomaryMolarityUnits.filter { it.per !is USCustomaryImperialVolumeWrapper }.toSet()

@Serializable
sealed class Molarity : AbstractScientificUnit<PhysicalQuantity.Molarity>() {
    abstract val amountOfSubstance: AmountOfSubstance
    abstract val per: Volume
    override val symbol: String by lazy { "${amountOfSubstance.symbol} / ${per.symbol}" }
    override val quantity = PhysicalQuantity.Molarity
    override fun fromSIUnit(value: Decimal): Decimal = per.toSIUnit(amountOfSubstance.fromSIUnit(value))
    override fun toSIUnit(value: Decimal): Decimal = amountOfSubstance.toSIUnit(per.fromSIUnit(value))
}

@Serializable
data class MetricMolarity(override val amountOfSubstance: AmountOfSubstance, override val per: MetricVolume) : Molarity(), MetricScientificUnit<PhysicalQuantity.Molarity> {
    override val system = MeasurementSystem.Metric
}
@Serializable
data class ImperialMolarity(override val amountOfSubstance: AmountOfSubstance, override val per: ImperialVolume) : Molarity(), ImperialScientificUnit<PhysicalQuantity.Molarity> {
    override val system = MeasurementSystem.Imperial
    val ukImperial get() = amountOfSubstance per per.ukImperial
    val usCustomary get() = amountOfSubstance per per.usCustomary
}
@Serializable
data class USCustomaryMolarity(override val amountOfSubstance: AmountOfSubstance, override val per: USCustomaryVolume) : Molarity(), USCustomaryScientificUnit<PhysicalQuantity.Molarity> {
    override val system = MeasurementSystem.USCustomary
}
@Serializable
data class UKImperialMolarity(override val amountOfSubstance: AmountOfSubstance, override val per: UKImperialVolume) : Molarity(), UKImperialScientificUnit<PhysicalQuantity.Molarity> {
    override val system = MeasurementSystem.UKImperial
}

infix fun AmountOfSubstance.per(volume: MetricVolume) = MetricMolarity(this, volume)
infix fun AmountOfSubstance.per(volume: ImperialVolume) = ImperialMolarity(this, volume)
infix fun AmountOfSubstance.per(volume: USCustomaryVolume) = USCustomaryMolarity(this, volume)
infix fun AmountOfSubstance.per(volume: UKImperialVolume) = UKImperialMolarity(this, volume)
