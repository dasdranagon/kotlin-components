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

package com.splendo.kaluga.scientific.converter.magneticFlux

import com.splendo.kaluga.base.utils.Decimal
import com.splendo.kaluga.scientific.DefaultScientificValue
import com.splendo.kaluga.scientific.ElectricCharge
import com.splendo.kaluga.scientific.ElectricResistance
import com.splendo.kaluga.scientific.MagneticFlux
import com.splendo.kaluga.scientific.MeasurementType
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.byMultiplying
import kotlin.jvm.JvmName

@JvmName("fluxFromResistanceAndChargeDefault")
fun <
    ResistanceUnit : ElectricResistance,
    ChargeUnit : ElectricCharge,
    FluxUnit : MagneticFlux
> FluxUnit.flux(
    resistance: ScientificValue<MeasurementType.ElectricResistance, ResistanceUnit>,
    charge: ScientificValue<MeasurementType.ElectricCharge, ChargeUnit>
) = flux(resistance, charge, ::DefaultScientificValue)

@JvmName("fluxFromResistanceAndCharge")
fun <
    ResistanceUnit : ElectricResistance,
    ChargeUnit : ElectricCharge,
    FluxUnit : MagneticFlux,
    Value : ScientificValue<MeasurementType.MagneticFlux, FluxUnit>
> FluxUnit.flux(
    resistance: ScientificValue<MeasurementType.ElectricResistance, ResistanceUnit>,
    charge: ScientificValue<MeasurementType.ElectricCharge, ChargeUnit>,
    factory: (Decimal, FluxUnit) -> Value
) = byMultiplying(resistance, charge, factory)
