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

package com.splendo.kaluga.scientific.converter.undefined

import com.splendo.kaluga.base.utils.Decimal
import com.splendo.kaluga.scientific.DefaultScientificValue
import com.splendo.kaluga.scientific.PhysicalQuantity
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.UndefinedQuantityType
import com.splendo.kaluga.scientific.UndefinedScientificValue
import com.splendo.kaluga.scientific.byDividing
import com.splendo.kaluga.scientific.unit.Dimensionless
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.ScientificUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.One
import kotlin.jvm.JvmName

@JvmName("reciprocalUndefinedAXUndefinedBValueDivReciprocalUndefinedBXUndefinedAValue")
fun <
    NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalLeftAndDenominatorReciprocalRightUnit : UndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity>,
    NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
    NumeratorReciprocalRightAndDenominatorReciprocalLeftUnit : UndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity>,
    NumeratorReciprocalUnit : UndefinedMultipliedUnit<NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity, NumeratorReciprocalLeftAndDenominatorReciprocalRightUnit, NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity, NumeratorReciprocalRightAndDenominatorReciprocalLeftUnit>,
    NumeratorUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity, NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity>, NumeratorReciprocalUnit>,
    DenominatorReciprocalUnit : UndefinedMultipliedUnit<NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity, NumeratorReciprocalRightAndDenominatorReciprocalLeftUnit, NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity, NumeratorReciprocalLeftAndDenominatorReciprocalRightUnit>,
    DenominatorUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity, NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity>, DenominatorReciprocalUnit>,
    TargetUnit : ScientificUnit<PhysicalQuantity.Dimensionless>,
    TargetValue : ScientificValue<PhysicalQuantity.Dimensionless, TargetUnit>,
    > UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity, NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity, NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity>>, DenominatorUnit>,
    getDimensionless: () -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = getDimensionless().byDividing(this, right, factory)

