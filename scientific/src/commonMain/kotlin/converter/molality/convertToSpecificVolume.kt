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

package com.splendo.kaluga.scientific.converter.molality

import com.splendo.kaluga.scientific.PhysicalQuantity
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.converter.molarVolume.times
import com.splendo.kaluga.scientific.converter.specificVolume.specificVolume
import com.splendo.kaluga.scientific.unit.CubicMeter
import com.splendo.kaluga.scientific.unit.ImperialMolality
import com.splendo.kaluga.scientific.unit.ImperialMolarVolume
import com.splendo.kaluga.scientific.unit.ImperialMolarity
import com.splendo.kaluga.scientific.unit.Kilogram
import com.splendo.kaluga.scientific.unit.MetricMolality
import com.splendo.kaluga.scientific.unit.MetricMolarVolume
import com.splendo.kaluga.scientific.unit.MetricMolarity
import com.splendo.kaluga.scientific.unit.Molality
import com.splendo.kaluga.scientific.unit.MolarVolume
import com.splendo.kaluga.scientific.unit.Molarity
import com.splendo.kaluga.scientific.unit.UKImperialMolality
import com.splendo.kaluga.scientific.unit.UKImperialMolarVolume
import com.splendo.kaluga.scientific.unit.UKImperialMolarity
import com.splendo.kaluga.scientific.unit.USCustomaryMolality
import com.splendo.kaluga.scientific.unit.USCustomaryMolarVolume
import com.splendo.kaluga.scientific.unit.USCustomaryMolarity
import com.splendo.kaluga.scientific.unit.per
import kotlin.jvm.JvmName

@JvmName("metricMolalityTimesMetricMolarVolume")
infix operator fun ScientificValue<PhysicalQuantity.Molality, MetricMolality>.times(molarVolume: ScientificValue<PhysicalQuantity.MolarVolume, MetricMolarVolume>) =
    molarVolume * this

@JvmName("imperialMolalityTimesImperialMolarVolume")
infix operator fun ScientificValue<PhysicalQuantity.Molality, ImperialMolality>.times(molarVolume: ScientificValue<PhysicalQuantity.MolarVolume, ImperialMolarVolume>) =
    molarVolume * this

@JvmName("imperialMolalityTimesUKImperialMolarVolume")
infix operator fun ScientificValue<PhysicalQuantity.Molality, ImperialMolality>.times(molarVolume: ScientificValue<PhysicalQuantity.MolarVolume, UKImperialMolarVolume>) =
    molarVolume * this

@JvmName("imperialMolalityTimesUSCustomaryMolarVolume")
infix operator fun ScientificValue<PhysicalQuantity.Molality, ImperialMolality>.times(molarVolume: ScientificValue<PhysicalQuantity.MolarVolume, USCustomaryMolarVolume>) =
    molarVolume * this

@JvmName("ukImperialMolalityTimesImperialMolarVolume")
infix operator fun ScientificValue<PhysicalQuantity.Molality, UKImperialMolality>.times(molarVolume: ScientificValue<PhysicalQuantity.MolarVolume, ImperialMolarVolume>) =
    molarVolume * this

@JvmName("ukImperialMolalityTimesUKImperialMolarVolume")
infix operator fun ScientificValue<PhysicalQuantity.Molality, UKImperialMolality>.times(molarVolume: ScientificValue<PhysicalQuantity.MolarVolume, UKImperialMolarVolume>) =
    molarVolume * this

@JvmName("usCustomaryMolalityTimesImperialMolarVolume")
infix operator fun ScientificValue<PhysicalQuantity.Molality, USCustomaryMolality>.times(molarVolume: ScientificValue<PhysicalQuantity.MolarVolume, ImperialMolarVolume>) =
    molarVolume * this

@JvmName("usCustomaryMolalityTimesUSCustomaryMolarVolume")
infix operator fun ScientificValue<PhysicalQuantity.Molality, USCustomaryMolality>.times(molarVolume: ScientificValue<PhysicalQuantity.MolarVolume, USCustomaryMolarVolume>) =
    molarVolume * this

@JvmName("molalityTimesMolarVolume")
infix operator fun <MolalityUnit : Molality, MolarVolumeUnit : MolarVolume> ScientificValue<PhysicalQuantity.Molality, MolalityUnit>.times(
    molarVolume: ScientificValue<PhysicalQuantity.MolarVolume, MolarVolumeUnit>
) = molarVolume * this

@JvmName("metricMolalityDivMetricMolality")
infix operator fun ScientificValue<PhysicalQuantity.Molality, MetricMolality>.div(molarity: ScientificValue<PhysicalQuantity.Molarity, MetricMolarity>) =
    (molarity.unit.per per unit.per).specificVolume(this, molarity)

@JvmName("imperialMolalityDivImperialMolarity")
infix operator fun ScientificValue<PhysicalQuantity.Molality, ImperialMolality>.div(molarity: ScientificValue<PhysicalQuantity.Molarity, ImperialMolarity>) =
    (molarity.unit.per per unit.per).specificVolume(this, molarity)

@JvmName("imperialMolalityDivUKImperialMolarity")
infix operator fun ScientificValue<PhysicalQuantity.Molality, ImperialMolality>.div(molarity: ScientificValue<PhysicalQuantity.Molarity, UKImperialMolarity>) =
    (molarity.unit.per per unit.per).specificVolume(this, molarity)

@JvmName("imperialMolalityDivUSCustomaryMolarity")
infix operator fun ScientificValue<PhysicalQuantity.Molality, ImperialMolality>.div(molarity: ScientificValue<PhysicalQuantity.Molarity, USCustomaryMolarity>) =
    (molarity.unit.per per unit.per).specificVolume(this, molarity)

@JvmName("ukImperialMolalityDivImperialMolarity")
infix operator fun ScientificValue<PhysicalQuantity.Molality, UKImperialMolality>.div(molarity: ScientificValue<PhysicalQuantity.Molarity, ImperialMolarity>) =
    (molarity.unit.per per unit.per).specificVolume(this, molarity)

@JvmName("ukImperialMolalityDivUKImperialMolarity")
infix operator fun ScientificValue<PhysicalQuantity.Molality, UKImperialMolality>.div(molarity: ScientificValue<PhysicalQuantity.Molarity, UKImperialMolarity>) =
    (molarity.unit.per per unit.per).specificVolume(this, molarity)

@JvmName("usCustomaryMolalityDivImperialMolarity")
infix operator fun ScientificValue<PhysicalQuantity.Molality, USCustomaryMolality>.div(molarity: ScientificValue<PhysicalQuantity.Molarity, ImperialMolarity>) =
    (molarity.unit.per per unit.per).specificVolume(this, molarity)

@JvmName("usCustomaryMolalityDivUSCustomaryMolarity")
infix operator fun ScientificValue<PhysicalQuantity.Molality, USCustomaryMolality>.div(molarity: ScientificValue<PhysicalQuantity.Molarity, USCustomaryMolarity>) =
    (molarity.unit.per per unit.per).specificVolume(this, molarity)

@JvmName("molalityDivMolarity")
infix operator fun <MolalityUnit : Molality, MolarityUnit : Molarity> ScientificValue<PhysicalQuantity.Molality, MolalityUnit>.div(
    molarity: ScientificValue<PhysicalQuantity.Molarity, MolarityUnit>
) = (CubicMeter per Kilogram).specificVolume(this, molarity)
