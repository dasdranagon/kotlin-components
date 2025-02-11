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
import com.splendo.kaluga.scientific.DefaultUndefinedScientificValue
import com.splendo.kaluga.scientific.UndefinedQuantityType
import com.splendo.kaluga.scientific.UndefinedScientificValue
import com.splendo.kaluga.scientific.byDividing
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.per
import kotlin.jvm.JvmName

@JvmName("undefinedAXUndefinedBPerUndefinedCXUndefinedDValueDivUndefinedBPerUndefinedCValue")
fun <
    NumeratorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftQuantity>,
    NumeratorNumeratorRightAndDenominatorNumeratorQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightAndDenominatorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorQuantity>,
    NumeratorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftQuantity, NumeratorNumeratorLeftUnit, NumeratorNumeratorRightAndDenominatorNumeratorQuantity, NumeratorNumeratorRightAndDenominatorNumeratorUnit>,
    NumeratorDenominatorLeftAndDenominatorDenominatorQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftAndDenominatorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity>,
    NumeratorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorRightQuantity>,
    NumeratorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorUnit, NumeratorDenominatorRightQuantity, NumeratorDenominatorRightUnit>,
    NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorQuantity>, NumeratorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorRightQuantity>, NumeratorDenominatorUnit>,
    DenominatorUnit : UndefinedDividedUnit<NumeratorNumeratorRightAndDenominatorNumeratorQuantity, NumeratorNumeratorRightAndDenominatorNumeratorUnit, NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorUnit>,
    TargetUnit : UndefinedDividedUnit<NumeratorNumeratorLeftQuantity, NumeratorNumeratorLeftUnit, NumeratorDenominatorRightQuantity, NumeratorDenominatorRightUnit>,
    TargetValue : UndefinedScientificValue<UndefinedQuantityType.Dividing<NumeratorNumeratorLeftQuantity, NumeratorDenominatorRightQuantity>, TargetUnit>,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorRightQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<NumeratorNumeratorRightAndDenominatorNumeratorQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorQuantity>, DenominatorUnit>,
    numeratorNumeratorLeftUnitPerNumeratorDenominatorRightUnit: NumeratorNumeratorLeftUnit.(NumeratorDenominatorRightUnit) -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.numerator.left.numeratorNumeratorLeftUnitPerNumeratorDenominatorRightUnit(unit.denominator.right).byDividing(this, right, factory)

@JvmName("metricAndImperialUndefinedAXUndefinedBPerUndefinedCXUndefinedDValueDivMetricAndImperialUndefinedBPerUndefinedCValue")
infix operator fun <
    NumeratorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftUnit,
    NumeratorNumeratorRightAndDenominatorNumeratorQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightAndDenominatorNumeratorUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorLeftAndDenominatorDenominatorQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftAndDenominatorDenominatorUnit,
    NumeratorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorRightUnit,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorRightQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<NumeratorNumeratorRightAndDenominatorNumeratorQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorQuantity>, DenominatorUnit>,
) where
        NumeratorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftQuantity>,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorRightAndDenominatorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorQuantity>,
        NumeratorNumeratorRightAndDenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorRightAndDenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorRightAndDenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftQuantity, NumeratorNumeratorLeftUnit, NumeratorNumeratorRightAndDenominatorNumeratorQuantity, NumeratorNumeratorRightAndDenominatorNumeratorUnit>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorLeftAndDenominatorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity>,
        NumeratorDenominatorLeftAndDenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorLeftAndDenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorLeftAndDenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorRightQuantity>,
        NumeratorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorUnit, NumeratorDenominatorRightQuantity, NumeratorDenominatorRightUnit>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorQuantity>, NumeratorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorRightQuantity>, NumeratorDenominatorUnit>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<NumeratorNumeratorRightAndDenominatorNumeratorQuantity, NumeratorNumeratorRightAndDenominatorNumeratorUnit, NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    div(
        right,
        numeratorNumeratorLeftUnitPerNumeratorDenominatorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndImperial<
                NumeratorNumeratorLeftQuantity,
                NumeratorNumeratorLeftUnit,
                NumeratorDenominatorRightQuantity,
                NumeratorDenominatorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricUndefinedAXUndefinedBPerUndefinedCXUndefinedDValueDivMetricUndefinedBPerUndefinedCValue")
infix operator fun <
    NumeratorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftUnit,
    NumeratorNumeratorRightAndDenominatorNumeratorQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightAndDenominatorNumeratorUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorLeftAndDenominatorDenominatorQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftAndDenominatorDenominatorUnit,
    NumeratorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorRightUnit,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorRightQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<NumeratorNumeratorRightAndDenominatorNumeratorQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorQuantity>, DenominatorUnit>,
) where
        NumeratorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftQuantity>,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorRightAndDenominatorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorQuantity>,
        NumeratorNumeratorRightAndDenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftQuantity, NumeratorNumeratorLeftUnit, NumeratorNumeratorRightAndDenominatorNumeratorQuantity, NumeratorNumeratorRightAndDenominatorNumeratorUnit>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorLeftAndDenominatorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity>,
        NumeratorDenominatorLeftAndDenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorRightQuantity>,
        NumeratorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorUnit, NumeratorDenominatorRightQuantity, NumeratorDenominatorRightUnit>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorQuantity>, NumeratorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorRightQuantity>, NumeratorDenominatorUnit>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : UndefinedDividedUnit<NumeratorNumeratorRightAndDenominatorNumeratorQuantity, NumeratorNumeratorRightAndDenominatorNumeratorUnit, NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInMetric =
    div(
        right,
        numeratorNumeratorLeftUnitPerNumeratorDenominatorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Metric<
                NumeratorNumeratorLeftQuantity,
                NumeratorNumeratorLeftUnit,
                NumeratorDenominatorRightQuantity,
                NumeratorDenominatorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialUndefinedAXUndefinedBPerUndefinedCXUndefinedDValueDivImperialUndefinedBPerUndefinedCValue")
infix operator fun <
    NumeratorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftUnit,
    NumeratorNumeratorRightAndDenominatorNumeratorQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightAndDenominatorNumeratorUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorLeftAndDenominatorDenominatorQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftAndDenominatorDenominatorUnit,
    NumeratorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorRightUnit,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorRightQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<NumeratorNumeratorRightAndDenominatorNumeratorQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorQuantity>, DenominatorUnit>,
) where
        NumeratorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftQuantity>,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorRightAndDenominatorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorQuantity>,
        NumeratorNumeratorRightAndDenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorRightAndDenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftQuantity, NumeratorNumeratorLeftUnit, NumeratorNumeratorRightAndDenominatorNumeratorQuantity, NumeratorNumeratorRightAndDenominatorNumeratorUnit>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorLeftAndDenominatorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity>,
        NumeratorDenominatorLeftAndDenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorLeftAndDenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorRightQuantity>,
        NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorUnit, NumeratorDenominatorRightQuantity, NumeratorDenominatorRightUnit>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorQuantity>, NumeratorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorRightQuantity>, NumeratorDenominatorUnit>,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<NumeratorNumeratorRightAndDenominatorNumeratorQuantity, NumeratorNumeratorRightAndDenominatorNumeratorUnit, NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    div(
        right,
        numeratorNumeratorLeftUnitPerNumeratorDenominatorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Imperial<
                NumeratorNumeratorLeftQuantity,
                NumeratorNumeratorLeftUnit,
                NumeratorDenominatorRightQuantity,
                NumeratorDenominatorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialUndefinedAXUndefinedBPerUndefinedCXUndefinedDValueDivUKImperialUndefinedBPerUndefinedCValue")
infix operator fun <
    NumeratorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftUnit,
    NumeratorNumeratorRightAndDenominatorNumeratorQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightAndDenominatorNumeratorUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorLeftAndDenominatorDenominatorQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftAndDenominatorDenominatorUnit,
    NumeratorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorRightUnit,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorRightQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<NumeratorNumeratorRightAndDenominatorNumeratorQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorQuantity>, DenominatorUnit>,
) where
        NumeratorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftQuantity>,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorRightAndDenominatorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorQuantity>,
        NumeratorNumeratorRightAndDenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftQuantity, NumeratorNumeratorLeftUnit, NumeratorNumeratorRightAndDenominatorNumeratorQuantity, NumeratorNumeratorRightAndDenominatorNumeratorUnit>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorLeftAndDenominatorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity>,
        NumeratorDenominatorLeftAndDenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorRightQuantity>,
        NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorUnit, NumeratorDenominatorRightQuantity, NumeratorDenominatorRightUnit>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorQuantity>, NumeratorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorRightQuantity>, NumeratorDenominatorUnit>,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedDividedUnit<NumeratorNumeratorRightAndDenominatorNumeratorQuantity, NumeratorNumeratorRightAndDenominatorNumeratorUnit, NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    div(
        right,
        numeratorNumeratorLeftUnitPerNumeratorDenominatorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.UKImperial<
                NumeratorNumeratorLeftQuantity,
                NumeratorNumeratorLeftUnit,
                NumeratorDenominatorRightQuantity,
                NumeratorDenominatorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryUndefinedAXUndefinedBPerUndefinedCXUndefinedDValueDivUSCustomaryUndefinedBPerUndefinedCValue")
infix operator fun <
    NumeratorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftUnit,
    NumeratorNumeratorRightAndDenominatorNumeratorQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightAndDenominatorNumeratorUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorLeftAndDenominatorDenominatorQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftAndDenominatorDenominatorUnit,
    NumeratorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorRightUnit,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorRightQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<NumeratorNumeratorRightAndDenominatorNumeratorQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorQuantity>, DenominatorUnit>,
) where
        NumeratorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftQuantity>,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorRightAndDenominatorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorQuantity>,
        NumeratorNumeratorRightAndDenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftQuantity, NumeratorNumeratorLeftUnit, NumeratorNumeratorRightAndDenominatorNumeratorQuantity, NumeratorNumeratorRightAndDenominatorNumeratorUnit>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorLeftAndDenominatorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity>,
        NumeratorDenominatorLeftAndDenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorRightQuantity>,
        NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorUnit, NumeratorDenominatorRightQuantity, NumeratorDenominatorRightUnit>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorQuantity>, NumeratorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorRightQuantity>, NumeratorDenominatorUnit>,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<NumeratorNumeratorRightAndDenominatorNumeratorQuantity, NumeratorNumeratorRightAndDenominatorNumeratorUnit, NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    div(
        right,
        numeratorNumeratorLeftUnitPerNumeratorDenominatorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.USCustomary<
                NumeratorNumeratorLeftQuantity,
                NumeratorNumeratorLeftUnit,
                NumeratorDenominatorRightQuantity,
                NumeratorDenominatorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialUndefinedAXUndefinedBPerUndefinedCXUndefinedDValueDivMetricAndUKImperialUndefinedBPerUndefinedCValue")
infix operator fun <
    NumeratorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftUnit,
    NumeratorNumeratorRightAndDenominatorNumeratorQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightAndDenominatorNumeratorUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorLeftAndDenominatorDenominatorQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftAndDenominatorDenominatorUnit,
    NumeratorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorRightUnit,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorRightQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<NumeratorNumeratorRightAndDenominatorNumeratorQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorQuantity>, DenominatorUnit>,
) where
        NumeratorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftQuantity>,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorRightAndDenominatorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorQuantity>,
        NumeratorNumeratorRightAndDenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorRightAndDenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftQuantity, NumeratorNumeratorLeftUnit, NumeratorNumeratorRightAndDenominatorNumeratorQuantity, NumeratorNumeratorRightAndDenominatorNumeratorUnit>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorLeftAndDenominatorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity>,
        NumeratorDenominatorLeftAndDenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorLeftAndDenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorRightQuantity>,
        NumeratorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorUnit, NumeratorDenominatorRightQuantity, NumeratorDenominatorRightUnit>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorQuantity>, NumeratorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorRightQuantity>, NumeratorDenominatorUnit>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedDividedUnit<NumeratorNumeratorRightAndDenominatorNumeratorQuantity, NumeratorNumeratorRightAndDenominatorNumeratorUnit, NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    div(
        right,
        numeratorNumeratorLeftUnitPerNumeratorDenominatorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUKImperial<
                NumeratorNumeratorLeftQuantity,
                NumeratorNumeratorLeftUnit,
                NumeratorDenominatorRightQuantity,
                NumeratorDenominatorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryUndefinedAXUndefinedBPerUndefinedCXUndefinedDValueDivMetricAndUSCustomaryUndefinedBPerUndefinedCValue")
infix operator fun <
    NumeratorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftUnit,
    NumeratorNumeratorRightAndDenominatorNumeratorQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightAndDenominatorNumeratorUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorLeftAndDenominatorDenominatorQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftAndDenominatorDenominatorUnit,
    NumeratorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorRightUnit,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorRightQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<NumeratorNumeratorRightAndDenominatorNumeratorQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorQuantity>, DenominatorUnit>,
) where
        NumeratorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftQuantity>,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorRightAndDenominatorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorQuantity>,
        NumeratorNumeratorRightAndDenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorRightAndDenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftQuantity, NumeratorNumeratorLeftUnit, NumeratorNumeratorRightAndDenominatorNumeratorQuantity, NumeratorNumeratorRightAndDenominatorNumeratorUnit>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorLeftAndDenominatorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity>,
        NumeratorDenominatorLeftAndDenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorLeftAndDenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorRightQuantity>,
        NumeratorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorUnit, NumeratorDenominatorRightQuantity, NumeratorDenominatorRightUnit>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorQuantity>, NumeratorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorRightQuantity>, NumeratorDenominatorUnit>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<NumeratorNumeratorRightAndDenominatorNumeratorQuantity, NumeratorNumeratorRightAndDenominatorNumeratorUnit, NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    div(
        right,
        numeratorNumeratorLeftUnitPerNumeratorDenominatorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUSCustomary<
                NumeratorNumeratorLeftQuantity,
                NumeratorNumeratorLeftUnit,
                NumeratorDenominatorRightQuantity,
                NumeratorDenominatorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }
