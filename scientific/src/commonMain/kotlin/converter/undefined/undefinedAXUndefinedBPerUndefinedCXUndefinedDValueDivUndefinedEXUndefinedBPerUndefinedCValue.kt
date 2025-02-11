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

@JvmName("undefinedAXUndefinedBPerUndefinedCXUndefinedDValueDivUndefinedEXUndefinedBPerUndefinedCValue")
fun <
    NumeratorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftQuantity>,
    NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightAndDenominatorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>,
    NumeratorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftQuantity, NumeratorNumeratorLeftUnit, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightUnit>,
    NumeratorDenominatorLeftAndDenominatorDenominatorQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftAndDenominatorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity>,
    NumeratorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorRightQuantity>,
    NumeratorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorUnit, NumeratorDenominatorRightQuantity, NumeratorDenominatorRightUnit>,
    NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, NumeratorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorRightQuantity>, NumeratorDenominatorUnit>,
    DenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    DenominatorNumeratorLeftUnit : UndefinedScientificUnit<DenominatorNumeratorLeftQuantity>,
    DenominatorNumeratorUnit : UndefinedMultipliedUnit<DenominatorNumeratorLeftQuantity, DenominatorNumeratorLeftUnit, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightUnit>,
    DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorUnit>,
    TargetDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorUnit, DenominatorNumeratorLeftQuantity, DenominatorNumeratorLeftUnit>,
    TargetUnit : UndefinedDividedUnit<NumeratorNumeratorLeftQuantity, NumeratorNumeratorLeftUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, DenominatorNumeratorLeftQuantity>, TargetDenominatorUnit>,
    TargetValue : UndefinedScientificValue<UndefinedQuantityType.Dividing<NumeratorNumeratorLeftQuantity, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, DenominatorNumeratorLeftQuantity>>, TargetUnit>,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorRightQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, NumeratorDenominatorLeftAndDenominatorDenominatorQuantity>, DenominatorUnit>,
    numeratorDenominatorLeftAndDenominatorDenominatorUnitXDenominatorNumeratorLeftUnit: NumeratorDenominatorLeftAndDenominatorDenominatorUnit.(
        DenominatorNumeratorLeftUnit,
    ) -> TargetDenominatorUnit,
    numeratorNumeratorLeftUnitPerTargetDenominatorUnit: NumeratorNumeratorLeftUnit.(TargetDenominatorUnit) -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.numerator.left.numeratorNumeratorLeftUnitPerTargetDenominatorUnit(
    unit.denominator.left.numeratorDenominatorLeftAndDenominatorDenominatorUnitXDenominatorNumeratorLeftUnit(right.unit.numerator.left),
).byDividing(this, right, factory)