@JvmName("metricAndImperialReciprocalUndefinedAXUndefinedBValueDivMetricAndImperialReciprocalUndefinedBXUndefinedAValue")
infix operator fun <
    NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalLeftAndDenominatorReciprocalRightUnit,
    NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
    NumeratorReciprocalRightAndDenominatorReciprocalLeftUnit,
    NumeratorReciprocalUnit,
    NumeratorUnit,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity, NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity, NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity>>, DenominatorUnit>,
) where
        NumeratorReciprocalLeftAndDenominatorReciprocalRightUnit : UndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity>,
        NumeratorReciprocalLeftAndDenominatorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalLeftAndDenominatorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorReciprocalLeftAndDenominatorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorReciprocalRightAndDenominatorReciprocalLeftUnit : UndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity>,
        NumeratorReciprocalRightAndDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalRightAndDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorReciprocalRightAndDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorReciprocalUnit : UndefinedMultipliedUnit<NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity, NumeratorReciprocalLeftAndDenominatorReciprocalRightUnit, NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity, NumeratorReciprocalRightAndDenominatorReciprocalLeftUnit>,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity, NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity>, NumeratorReciprocalUnit>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalUnit : UndefinedMultipliedUnit<NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity, NumeratorReciprocalRightAndDenominatorReciprocalLeftUnit, NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity, NumeratorReciprocalLeftAndDenominatorReciprocalRightUnit>,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity, NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity>, DenominatorReciprocalUnit>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    div(
        right,
        getDimensionless = { One },
    ) {
            value: Decimal,
            unit: One,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricReciprocalUndefinedAXUndefinedBValueDivMetricReciprocalUndefinedBXUndefinedAValue")
infix operator fun <
    NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalLeftAndDenominatorReciprocalRightUnit,
    NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
    NumeratorReciprocalRightAndDenominatorReciprocalLeftUnit,
    NumeratorReciprocalUnit,
    NumeratorUnit,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity, NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity, NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity>>, DenominatorUnit>,
) where
        NumeratorReciprocalLeftAndDenominatorReciprocalRightUnit : UndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity>,
        NumeratorReciprocalLeftAndDenominatorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalRightAndDenominatorReciprocalLeftUnit : UndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity>,
        NumeratorReciprocalRightAndDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalUnit : UndefinedMultipliedUnit<NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity, NumeratorReciprocalLeftAndDenominatorReciprocalRightUnit, NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity, NumeratorReciprocalRightAndDenominatorReciprocalLeftUnit>,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity, NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity>, NumeratorReciprocalUnit>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalUnit : UndefinedMultipliedUnit<NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity, NumeratorReciprocalRightAndDenominatorReciprocalLeftUnit, NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity, NumeratorReciprocalLeftAndDenominatorReciprocalRightUnit>,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity, NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity>, DenominatorReciprocalUnit>,
        DenominatorUnit : MeasurementUsage.UsedInMetric =
    div(
        right,
        getDimensionless = { One },
    ) {
            value: Decimal,
            unit: One,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("imperialReciprocalUndefinedAXUndefinedBValueDivImperialReciprocalUndefinedBXUndefinedAValue")
infix operator fun <
    NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalLeftAndDenominatorReciprocalRightUnit,
    NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
    NumeratorReciprocalRightAndDenominatorReciprocalLeftUnit,
    NumeratorReciprocalUnit,
    NumeratorUnit,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity, NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity, NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity>>, DenominatorUnit>,
) where
        NumeratorReciprocalLeftAndDenominatorReciprocalRightUnit : UndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity>,
        NumeratorReciprocalLeftAndDenominatorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorReciprocalLeftAndDenominatorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorReciprocalRightAndDenominatorReciprocalLeftUnit : UndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity>,
        NumeratorReciprocalRightAndDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorReciprocalRightAndDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorReciprocalUnit : UndefinedMultipliedUnit<NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity, NumeratorReciprocalLeftAndDenominatorReciprocalRightUnit, NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity, NumeratorReciprocalRightAndDenominatorReciprocalLeftUnit>,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity, NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity>, NumeratorReciprocalUnit>,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalUnit : UndefinedMultipliedUnit<NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity, NumeratorReciprocalRightAndDenominatorReciprocalLeftUnit, NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity, NumeratorReciprocalLeftAndDenominatorReciprocalRightUnit>,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity, NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity>, DenominatorReciprocalUnit>,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    div(
        right,
        getDimensionless = { One },
    ) {
            value: Decimal,
            unit: One,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("ukImperialReciprocalUndefinedAXUndefinedBValueDivUKImperialReciprocalUndefinedBXUndefinedAValue")
infix operator fun <
    NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalLeftAndDenominatorReciprocalRightUnit,
    NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
    NumeratorReciprocalRightAndDenominatorReciprocalLeftUnit,
    NumeratorReciprocalUnit,
    NumeratorUnit,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity, NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity, NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity>>, DenominatorUnit>,
) where
        NumeratorReciprocalLeftAndDenominatorReciprocalRightUnit : UndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity>,
        NumeratorReciprocalLeftAndDenominatorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorReciprocalRightAndDenominatorReciprocalLeftUnit : UndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity>,
        NumeratorReciprocalRightAndDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorReciprocalUnit : UndefinedMultipliedUnit<NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity, NumeratorReciprocalLeftAndDenominatorReciprocalRightUnit, NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity, NumeratorReciprocalRightAndDenominatorReciprocalLeftUnit>,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity, NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity>, NumeratorReciprocalUnit>,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalUnit : UndefinedMultipliedUnit<NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity, NumeratorReciprocalRightAndDenominatorReciprocalLeftUnit, NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity, NumeratorReciprocalLeftAndDenominatorReciprocalRightUnit>,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity, NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity>, DenominatorReciprocalUnit>,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    div(
        right,
        getDimensionless = { One },
    ) {
            value: Decimal,
            unit: One,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("usCustomaryReciprocalUndefinedAXUndefinedBValueDivUSCustomaryReciprocalUndefinedBXUndefinedAValue")
infix operator fun <
    NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalLeftAndDenominatorReciprocalRightUnit,
    NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
    NumeratorReciprocalRightAndDenominatorReciprocalLeftUnit,
    NumeratorReciprocalUnit,
    NumeratorUnit,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity, NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity, NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity>>, DenominatorUnit>,
) where
        NumeratorReciprocalLeftAndDenominatorReciprocalRightUnit : UndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity>,
        NumeratorReciprocalLeftAndDenominatorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorReciprocalRightAndDenominatorReciprocalLeftUnit : UndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity>,
        NumeratorReciprocalRightAndDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorReciprocalUnit : UndefinedMultipliedUnit<NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity, NumeratorReciprocalLeftAndDenominatorReciprocalRightUnit, NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity, NumeratorReciprocalRightAndDenominatorReciprocalLeftUnit>,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity, NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity>, NumeratorReciprocalUnit>,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalUnit : UndefinedMultipliedUnit<NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity, NumeratorReciprocalRightAndDenominatorReciprocalLeftUnit, NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity, NumeratorReciprocalLeftAndDenominatorReciprocalRightUnit>,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity, NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity>, DenominatorReciprocalUnit>,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    div(
        right,
        getDimensionless = { One },
    ) {
            value: Decimal,
            unit: One,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialReciprocalUndefinedAXUndefinedBValueDivMetricAndUKImperialReciprocalUndefinedBXUndefinedAValue")
infix operator fun <
    NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalLeftAndDenominatorReciprocalRightUnit,
    NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
    NumeratorReciprocalRightAndDenominatorReciprocalLeftUnit,
    NumeratorReciprocalUnit,
    NumeratorUnit,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity, NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity, NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity>>, DenominatorUnit>,
) where
        NumeratorReciprocalLeftAndDenominatorReciprocalRightUnit : UndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity>,
        NumeratorReciprocalLeftAndDenominatorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalLeftAndDenominatorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorReciprocalRightAndDenominatorReciprocalLeftUnit : UndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity>,
        NumeratorReciprocalRightAndDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalRightAndDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorReciprocalUnit : UndefinedMultipliedUnit<NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity, NumeratorReciprocalLeftAndDenominatorReciprocalRightUnit, NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity, NumeratorReciprocalRightAndDenominatorReciprocalLeftUnit>,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity, NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity>, NumeratorReciprocalUnit>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalUnit : UndefinedMultipliedUnit<NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity, NumeratorReciprocalRightAndDenominatorReciprocalLeftUnit, NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity, NumeratorReciprocalLeftAndDenominatorReciprocalRightUnit>,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity, NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity>, DenominatorReciprocalUnit>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    div(
        right,
        getDimensionless = { One },
    ) {
            value: Decimal,
            unit: One,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryReciprocalUndefinedAXUndefinedBValueDivMetricAndUSCustomaryReciprocalUndefinedBXUndefinedAValue")
infix operator fun <
    NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalLeftAndDenominatorReciprocalRightUnit,
    NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
    NumeratorReciprocalRightAndDenominatorReciprocalLeftUnit,
    NumeratorReciprocalUnit,
    NumeratorUnit,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity, NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity, NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity>>, DenominatorUnit>,
) where
        NumeratorReciprocalLeftAndDenominatorReciprocalRightUnit : UndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity>,
        NumeratorReciprocalLeftAndDenominatorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalLeftAndDenominatorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorReciprocalRightAndDenominatorReciprocalLeftUnit : UndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity>,
        NumeratorReciprocalRightAndDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalRightAndDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorReciprocalUnit : UndefinedMultipliedUnit<NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity, NumeratorReciprocalLeftAndDenominatorReciprocalRightUnit, NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity, NumeratorReciprocalRightAndDenominatorReciprocalLeftUnit>,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity, NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity>, NumeratorReciprocalUnit>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalUnit : UndefinedMultipliedUnit<NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity, NumeratorReciprocalRightAndDenominatorReciprocalLeftUnit, NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity, NumeratorReciprocalLeftAndDenominatorReciprocalRightUnit>,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity, NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity>, DenominatorReciprocalUnit>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    div(
        right,
        getDimensionless = { One },
    ) {
            value: Decimal,
            unit: One,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("genericReciprocalUndefinedAXUndefinedBValueDivGenericReciprocalUndefinedBXUndefinedAValue")
infix operator fun <
    NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalLeftAndDenominatorReciprocalRightUnit : UndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity>,
    NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
    NumeratorReciprocalRightAndDenominatorReciprocalLeftUnit : UndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity>,
    NumeratorReciprocalUnit : UndefinedMultipliedUnit<NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity, NumeratorReciprocalLeftAndDenominatorReciprocalRightUnit, NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity, NumeratorReciprocalRightAndDenominatorReciprocalLeftUnit>,
    NumeratorUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity, NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity>, NumeratorReciprocalUnit>,
    DenominatorReciprocalUnit : UndefinedMultipliedUnit<NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity, NumeratorReciprocalRightAndDenominatorReciprocalLeftUnit, NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity, NumeratorReciprocalLeftAndDenominatorReciprocalRightUnit>,
    DenominatorUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity, NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity>, DenominatorReciprocalUnit>,
    > UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity, NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity, NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity>>, DenominatorUnit>,
) = div(
    right,
    getDimensionless = { One },
) {
        value: Decimal,
        unit: One,
    ->
    DefaultScientificValue(value, unit)
}
