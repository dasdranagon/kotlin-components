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
import com.splendo.kaluga.scientific.unit.x
import kotlin.jvm.JvmName

@JvmName("undefinedAXUndefinedBPerUndefinedCXUndefinedDValueDivUndefinedEXUndefinedBPerUndefinedFXUndefinedDValue")
fun <
    NumeratorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftQuantity>,
    NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightAndDenominatorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>,
    NumeratorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftQuantity, NumeratorNumeratorLeftUnit, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightUnit>,
    NumeratorDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorDenominatorLeftQuantity>,
    NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorRightAndDenominatorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>,
    NumeratorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftQuantity, NumeratorDenominatorLeftUnit, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightUnit>,
    NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, NumeratorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>, NumeratorDenominatorUnit>,
    DenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    DenominatorNumeratorLeftUnit : UndefinedScientificUnit<DenominatorNumeratorLeftQuantity>,
    DenominatorNumeratorUnit : UndefinedMultipliedUnit<DenominatorNumeratorLeftQuantity, DenominatorNumeratorLeftUnit, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightUnit>,
    DenominatorDenominatorLeftQuantity : UndefinedQuantityType,
    DenominatorDenominatorLeftUnit : UndefinedScientificUnit<DenominatorDenominatorLeftQuantity>,
    DenominatorDenominatorUnit : UndefinedMultipliedUnit<DenominatorDenominatorLeftQuantity, DenominatorDenominatorLeftUnit, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightUnit>,
    DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, UndefinedQuantityType.Multiplying<DenominatorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>, DenominatorDenominatorUnit>,
    TargetNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftQuantity, NumeratorNumeratorLeftUnit, DenominatorDenominatorLeftQuantity, DenominatorDenominatorLeftUnit>,
    TargetDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftQuantity, NumeratorDenominatorLeftUnit, DenominatorNumeratorLeftQuantity, DenominatorNumeratorLeftUnit>,
    TargetUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, DenominatorDenominatorLeftQuantity>, TargetNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftQuantity, DenominatorNumeratorLeftQuantity>, TargetDenominatorUnit>,
    TargetValue : UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, DenominatorDenominatorLeftQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftQuantity, DenominatorNumeratorLeftQuantity>>, TargetUnit>,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<DenominatorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>>, DenominatorUnit>,
    numeratorNumeratorLeftUnitXDenominatorDenominatorLeftUnit: NumeratorNumeratorLeftUnit.(DenominatorDenominatorLeftUnit) -> TargetNumeratorUnit,
    numeratorDenominatorLeftUnitXDenominatorNumeratorLeftUnit: NumeratorDenominatorLeftUnit.(DenominatorNumeratorLeftUnit) -> TargetDenominatorUnit,
    targetNumeratorUnitPerTargetDenominatorUnit: TargetNumeratorUnit.(TargetDenominatorUnit) -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.numerator.left.numeratorNumeratorLeftUnitXDenominatorDenominatorLeftUnit(
    right.unit.denominator.left,
).targetNumeratorUnitPerTargetDenominatorUnit(
    unit.denominator.left.numeratorDenominatorLeftUnitXDenominatorNumeratorLeftUnit(right.unit.numerator.left),
).byDividing(this, right, factory)