@JvmName("metricAndImperialUndefinedAXUndefinedBPerUndefinedCXUndefinedDValueDivMetricAndImperialUndefinedEXUndefinedBPerUndefinedCValue")
infix operator fun <
    NumeratorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftUnit,
    NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightAndDenominatorNumeratorRightUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorLeftAndDenominatorDenominatorQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftAndDenominatorDenominatorUnit,
    NumeratorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorRightUnit,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    DenominatorNumeratorLeftUnit,
    DenominatorNumeratorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorRightQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, NumeratorDenominatorLeftAndDenominatorDenominatorQuantity>, DenominatorUnit>,
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
        NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, NumeratorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorRightQuantity>, NumeratorDenominatorUnit>,
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
        DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    div(
        right,
        numeratorDenominatorLeftAndDenominatorDenominatorUnitXDenominatorNumeratorLeftUnit = { x(it) },
        numeratorNumeratorLeftUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndImperial<
                NumeratorNumeratorLeftQuantity,
                NumeratorNumeratorLeftUnit,
                UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, DenominatorNumeratorLeftQuantity>,
                UndefinedMultipliedUnit.MetricAndImperial<
                    NumeratorDenominatorLeftAndDenominatorDenominatorQuantity,
                    NumeratorDenominatorLeftAndDenominatorDenominatorUnit,
                    DenominatorNumeratorLeftQuantity,
                    DenominatorNumeratorLeftUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricUndefinedAXUndefinedBPerUndefinedCXUndefinedDValueDivMetricUndefinedEXUndefinedBPerUndefinedCValue")
infix operator fun <
    NumeratorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftUnit,
    NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightAndDenominatorNumeratorRightUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorLeftAndDenominatorDenominatorQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftAndDenominatorDenominatorUnit,
    NumeratorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorRightUnit,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    DenominatorNumeratorLeftUnit,
    DenominatorNumeratorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorRightQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, NumeratorDenominatorLeftAndDenominatorDenominatorQuantity>, DenominatorUnit>,
) where
        NumeratorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftQuantity>,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorRightAndDenominatorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>,
        NumeratorNumeratorRightAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftQuantity, NumeratorNumeratorLeftUnit, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightUnit>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorLeftAndDenominatorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity>,
        NumeratorDenominatorLeftAndDenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorRightQuantity>,
        NumeratorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorUnit, NumeratorDenominatorRightQuantity, NumeratorDenominatorRightUnit>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, NumeratorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorRightQuantity>, NumeratorDenominatorUnit>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorLeftUnit : UndefinedScientificUnit<DenominatorNumeratorLeftQuantity>,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<DenominatorNumeratorLeftQuantity, DenominatorNumeratorLeftUnit, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightUnit>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInMetric =
    div(
        right,
        numeratorDenominatorLeftAndDenominatorDenominatorUnitXDenominatorNumeratorLeftUnit = { x(it) },
        numeratorNumeratorLeftUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Metric<
                NumeratorNumeratorLeftQuantity,
                NumeratorNumeratorLeftUnit,
                UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, DenominatorNumeratorLeftQuantity>,
                UndefinedMultipliedUnit.Metric<
                    NumeratorDenominatorLeftAndDenominatorDenominatorQuantity,
                    NumeratorDenominatorLeftAndDenominatorDenominatorUnit,
                    DenominatorNumeratorLeftQuantity,
                    DenominatorNumeratorLeftUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialUndefinedAXUndefinedBPerUndefinedCXUndefinedDValueDivImperialUndefinedEXUndefinedBPerUndefinedCValue")
infix operator fun <
    NumeratorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftUnit,
    NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightAndDenominatorNumeratorRightUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorLeftAndDenominatorDenominatorQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftAndDenominatorDenominatorUnit,
    NumeratorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorRightUnit,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    DenominatorNumeratorLeftUnit,
    DenominatorNumeratorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorRightQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, NumeratorDenominatorLeftAndDenominatorDenominatorQuantity>, DenominatorUnit>,
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
        NumeratorDenominatorLeftAndDenominatorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity>,
        NumeratorDenominatorLeftAndDenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorLeftAndDenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorRightQuantity>,
        NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorUnit, NumeratorDenominatorRightQuantity, NumeratorDenominatorRightUnit>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, NumeratorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorRightQuantity>, NumeratorDenominatorUnit>,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorLeftUnit : UndefinedScientificUnit<DenominatorNumeratorLeftQuantity>,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<DenominatorNumeratorLeftQuantity, DenominatorNumeratorLeftUnit, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightUnit>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    div(
        right,
        numeratorDenominatorLeftAndDenominatorDenominatorUnitXDenominatorNumeratorLeftUnit = { x(it) },
        numeratorNumeratorLeftUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Imperial<
                NumeratorNumeratorLeftQuantity,
                NumeratorNumeratorLeftUnit,
                UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, DenominatorNumeratorLeftQuantity>,
                UndefinedMultipliedUnit.Imperial<
                    NumeratorDenominatorLeftAndDenominatorDenominatorQuantity,
                    NumeratorDenominatorLeftAndDenominatorDenominatorUnit,
                    DenominatorNumeratorLeftQuantity,
                    DenominatorNumeratorLeftUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialUndefinedAXUndefinedBPerUndefinedCXUndefinedDValueDivUKImperialUndefinedEXUndefinedBPerUndefinedCValue")
infix operator fun <
    NumeratorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftUnit,
    NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightAndDenominatorNumeratorRightUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorLeftAndDenominatorDenominatorQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftAndDenominatorDenominatorUnit,
    NumeratorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorRightUnit,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    DenominatorNumeratorLeftUnit,
    DenominatorNumeratorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorRightQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, NumeratorDenominatorLeftAndDenominatorDenominatorQuantity>, DenominatorUnit>,
) where
        NumeratorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftQuantity>,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorRightAndDenominatorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>,
        NumeratorNumeratorRightAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftQuantity, NumeratorNumeratorLeftUnit, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightUnit>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorLeftAndDenominatorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity>,
        NumeratorDenominatorLeftAndDenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorRightQuantity>,
        NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorUnit, NumeratorDenominatorRightQuantity, NumeratorDenominatorRightUnit>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, NumeratorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorRightQuantity>, NumeratorDenominatorUnit>,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorLeftUnit : UndefinedScientificUnit<DenominatorNumeratorLeftQuantity>,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<DenominatorNumeratorLeftQuantity, DenominatorNumeratorLeftUnit, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightUnit>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    div(
        right,
        numeratorDenominatorLeftAndDenominatorDenominatorUnitXDenominatorNumeratorLeftUnit = { x(it) },
        numeratorNumeratorLeftUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.UKImperial<
                NumeratorNumeratorLeftQuantity,
                NumeratorNumeratorLeftUnit,
                UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, DenominatorNumeratorLeftQuantity>,
                UndefinedMultipliedUnit.UKImperial<
                    NumeratorDenominatorLeftAndDenominatorDenominatorQuantity,
                    NumeratorDenominatorLeftAndDenominatorDenominatorUnit,
                    DenominatorNumeratorLeftQuantity,
                    DenominatorNumeratorLeftUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryUndefinedAXUndefinedBPerUndefinedCXUndefinedDValueDivUSCustomaryUndefinedEXUndefinedBPerUndefinedCValue")
infix operator fun <
    NumeratorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftUnit,
    NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightAndDenominatorNumeratorRightUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorLeftAndDenominatorDenominatorQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftAndDenominatorDenominatorUnit,
    NumeratorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorRightUnit,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    DenominatorNumeratorLeftUnit,
    DenominatorNumeratorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorRightQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, NumeratorDenominatorLeftAndDenominatorDenominatorQuantity>, DenominatorUnit>,
) where
        NumeratorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftQuantity>,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorRightAndDenominatorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>,
        NumeratorNumeratorRightAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftQuantity, NumeratorNumeratorLeftUnit, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightUnit>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorLeftAndDenominatorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity>,
        NumeratorDenominatorLeftAndDenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorRightQuantity>,
        NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorUnit, NumeratorDenominatorRightQuantity, NumeratorDenominatorRightUnit>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, NumeratorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorRightQuantity>, NumeratorDenominatorUnit>,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorLeftUnit : UndefinedScientificUnit<DenominatorNumeratorLeftQuantity>,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<DenominatorNumeratorLeftQuantity, DenominatorNumeratorLeftUnit, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightUnit>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    div(
        right,
        numeratorDenominatorLeftAndDenominatorDenominatorUnitXDenominatorNumeratorLeftUnit = { x(it) },
        numeratorNumeratorLeftUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.USCustomary<
                NumeratorNumeratorLeftQuantity,
                NumeratorNumeratorLeftUnit,
                UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, DenominatorNumeratorLeftQuantity>,
                UndefinedMultipliedUnit.USCustomary<
                    NumeratorDenominatorLeftAndDenominatorDenominatorQuantity,
                    NumeratorDenominatorLeftAndDenominatorDenominatorUnit,
                    DenominatorNumeratorLeftQuantity,
                    DenominatorNumeratorLeftUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialUndefinedAXUndefinedBPerUndefinedCXUndefinedDValueDivMetricAndUKImperialUndefinedEXUndefinedBPerUndefinedCValue")
infix operator fun <
    NumeratorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftUnit,
    NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightAndDenominatorNumeratorRightUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorLeftAndDenominatorDenominatorQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftAndDenominatorDenominatorUnit,
    NumeratorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorRightUnit,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    DenominatorNumeratorLeftUnit,
    DenominatorNumeratorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorRightQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, NumeratorDenominatorLeftAndDenominatorDenominatorQuantity>, DenominatorUnit>,
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
        NumeratorDenominatorLeftAndDenominatorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity>,
        NumeratorDenominatorLeftAndDenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorLeftAndDenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorRightQuantity>,
        NumeratorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorUnit, NumeratorDenominatorRightQuantity, NumeratorDenominatorRightUnit>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, NumeratorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorRightQuantity>, NumeratorDenominatorUnit>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorLeftUnit : UndefinedScientificUnit<DenominatorNumeratorLeftQuantity>,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<DenominatorNumeratorLeftQuantity, DenominatorNumeratorLeftUnit, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightUnit>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    div(
        right,
        numeratorDenominatorLeftAndDenominatorDenominatorUnitXDenominatorNumeratorLeftUnit = { x(it) },
        numeratorNumeratorLeftUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUKImperial<
                NumeratorNumeratorLeftQuantity,
                NumeratorNumeratorLeftUnit,
                UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, DenominatorNumeratorLeftQuantity>,
                UndefinedMultipliedUnit.MetricAndUKImperial<
                    NumeratorDenominatorLeftAndDenominatorDenominatorQuantity,
                    NumeratorDenominatorLeftAndDenominatorDenominatorUnit,
                    DenominatorNumeratorLeftQuantity,
                    DenominatorNumeratorLeftUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryUndefinedAXUndefinedBPerUndefinedCXUndefinedDValueDivMetricAndUSCustomaryUndefinedEXUndefinedBPerUndefinedCValue")
infix operator fun <
    NumeratorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftUnit,
    NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightAndDenominatorNumeratorRightUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorLeftAndDenominatorDenominatorQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftAndDenominatorDenominatorUnit,
    NumeratorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorRightUnit,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    DenominatorNumeratorLeftUnit,
    DenominatorNumeratorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorRightQuantity>>, NumeratorUnit>.div(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, NumeratorDenominatorLeftAndDenominatorDenominatorQuantity>, DenominatorUnit>,
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
        NumeratorDenominatorLeftAndDenominatorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity>,
        NumeratorDenominatorLeftAndDenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorLeftAndDenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorRightQuantity>,
        NumeratorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorUnit, NumeratorDenominatorRightQuantity, NumeratorDenominatorRightUnit>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, NumeratorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorRightQuantity>, NumeratorDenominatorUnit>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorLeftUnit : UndefinedScientificUnit<DenominatorNumeratorLeftQuantity>,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<DenominatorNumeratorLeftQuantity, DenominatorNumeratorLeftUnit, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightUnit>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    div(
        right,
        numeratorDenominatorLeftAndDenominatorDenominatorUnitXDenominatorNumeratorLeftUnit = { x(it) },
        numeratorNumeratorLeftUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUSCustomary<
                NumeratorNumeratorLeftQuantity,
                NumeratorNumeratorLeftUnit,
                UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, DenominatorNumeratorLeftQuantity>,
                UndefinedMultipliedUnit.MetricAndUSCustomary<
                    NumeratorDenominatorLeftAndDenominatorDenominatorQuantity,
                    NumeratorDenominatorLeftAndDenominatorDenominatorUnit,
                    DenominatorNumeratorLeftQuantity,
                    DenominatorNumeratorLeftUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }
