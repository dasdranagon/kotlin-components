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

package com.splendo.kaluga.scientific.converter.volume

import com.splendo.kaluga.base.utils.Decimal
import com.splendo.kaluga.scientific.DefaultScientificValue
import com.splendo.kaluga.scientific.PhysicalQuantity
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.byMultiplying
import com.splendo.kaluga.scientific.unit.AmountOfSubstance
import com.splendo.kaluga.scientific.unit.MolarVolume
import com.splendo.kaluga.scientific.unit.Volume
import kotlin.jvm.JvmName

@JvmName("volumeFromMolarVolumeAndAmountOfSubstanceDefault")
fun <
    AmountOfSubstanceUnit : AmountOfSubstance,
    VolumeUnit : Volume,
    MolarVolumeUnit : MolarVolume
    > VolumeUnit.volume(
    molarVolume: ScientificValue<PhysicalQuantity.MolarVolume, MolarVolumeUnit>,
    amountOfSubstance: ScientificValue<PhysicalQuantity.AmountOfSubstance, AmountOfSubstanceUnit>
) = volume(molarVolume, amountOfSubstance, ::DefaultScientificValue)

@JvmName("volumeFromMolarVolumeAndAmountOfSubstance")
fun <
    AmountOfSubstanceUnit : AmountOfSubstance,
    VolumeUnit : Volume,
    MolarVolumeUnit : MolarVolume,
    Value : ScientificValue<PhysicalQuantity.Volume, VolumeUnit>
    > VolumeUnit.volume(
    molarVolume: ScientificValue<PhysicalQuantity.MolarVolume, MolarVolumeUnit>,
    amountOfSubstance: ScientificValue<PhysicalQuantity.AmountOfSubstance, AmountOfSubstanceUnit>,
    factory: (Decimal, VolumeUnit) -> Value
) = byMultiplying(molarVolume, amountOfSubstance, factory)
