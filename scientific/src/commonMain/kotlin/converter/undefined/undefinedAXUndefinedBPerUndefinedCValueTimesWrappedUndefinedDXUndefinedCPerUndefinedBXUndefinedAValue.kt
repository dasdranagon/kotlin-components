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
import com.splendo.kaluga.scientific.byMultiplying
import com.splendo.kaluga.scientific.unit.AbstractScientificUnit
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.ScientificUnit
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.WrappedUndefinedExtendedUnit
import kotlin.jvm.JvmName

@JvmName("undefinedAXUndefinedBPerUndefinedCValueTimesWrappedUndefinedDXUndefinedCPerUndefinedBXUndefinedAValue")
fun <
    LeftNumeratorLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftNumeratorLeftAndRightDenominatorRightUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
    LeftNumeratorRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorRightAndRightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
    LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorLeftAndRightDenominatorRightUnit, LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorRightAndRightDenominatorLeftUnit>,
    LeftDenominatorAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftDenominatorAndRightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
    LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorRightAndRightDenominatorLeftQuantity>, LeftNumeratorUnit, LeftDenominatorAndRightNumeratorRightQuantity, LeftDenominatorAndRightNumeratorRightUnit>,
    RightNumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightNumeratorLeftUnit : ScientificUnit<RightNumeratorLeftQuantity>,
    WrappedRightNumeratorLeftUnit : WrappedUndefinedExtendedUnit<RightNumeratorLeftQuantity, RightNumeratorLeftUnit>,
    RightNumeratorUnit : UndefinedMultipliedUnit<UndefinedQuantityType.Extended<RightNumeratorLeftQuantity>, WrappedRightNumeratorLeftUnit, LeftDenominatorAndRightNumeratorRightQuantity, LeftDenominatorAndRightNumeratorRightUnit>,
    RightDenominatorUnit : UndefinedMultipliedUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorRightAndRightDenominatorLeftUnit, LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorLeftAndRightDenominatorRightUnit>,
    RightUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<RightNumeratorLeftQuantity>, LeftDenominatorAndRightNumeratorRightQuantity>, RightNumeratorUnit, UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorLeftAndRightDenominatorRightQuantity>, RightDenominatorUnit>,
    RightNumeratorLeftValue : ScientificValue<RightNumeratorLeftQuantity, RightNumeratorLeftUnit>,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorRightAndRightDenominatorLeftQuantity>, LeftDenominatorAndRightNumeratorRightQuantity>, LeftUnit>.times(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<RightNumeratorLeftQuantity>, LeftDenominatorAndRightNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorLeftAndRightDenominatorRightQuantity>>, RightUnit>,
    factory: (Decimal, RightNumeratorLeftUnit) -> RightNumeratorLeftValue,
) = right.unit.numerator.left.wrapped.byMultiplying(this, right, factory)

@JvmName("metricAndImperialUndefinedAXUndefinedBPerUndefinedCValueTimesMetricAndImperialWrappedUndefinedDXUndefinedCPerUndefinedBXUndefinedAValue")
infix operator fun <
    LeftNumeratorLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftNumeratorLeftAndRightDenominatorRightUnit,
    LeftNumeratorRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorRightAndRightDenominatorLeftUnit,
    LeftNumeratorUnit,
    LeftDenominatorAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftDenominatorAndRightNumeratorRightUnit,
    LeftUnit,
    RightNumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightNumeratorLeftUnit,
    WrappedRightNumeratorLeftUnit,
    RightNumeratorUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorRightAndRightDenominatorLeftQuantity>, LeftDenominatorAndRightNumeratorRightQuantity>, LeftUnit>.times(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<RightNumeratorLeftQuantity>, LeftDenominatorAndRightNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorLeftAndRightDenominatorRightQuantity>>, RightUnit>,
) where
        LeftNumeratorLeftAndRightDenominatorRightUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
        LeftNumeratorLeftAndRightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorLeftAndRightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorLeftAndRightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightAndRightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
        LeftNumeratorRightAndRightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightAndRightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightAndRightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorLeftAndRightDenominatorRightUnit, LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorRightAndRightDenominatorLeftUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorAndRightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
        LeftDenominatorAndRightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorAndRightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorAndRightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorRightAndRightDenominatorLeftQuantity>, LeftNumeratorUnit, LeftDenominatorAndRightNumeratorRightQuantity, LeftDenominatorAndRightNumeratorRightUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorLeftUnit : AbstractScientificUnit<RightNumeratorLeftQuantity>,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedRightNumeratorLeftUnit : WrappedUndefinedExtendedUnit<RightNumeratorLeftQuantity, RightNumeratorLeftUnit>,
        WrappedRightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        WrappedRightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        WrappedRightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedMultipliedUnit<UndefinedQuantityType.Extended<RightNumeratorLeftQuantity>, WrappedRightNumeratorLeftUnit, LeftDenominatorAndRightNumeratorRightQuantity, LeftDenominatorAndRightNumeratorRightUnit>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : UndefinedMultipliedUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorRightAndRightDenominatorLeftUnit, LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorLeftAndRightDenominatorRightUnit>,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<RightNumeratorLeftQuantity>, LeftDenominatorAndRightNumeratorRightQuantity>, RightNumeratorUnit, UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorLeftAndRightDenominatorRightQuantity>, RightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    times(right) {
            value: Decimal,
            unit: RightNumeratorLeftUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricUndefinedAXUndefinedBPerUndefinedCValueTimesMetricWrappedUndefinedDXUndefinedCPerUndefinedBXUndefinedAValue")
infix operator fun <
    LeftNumeratorLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftNumeratorLeftAndRightDenominatorRightUnit,
    LeftNumeratorRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorRightAndRightDenominatorLeftUnit,
    LeftNumeratorUnit,
    LeftDenominatorAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftDenominatorAndRightNumeratorRightUnit,
    LeftUnit,
    RightNumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightNumeratorLeftUnit,
    WrappedRightNumeratorLeftUnit,
    RightNumeratorUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorRightAndRightDenominatorLeftQuantity>, LeftDenominatorAndRightNumeratorRightQuantity>, LeftUnit>.times(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<RightNumeratorLeftQuantity>, LeftDenominatorAndRightNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorLeftAndRightDenominatorRightQuantity>>, RightUnit>,
) where
        LeftNumeratorLeftAndRightDenominatorRightUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
        LeftNumeratorLeftAndRightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightAndRightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
        LeftNumeratorRightAndRightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorLeftAndRightDenominatorRightUnit, LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorRightAndRightDenominatorLeftUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorAndRightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
        LeftDenominatorAndRightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorRightAndRightDenominatorLeftQuantity>, LeftNumeratorUnit, LeftDenominatorAndRightNumeratorRightQuantity, LeftDenominatorAndRightNumeratorRightUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorLeftUnit : AbstractScientificUnit<RightNumeratorLeftQuantity>,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        WrappedRightNumeratorLeftUnit : WrappedUndefinedExtendedUnit<RightNumeratorLeftQuantity, RightNumeratorLeftUnit>,
        WrappedRightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : UndefinedMultipliedUnit<UndefinedQuantityType.Extended<RightNumeratorLeftQuantity>, WrappedRightNumeratorLeftUnit, LeftDenominatorAndRightNumeratorRightQuantity, LeftDenominatorAndRightNumeratorRightUnit>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : UndefinedMultipliedUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorRightAndRightDenominatorLeftUnit, LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorLeftAndRightDenominatorRightUnit>,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<RightNumeratorLeftQuantity>, LeftDenominatorAndRightNumeratorRightQuantity>, RightNumeratorUnit, UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorLeftAndRightDenominatorRightQuantity>, RightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInMetric =
    times(right) {
            value: Decimal,
            unit: RightNumeratorLeftUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("imperialUndefinedAXUndefinedBPerUndefinedCValueTimesImperialWrappedUndefinedDXUndefinedCPerUndefinedBXUndefinedAValue")
infix operator fun <
    LeftNumeratorLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftNumeratorLeftAndRightDenominatorRightUnit,
    LeftNumeratorRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorRightAndRightDenominatorLeftUnit,
    LeftNumeratorUnit,
    LeftDenominatorAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftDenominatorAndRightNumeratorRightUnit,
    LeftUnit,
    RightNumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightNumeratorLeftUnit,
    WrappedRightNumeratorLeftUnit,
    RightNumeratorUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorRightAndRightDenominatorLeftQuantity>, LeftDenominatorAndRightNumeratorRightQuantity>, LeftUnit>.times(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<RightNumeratorLeftQuantity>, LeftDenominatorAndRightNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorLeftAndRightDenominatorRightQuantity>>, RightUnit>,
) where
        LeftNumeratorLeftAndRightDenominatorRightUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
        LeftNumeratorLeftAndRightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorLeftAndRightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightAndRightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
        LeftNumeratorRightAndRightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightAndRightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorLeftAndRightDenominatorRightUnit, LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorRightAndRightDenominatorLeftUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorAndRightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
        LeftDenominatorAndRightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorAndRightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorRightAndRightDenominatorLeftQuantity>, LeftNumeratorUnit, LeftDenominatorAndRightNumeratorRightQuantity, LeftDenominatorAndRightNumeratorRightUnit>,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorLeftUnit : AbstractScientificUnit<RightNumeratorLeftQuantity>,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedRightNumeratorLeftUnit : WrappedUndefinedExtendedUnit<RightNumeratorLeftQuantity, RightNumeratorLeftUnit>,
        WrappedRightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        WrappedRightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedMultipliedUnit<UndefinedQuantityType.Extended<RightNumeratorLeftQuantity>, WrappedRightNumeratorLeftUnit, LeftDenominatorAndRightNumeratorRightQuantity, LeftDenominatorAndRightNumeratorRightUnit>,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : UndefinedMultipliedUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorRightAndRightDenominatorLeftUnit, LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorLeftAndRightDenominatorRightUnit>,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<RightNumeratorLeftQuantity>, LeftDenominatorAndRightNumeratorRightQuantity>, RightNumeratorUnit, UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorLeftAndRightDenominatorRightQuantity>, RightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    times(right) {
            value: Decimal,
            unit: RightNumeratorLeftUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("ukImperialUndefinedAXUndefinedBPerUndefinedCValueTimesUKImperialWrappedUndefinedDXUndefinedCPerUndefinedBXUndefinedAValue")
infix operator fun <
    LeftNumeratorLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftNumeratorLeftAndRightDenominatorRightUnit,
    LeftNumeratorRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorRightAndRightDenominatorLeftUnit,
    LeftNumeratorUnit,
    LeftDenominatorAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftDenominatorAndRightNumeratorRightUnit,
    LeftUnit,
    RightNumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightNumeratorLeftUnit,
    WrappedRightNumeratorLeftUnit,
    RightNumeratorUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorRightAndRightDenominatorLeftQuantity>, LeftDenominatorAndRightNumeratorRightQuantity>, LeftUnit>.times(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<RightNumeratorLeftQuantity>, LeftDenominatorAndRightNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorLeftAndRightDenominatorRightQuantity>>, RightUnit>,
) where
        LeftNumeratorLeftAndRightDenominatorRightUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
        LeftNumeratorLeftAndRightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightAndRightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
        LeftNumeratorRightAndRightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorLeftAndRightDenominatorRightUnit, LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorRightAndRightDenominatorLeftUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorAndRightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
        LeftDenominatorAndRightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorRightAndRightDenominatorLeftQuantity>, LeftNumeratorUnit, LeftDenominatorAndRightNumeratorRightQuantity, LeftDenominatorAndRightNumeratorRightUnit>,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorLeftUnit : AbstractScientificUnit<RightNumeratorLeftQuantity>,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        WrappedRightNumeratorLeftUnit : WrappedUndefinedExtendedUnit<RightNumeratorLeftQuantity, RightNumeratorLeftUnit>,
        WrappedRightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : UndefinedMultipliedUnit<UndefinedQuantityType.Extended<RightNumeratorLeftQuantity>, WrappedRightNumeratorLeftUnit, LeftDenominatorAndRightNumeratorRightQuantity, LeftDenominatorAndRightNumeratorRightUnit>,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : UndefinedMultipliedUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorRightAndRightDenominatorLeftUnit, LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorLeftAndRightDenominatorRightUnit>,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<RightNumeratorLeftQuantity>, LeftDenominatorAndRightNumeratorRightQuantity>, RightNumeratorUnit, UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorLeftAndRightDenominatorRightQuantity>, RightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    times(right) {
            value: Decimal,
            unit: RightNumeratorLeftUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("usCustomaryUndefinedAXUndefinedBPerUndefinedCValueTimesUSCustomaryWrappedUndefinedDXUndefinedCPerUndefinedBXUndefinedAValue")
infix operator fun <
    LeftNumeratorLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftNumeratorLeftAndRightDenominatorRightUnit,
    LeftNumeratorRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorRightAndRightDenominatorLeftUnit,
    LeftNumeratorUnit,
    LeftDenominatorAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftDenominatorAndRightNumeratorRightUnit,
    LeftUnit,
    RightNumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightNumeratorLeftUnit,
    WrappedRightNumeratorLeftUnit,
    RightNumeratorUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorRightAndRightDenominatorLeftQuantity>, LeftDenominatorAndRightNumeratorRightQuantity>, LeftUnit>.times(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<RightNumeratorLeftQuantity>, LeftDenominatorAndRightNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorLeftAndRightDenominatorRightQuantity>>, RightUnit>,
) where
        LeftNumeratorLeftAndRightDenominatorRightUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
        LeftNumeratorLeftAndRightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightAndRightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
        LeftNumeratorRightAndRightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorLeftAndRightDenominatorRightUnit, LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorRightAndRightDenominatorLeftUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorAndRightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
        LeftDenominatorAndRightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorRightAndRightDenominatorLeftQuantity>, LeftNumeratorUnit, LeftDenominatorAndRightNumeratorRightQuantity, LeftDenominatorAndRightNumeratorRightUnit>,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorLeftUnit : AbstractScientificUnit<RightNumeratorLeftQuantity>,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedRightNumeratorLeftUnit : WrappedUndefinedExtendedUnit<RightNumeratorLeftQuantity, RightNumeratorLeftUnit>,
        WrappedRightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedMultipliedUnit<UndefinedQuantityType.Extended<RightNumeratorLeftQuantity>, WrappedRightNumeratorLeftUnit, LeftDenominatorAndRightNumeratorRightQuantity, LeftDenominatorAndRightNumeratorRightUnit>,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : UndefinedMultipliedUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorRightAndRightDenominatorLeftUnit, LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorLeftAndRightDenominatorRightUnit>,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<RightNumeratorLeftQuantity>, LeftDenominatorAndRightNumeratorRightQuantity>, RightNumeratorUnit, UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorLeftAndRightDenominatorRightQuantity>, RightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    times(right) {
            value: Decimal,
            unit: RightNumeratorLeftUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialUndefinedAXUndefinedBPerUndefinedCValueTimesMetricAndUKImperialWrappedUndefinedDXUndefinedCPerUndefinedBXUndefinedAValue")
infix operator fun <
    LeftNumeratorLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftNumeratorLeftAndRightDenominatorRightUnit,
    LeftNumeratorRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorRightAndRightDenominatorLeftUnit,
    LeftNumeratorUnit,
    LeftDenominatorAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftDenominatorAndRightNumeratorRightUnit,
    LeftUnit,
    RightNumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightNumeratorLeftUnit,
    WrappedRightNumeratorLeftUnit,
    RightNumeratorUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorRightAndRightDenominatorLeftQuantity>, LeftDenominatorAndRightNumeratorRightQuantity>, LeftUnit>.times(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<RightNumeratorLeftQuantity>, LeftDenominatorAndRightNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorLeftAndRightDenominatorRightQuantity>>, RightUnit>,
) where
        LeftNumeratorLeftAndRightDenominatorRightUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
        LeftNumeratorLeftAndRightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorLeftAndRightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightAndRightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
        LeftNumeratorRightAndRightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightAndRightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorLeftAndRightDenominatorRightUnit, LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorRightAndRightDenominatorLeftUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorAndRightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
        LeftDenominatorAndRightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorAndRightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorRightAndRightDenominatorLeftQuantity>, LeftNumeratorUnit, LeftDenominatorAndRightNumeratorRightQuantity, LeftDenominatorAndRightNumeratorRightUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorLeftUnit : AbstractScientificUnit<RightNumeratorLeftQuantity>,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        WrappedRightNumeratorLeftUnit : WrappedUndefinedExtendedUnit<RightNumeratorLeftQuantity, RightNumeratorLeftUnit>,
        WrappedRightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        WrappedRightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : UndefinedMultipliedUnit<UndefinedQuantityType.Extended<RightNumeratorLeftQuantity>, WrappedRightNumeratorLeftUnit, LeftDenominatorAndRightNumeratorRightQuantity, LeftDenominatorAndRightNumeratorRightUnit>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : UndefinedMultipliedUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorRightAndRightDenominatorLeftUnit, LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorLeftAndRightDenominatorRightUnit>,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<RightNumeratorLeftQuantity>, LeftDenominatorAndRightNumeratorRightQuantity>, RightNumeratorUnit, UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorLeftAndRightDenominatorRightQuantity>, RightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    times(right) {
            value: Decimal,
            unit: RightNumeratorLeftUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryUndefinedAXUndefinedBPerUndefinedCValueTimesMetricAndUSCustomaryWrappedUndefinedDXUndefinedCPerUndefinedBXUndefinedAValue")
infix operator fun <
    LeftNumeratorLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftNumeratorLeftAndRightDenominatorRightUnit,
    LeftNumeratorRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorRightAndRightDenominatorLeftUnit,
    LeftNumeratorUnit,
    LeftDenominatorAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftDenominatorAndRightNumeratorRightUnit,
    LeftUnit,
    RightNumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightNumeratorLeftUnit,
    WrappedRightNumeratorLeftUnit,
    RightNumeratorUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorRightAndRightDenominatorLeftQuantity>, LeftDenominatorAndRightNumeratorRightQuantity>, LeftUnit>.times(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<RightNumeratorLeftQuantity>, LeftDenominatorAndRightNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorLeftAndRightDenominatorRightQuantity>>, RightUnit>,
) where
        LeftNumeratorLeftAndRightDenominatorRightUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
        LeftNumeratorLeftAndRightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorLeftAndRightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightAndRightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
        LeftNumeratorRightAndRightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightAndRightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorLeftAndRightDenominatorRightUnit, LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorRightAndRightDenominatorLeftUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorAndRightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
        LeftDenominatorAndRightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorAndRightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorRightAndRightDenominatorLeftQuantity>, LeftNumeratorUnit, LeftDenominatorAndRightNumeratorRightQuantity, LeftDenominatorAndRightNumeratorRightUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorLeftUnit : AbstractScientificUnit<RightNumeratorLeftQuantity>,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedRightNumeratorLeftUnit : WrappedUndefinedExtendedUnit<RightNumeratorLeftQuantity, RightNumeratorLeftUnit>,
        WrappedRightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        WrappedRightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedMultipliedUnit<UndefinedQuantityType.Extended<RightNumeratorLeftQuantity>, WrappedRightNumeratorLeftUnit, LeftDenominatorAndRightNumeratorRightQuantity, LeftDenominatorAndRightNumeratorRightUnit>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : UndefinedMultipliedUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorRightAndRightDenominatorLeftUnit, LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorLeftAndRightDenominatorRightUnit>,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<RightNumeratorLeftQuantity>, LeftDenominatorAndRightNumeratorRightQuantity>, RightNumeratorUnit, UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorLeftAndRightDenominatorRightQuantity>, RightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    times(right) {
            value: Decimal,
            unit: RightNumeratorLeftUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("genericUndefinedAXUndefinedBPerUndefinedCValueTimesGenericWrappedUndefinedDXUndefinedCPerUndefinedBXUndefinedAValue")
infix operator fun <
    LeftNumeratorLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftNumeratorLeftAndRightDenominatorRightUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
    LeftNumeratorRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorRightAndRightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
    LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorLeftAndRightDenominatorRightUnit, LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorRightAndRightDenominatorLeftUnit>,
    LeftDenominatorAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftDenominatorAndRightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
    LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorRightAndRightDenominatorLeftQuantity>, LeftNumeratorUnit, LeftDenominatorAndRightNumeratorRightQuantity, LeftDenominatorAndRightNumeratorRightUnit>,
    RightNumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightNumeratorLeftUnit : AbstractScientificUnit<RightNumeratorLeftQuantity>,
    WrappedRightNumeratorLeftUnit : WrappedUndefinedExtendedUnit<RightNumeratorLeftQuantity, RightNumeratorLeftUnit>,
    RightNumeratorUnit : UndefinedMultipliedUnit<UndefinedQuantityType.Extended<RightNumeratorLeftQuantity>, WrappedRightNumeratorLeftUnit, LeftDenominatorAndRightNumeratorRightQuantity, LeftDenominatorAndRightNumeratorRightUnit>,
    RightDenominatorUnit : UndefinedMultipliedUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorRightAndRightDenominatorLeftUnit, LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorLeftAndRightDenominatorRightUnit>,
    RightUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<RightNumeratorLeftQuantity>, LeftDenominatorAndRightNumeratorRightQuantity>, RightNumeratorUnit, UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorLeftAndRightDenominatorRightQuantity>, RightDenominatorUnit>,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorRightAndRightDenominatorLeftQuantity>, LeftDenominatorAndRightNumeratorRightQuantity>, LeftUnit>.times(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<RightNumeratorLeftQuantity>, LeftDenominatorAndRightNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorLeftAndRightDenominatorRightQuantity>>, RightUnit>,
) = times(right) {
        value: Decimal,
        unit: RightNumeratorLeftUnit,
    ->
    DefaultScientificValue(value, unit)
}