@JvmName("metricAndImperialUndefinedAXUndefinedBPerUndefinedCXUndefinedDValueDivMetricAndImperialUndefinedEXUndefinedBPerUndefinedFXUndefinedDValue")
infix operator fun <
    NumeratorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftUnit,
    NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightAndDenominatorNumeratorRightUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftUnit,
    NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorRightAndDenominatorDenominatorRightUnit,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    DenominatorNumeratorLeftUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorLeftQuantity : UndefinedQuantityType,
    DenominatorDenominatorLeftUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<DenominatorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>>, DenominatorUnit>,
) where
        NumeratorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftQuantity>,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorRightAndDenominatorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>,
        NumeratorNumeratorRightAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorRightAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorRightAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftQuantity, NumeratorNumeratorLeftUnit, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightUnit>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorDenominatorLeftQuantity>,
        NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorRightAndDenominatorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>,
        NumeratorDenominatorRightAndDenominatorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorRightAndDenominatorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorRightAndDenominatorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftQuantity, NumeratorDenominatorLeftUnit, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightUnit>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, NumeratorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>, NumeratorDenominatorUnit>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorLeftUnit : UndefinedScientificUnit<DenominatorNumeratorLeftQuantity>,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<DenominatorNumeratorLeftQuantity, DenominatorNumeratorLeftUnit, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightUnit>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorLeftUnit : UndefinedScientificUnit<DenominatorDenominatorLeftQuantity>,
        DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedMultipliedUnit<DenominatorDenominatorLeftQuantity, DenominatorDenominatorLeftUnit, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightUnit>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, UndefinedQuantityType.Multiplying<DenominatorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>, DenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    div(
        right,
        numeratorNumeratorLeftUnitXDenominatorDenominatorLeftUnit = { x(it) },
        numeratorDenominatorLeftUnitXDenominatorNumeratorLeftUnit = { x(it) },
        targetNumeratorUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndImperial<
                UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, DenominatorDenominatorLeftQuantity>,
                UndefinedMultipliedUnit.MetricAndImperial<
                    NumeratorNumeratorLeftQuantity,
                    NumeratorNumeratorLeftUnit,
                    DenominatorDenominatorLeftQuantity,
                    DenominatorDenominatorLeftUnit,
                    >,
                UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftQuantity, DenominatorNumeratorLeftQuantity>,
                UndefinedMultipliedUnit.MetricAndImperial<
                    NumeratorDenominatorLeftQuantity,
                    NumeratorDenominatorLeftUnit,
                    DenominatorNumeratorLeftQuantity,
                    DenominatorNumeratorLeftUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricUndefinedAXUndefinedBPerUndefinedCXUndefinedDValueDivMetricUndefinedEXUndefinedBPerUndefinedFXUndefinedDValue")
infix operator fun <
    NumeratorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftUnit,
    NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightAndDenominatorNumeratorRightUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftUnit,
    NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorRightAndDenominatorDenominatorRightUnit,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    DenominatorNumeratorLeftUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorLeftQuantity : UndefinedQuantityType,
    DenominatorDenominatorLeftUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<DenominatorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>>, DenominatorUnit>,
) where
        NumeratorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftQuantity>,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorRightAndDenominatorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>,
        NumeratorNumeratorRightAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftQuantity, NumeratorNumeratorLeftUnit, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightUnit>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorDenominatorLeftQuantity>,
        NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorRightAndDenominatorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>,
        NumeratorDenominatorRightAndDenominatorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftQuantity, NumeratorDenominatorLeftUnit, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightUnit>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, NumeratorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>, NumeratorDenominatorUnit>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorLeftUnit : UndefinedScientificUnit<DenominatorNumeratorLeftQuantity>,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<DenominatorNumeratorLeftQuantity, DenominatorNumeratorLeftUnit, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightUnit>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorLeftUnit : UndefinedScientificUnit<DenominatorDenominatorLeftQuantity>,
        DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : UndefinedMultipliedUnit<DenominatorDenominatorLeftQuantity, DenominatorDenominatorLeftUnit, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightUnit>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, UndefinedQuantityType.Multiplying<DenominatorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>, DenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInMetric =
    div(
        right,
        numeratorNumeratorLeftUnitXDenominatorDenominatorLeftUnit = { x(it) },
        numeratorDenominatorLeftUnitXDenominatorNumeratorLeftUnit = { x(it) },
        targetNumeratorUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Metric<
                UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, DenominatorDenominatorLeftQuantity>,
                UndefinedMultipliedUnit.Metric<
                    NumeratorNumeratorLeftQuantity,
                    NumeratorNumeratorLeftUnit,
                    DenominatorDenominatorLeftQuantity,
                    DenominatorDenominatorLeftUnit,
                    >,
                UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftQuantity, DenominatorNumeratorLeftQuantity>,
                UndefinedMultipliedUnit.Metric<
                    NumeratorDenominatorLeftQuantity,
                    NumeratorDenominatorLeftUnit,
                    DenominatorNumeratorLeftQuantity,
                    DenominatorNumeratorLeftUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialUndefinedAXUndefinedBPerUndefinedCXUndefinedDValueDivImperialUndefinedEXUndefinedBPerUndefinedFXUndefinedDValue")
infix operator fun <
    NumeratorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftUnit,
    NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightAndDenominatorNumeratorRightUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftUnit,
    NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorRightAndDenominatorDenominatorRightUnit,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    DenominatorNumeratorLeftUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorLeftQuantity : UndefinedQuantityType,
    DenominatorDenominatorLeftUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<DenominatorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>>, DenominatorUnit>,
) where
        NumeratorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftQuantity>,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorRightAndDenominatorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>,
        NumeratorNumeratorRightAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorRightAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftQuantity, NumeratorNumeratorLeftUnit, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightUnit>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorDenominatorLeftQuantity>,
        NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorRightAndDenominatorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>,
        NumeratorDenominatorRightAndDenominatorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorRightAndDenominatorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftQuantity, NumeratorDenominatorLeftUnit, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightUnit>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, NumeratorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>, NumeratorDenominatorUnit>,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorLeftUnit : UndefinedScientificUnit<DenominatorNumeratorLeftQuantity>,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<DenominatorNumeratorLeftQuantity, DenominatorNumeratorLeftUnit, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightUnit>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorLeftUnit : UndefinedScientificUnit<DenominatorDenominatorLeftQuantity>,
        DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedMultipliedUnit<DenominatorDenominatorLeftQuantity, DenominatorDenominatorLeftUnit, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightUnit>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, UndefinedQuantityType.Multiplying<DenominatorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>, DenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    div(
        right,
        numeratorNumeratorLeftUnitXDenominatorDenominatorLeftUnit = { x(it) },
        numeratorDenominatorLeftUnitXDenominatorNumeratorLeftUnit = { x(it) },
        targetNumeratorUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Imperial<
                UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, DenominatorDenominatorLeftQuantity>,
                UndefinedMultipliedUnit.Imperial<
                    NumeratorNumeratorLeftQuantity,
                    NumeratorNumeratorLeftUnit,
                    DenominatorDenominatorLeftQuantity,
                    DenominatorDenominatorLeftUnit,
                    >,
                UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftQuantity, DenominatorNumeratorLeftQuantity>,
                UndefinedMultipliedUnit.Imperial<
                    NumeratorDenominatorLeftQuantity,
                    NumeratorDenominatorLeftUnit,
                    DenominatorNumeratorLeftQuantity,
                    DenominatorNumeratorLeftUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialUndefinedAXUndefinedBPerUndefinedCXUndefinedDValueDivUKImperialUndefinedEXUndefinedBPerUndefinedFXUndefinedDValue")
infix operator fun <
    NumeratorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftUnit,
    NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightAndDenominatorNumeratorRightUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftUnit,
    NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorRightAndDenominatorDenominatorRightUnit,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    DenominatorNumeratorLeftUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorLeftQuantity : UndefinedQuantityType,
    DenominatorDenominatorLeftUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<DenominatorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>>, DenominatorUnit>,
) where
        NumeratorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftQuantity>,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorRightAndDenominatorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>,
        NumeratorNumeratorRightAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftQuantity, NumeratorNumeratorLeftUnit, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightUnit>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorDenominatorLeftQuantity>,
        NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorRightAndDenominatorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>,
        NumeratorDenominatorRightAndDenominatorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftQuantity, NumeratorDenominatorLeftUnit, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightUnit>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, NumeratorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>, NumeratorDenominatorUnit>,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorLeftUnit : UndefinedScientificUnit<DenominatorNumeratorLeftQuantity>,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<DenominatorNumeratorLeftQuantity, DenominatorNumeratorLeftUnit, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightUnit>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorLeftUnit : UndefinedScientificUnit<DenominatorDenominatorLeftQuantity>,
        DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : UndefinedMultipliedUnit<DenominatorDenominatorLeftQuantity, DenominatorDenominatorLeftUnit, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightUnit>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, UndefinedQuantityType.Multiplying<DenominatorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>, DenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    div(
        right,
        numeratorNumeratorLeftUnitXDenominatorDenominatorLeftUnit = { x(it) },
        numeratorDenominatorLeftUnitXDenominatorNumeratorLeftUnit = { x(it) },
        targetNumeratorUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.UKImperial<
                UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, DenominatorDenominatorLeftQuantity>,
                UndefinedMultipliedUnit.UKImperial<
                    NumeratorNumeratorLeftQuantity,
                    NumeratorNumeratorLeftUnit,
                    DenominatorDenominatorLeftQuantity,
                    DenominatorDenominatorLeftUnit,
                    >,
                UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftQuantity, DenominatorNumeratorLeftQuantity>,
                UndefinedMultipliedUnit.UKImperial<
                    NumeratorDenominatorLeftQuantity,
                    NumeratorDenominatorLeftUnit,
                    DenominatorNumeratorLeftQuantity,
                    DenominatorNumeratorLeftUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryUndefinedAXUndefinedBPerUndefinedCXUndefinedDValueDivUSCustomaryUndefinedEXUndefinedBPerUndefinedFXUndefinedDValue")
infix operator fun <
    NumeratorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftUnit,
    NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightAndDenominatorNumeratorRightUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftUnit,
    NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorRightAndDenominatorDenominatorRightUnit,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    DenominatorNumeratorLeftUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorLeftQuantity : UndefinedQuantityType,
    DenominatorDenominatorLeftUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<DenominatorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>>, DenominatorUnit>,
) where
        NumeratorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftQuantity>,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorRightAndDenominatorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>,
        NumeratorNumeratorRightAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftQuantity, NumeratorNumeratorLeftUnit, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightUnit>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorDenominatorLeftQuantity>,
        NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorRightAndDenominatorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>,
        NumeratorDenominatorRightAndDenominatorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftQuantity, NumeratorDenominatorLeftUnit, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightUnit>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, NumeratorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>, NumeratorDenominatorUnit>,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorLeftUnit : UndefinedScientificUnit<DenominatorNumeratorLeftQuantity>,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<DenominatorNumeratorLeftQuantity, DenominatorNumeratorLeftUnit, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightUnit>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorLeftUnit : UndefinedScientificUnit<DenominatorDenominatorLeftQuantity>,
        DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedMultipliedUnit<DenominatorDenominatorLeftQuantity, DenominatorDenominatorLeftUnit, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightUnit>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, UndefinedQuantityType.Multiplying<DenominatorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>, DenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    div(
        right,
        numeratorNumeratorLeftUnitXDenominatorDenominatorLeftUnit = { x(it) },
        numeratorDenominatorLeftUnitXDenominatorNumeratorLeftUnit = { x(it) },
        targetNumeratorUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.USCustomary<
                UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, DenominatorDenominatorLeftQuantity>,
                UndefinedMultipliedUnit.USCustomary<
                    NumeratorNumeratorLeftQuantity,
                    NumeratorNumeratorLeftUnit,
                    DenominatorDenominatorLeftQuantity,
                    DenominatorDenominatorLeftUnit,
                    >,
                UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftQuantity, DenominatorNumeratorLeftQuantity>,
                UndefinedMultipliedUnit.USCustomary<
                    NumeratorDenominatorLeftQuantity,
                    NumeratorDenominatorLeftUnit,
                    DenominatorNumeratorLeftQuantity,
                    DenominatorNumeratorLeftUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialUndefinedAXUndefinedBPerUndefinedCXUndefinedDValueDivMetricAndUKImperialUndefinedEXUndefinedBPerUndefinedFXUndefinedDValue")
infix operator fun <
    NumeratorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftUnit,
    NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightAndDenominatorNumeratorRightUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftUnit,
    NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorRightAndDenominatorDenominatorRightUnit,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    DenominatorNumeratorLeftUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorLeftQuantity : UndefinedQuantityType,
    DenominatorDenominatorLeftUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<DenominatorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>>, DenominatorUnit>,
) where
        NumeratorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftQuantity>,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorRightAndDenominatorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>,
        NumeratorNumeratorRightAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorRightAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftQuantity, NumeratorNumeratorLeftUnit, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightUnit>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorDenominatorLeftQuantity>,
        NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorRightAndDenominatorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>,
        NumeratorDenominatorRightAndDenominatorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorRightAndDenominatorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftQuantity, NumeratorDenominatorLeftUnit, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightUnit>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, NumeratorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>, NumeratorDenominatorUnit>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorLeftUnit : UndefinedScientificUnit<DenominatorNumeratorLeftQuantity>,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<DenominatorNumeratorLeftQuantity, DenominatorNumeratorLeftUnit, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightUnit>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorLeftUnit : UndefinedScientificUnit<DenominatorDenominatorLeftQuantity>,
        DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : UndefinedMultipliedUnit<DenominatorDenominatorLeftQuantity, DenominatorDenominatorLeftUnit, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightUnit>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, UndefinedQuantityType.Multiplying<DenominatorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>, DenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    div(
        right,
        numeratorNumeratorLeftUnitXDenominatorDenominatorLeftUnit = { x(it) },
        numeratorDenominatorLeftUnitXDenominatorNumeratorLeftUnit = { x(it) },
        targetNumeratorUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUKImperial<
                UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, DenominatorDenominatorLeftQuantity>,
                UndefinedMultipliedUnit.MetricAndUKImperial<
                    NumeratorNumeratorLeftQuantity,
                    NumeratorNumeratorLeftUnit,
                    DenominatorDenominatorLeftQuantity,
                    DenominatorDenominatorLeftUnit,
                    >,
                UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftQuantity, DenominatorNumeratorLeftQuantity>,
                UndefinedMultipliedUnit.MetricAndUKImperial<
                    NumeratorDenominatorLeftQuantity,
                    NumeratorDenominatorLeftUnit,
                    DenominatorNumeratorLeftQuantity,
                    DenominatorNumeratorLeftUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryUndefinedAXUndefinedBPerUndefinedCXUndefinedDValueDivMetricAndUSCustomaryUndefinedEXUndefinedBPerUndefinedFXUndefinedDValue")
infix operator fun <
    NumeratorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftUnit,
    NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightAndDenominatorNumeratorRightUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftUnit,
    NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorRightAndDenominatorDenominatorRightUnit,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    DenominatorNumeratorLeftUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorLeftQuantity : UndefinedQuantityType,
    DenominatorDenominatorLeftUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<DenominatorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>>, DenominatorUnit>,
) where
        NumeratorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftQuantity>,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorRightAndDenominatorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>,
        NumeratorNumeratorRightAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorRightAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftQuantity, NumeratorNumeratorLeftUnit, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightUnit>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorDenominatorLeftQuantity>,
        NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorRightAndDenominatorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>,
        NumeratorDenominatorRightAndDenominatorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorRightAndDenominatorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftQuantity, NumeratorDenominatorLeftUnit, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightUnit>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, NumeratorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>, NumeratorDenominatorUnit>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorLeftUnit : UndefinedScientificUnit<DenominatorNumeratorLeftQuantity>,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<DenominatorNumeratorLeftQuantity, DenominatorNumeratorLeftUnit, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightUnit>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorLeftUnit : UndefinedScientificUnit<DenominatorDenominatorLeftQuantity>,
        DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedMultipliedUnit<DenominatorDenominatorLeftQuantity, DenominatorDenominatorLeftUnit, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightUnit>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, UndefinedQuantityType.Multiplying<DenominatorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorRightQuantity>, DenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    div(
        right,
        numeratorNumeratorLeftUnitXDenominatorDenominatorLeftUnit = { x(it) },
        numeratorDenominatorLeftUnitXDenominatorNumeratorLeftUnit = { x(it) },
        targetNumeratorUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUSCustomary<
                UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, DenominatorDenominatorLeftQuantity>,
                UndefinedMultipliedUnit.MetricAndUSCustomary<
                    NumeratorNumeratorLeftQuantity,
                    NumeratorNumeratorLeftUnit,
                    DenominatorDenominatorLeftQuantity,
                    DenominatorDenominatorLeftUnit,
                    >,
                UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftQuantity, DenominatorNumeratorLeftQuantity>,
                UndefinedMultipliedUnit.MetricAndUSCustomary<
                    NumeratorDenominatorLeftQuantity,
                    NumeratorDenominatorLeftUnit,
                    DenominatorNumeratorLeftQuantity,
                    DenominatorNumeratorLeftUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }
