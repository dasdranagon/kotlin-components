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

import com.splendo.kaluga.scientific.UndefinedQuantityType
import com.splendo.kaluga.scientific.UndefinedScientificValue
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import kotlin.jvm.JvmName

@JvmName("metricAndImperialUndefinedBXUndefinedCPerUndefinedAValueTimesMetricAndImperialUndefinedAPerUndefinedBValue")
infix operator fun <
    LeftNumeratorLeftAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorLeftAndRightDenominatorUnit,
    LeftNumeratorRightQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorAndRightNumeratorQuantity : UndefinedQuantityType,
    LeftDenominatorAndRightNumeratorUnit,
    LeftUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorQuantity, LeftNumeratorRightQuantity>, LeftDenominatorAndRightNumeratorQuantity>, LeftUnit>.times(
    right: UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftDenominatorAndRightNumeratorQuantity, LeftNumeratorLeftAndRightDenominatorQuantity>, RightUnit>,
) where
        LeftNumeratorLeftAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorQuantity>,
        LeftNumeratorLeftAndRightDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorLeftAndRightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorLeftAndRightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightDenominatorQuantity, LeftNumeratorLeftAndRightDenominatorUnit, LeftNumeratorRightQuantity, LeftNumeratorRightUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorAndRightNumeratorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorQuantity>,
        LeftDenominatorAndRightNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorAndRightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorAndRightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorQuantity, LeftNumeratorRightQuantity>, LeftNumeratorUnit, LeftDenominatorAndRightNumeratorQuantity, LeftDenominatorAndRightNumeratorUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<LeftDenominatorAndRightNumeratorQuantity, LeftDenominatorAndRightNumeratorUnit, LeftNumeratorLeftAndRightDenominatorQuantity, LeftNumeratorLeftAndRightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    right times this

@JvmName("metricUndefinedBXUndefinedCPerUndefinedAValueTimesMetricUndefinedAPerUndefinedBValue")
infix operator fun <
    LeftNumeratorLeftAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorLeftAndRightDenominatorUnit,
    LeftNumeratorRightQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorAndRightNumeratorQuantity : UndefinedQuantityType,
    LeftDenominatorAndRightNumeratorUnit,
    LeftUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorQuantity, LeftNumeratorRightQuantity>, LeftDenominatorAndRightNumeratorQuantity>, LeftUnit>.times(
    right: UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftDenominatorAndRightNumeratorQuantity, LeftNumeratorLeftAndRightDenominatorQuantity>, RightUnit>,
) where
        LeftNumeratorLeftAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorQuantity>,
        LeftNumeratorLeftAndRightDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightDenominatorQuantity, LeftNumeratorLeftAndRightDenominatorUnit, LeftNumeratorRightQuantity, LeftNumeratorRightUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorAndRightNumeratorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorQuantity>,
        LeftDenominatorAndRightNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorQuantity, LeftNumeratorRightQuantity>, LeftNumeratorUnit, LeftDenominatorAndRightNumeratorQuantity, LeftDenominatorAndRightNumeratorUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        RightUnit : UndefinedDividedUnit<LeftDenominatorAndRightNumeratorQuantity, LeftDenominatorAndRightNumeratorUnit, LeftNumeratorLeftAndRightDenominatorQuantity, LeftNumeratorLeftAndRightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInMetric =
    right times this

@JvmName("imperialUndefinedBXUndefinedCPerUndefinedAValueTimesImperialUndefinedAPerUndefinedBValue")
infix operator fun <
    LeftNumeratorLeftAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorLeftAndRightDenominatorUnit,
    LeftNumeratorRightQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorAndRightNumeratorQuantity : UndefinedQuantityType,
    LeftDenominatorAndRightNumeratorUnit,
    LeftUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorQuantity, LeftNumeratorRightQuantity>, LeftDenominatorAndRightNumeratorQuantity>, LeftUnit>.times(
    right: UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftDenominatorAndRightNumeratorQuantity, LeftNumeratorLeftAndRightDenominatorQuantity>, RightUnit>,
) where
        LeftNumeratorLeftAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorQuantity>,
        LeftNumeratorLeftAndRightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorLeftAndRightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightDenominatorQuantity, LeftNumeratorLeftAndRightDenominatorUnit, LeftNumeratorRightQuantity, LeftNumeratorRightUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorAndRightNumeratorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorQuantity>,
        LeftDenominatorAndRightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorAndRightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorQuantity, LeftNumeratorRightQuantity>, LeftNumeratorUnit, LeftDenominatorAndRightNumeratorQuantity, LeftDenominatorAndRightNumeratorUnit>,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<LeftDenominatorAndRightNumeratorQuantity, LeftDenominatorAndRightNumeratorUnit, LeftNumeratorLeftAndRightDenominatorQuantity, LeftNumeratorLeftAndRightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    right times this

@JvmName("ukImperialUndefinedBXUndefinedCPerUndefinedAValueTimesUKImperialUndefinedAPerUndefinedBValue")
infix operator fun <
    LeftNumeratorLeftAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorLeftAndRightDenominatorUnit,
    LeftNumeratorRightQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorAndRightNumeratorQuantity : UndefinedQuantityType,
    LeftDenominatorAndRightNumeratorUnit,
    LeftUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorQuantity, LeftNumeratorRightQuantity>, LeftDenominatorAndRightNumeratorQuantity>, LeftUnit>.times(
    right: UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftDenominatorAndRightNumeratorQuantity, LeftNumeratorLeftAndRightDenominatorQuantity>, RightUnit>,
) where
        LeftNumeratorLeftAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorQuantity>,
        LeftNumeratorLeftAndRightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightDenominatorQuantity, LeftNumeratorLeftAndRightDenominatorUnit, LeftNumeratorRightQuantity, LeftNumeratorRightUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorAndRightNumeratorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorQuantity>,
        LeftDenominatorAndRightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorQuantity, LeftNumeratorRightQuantity>, LeftNumeratorUnit, LeftDenominatorAndRightNumeratorQuantity, LeftDenominatorAndRightNumeratorUnit>,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedDividedUnit<LeftDenominatorAndRightNumeratorQuantity, LeftDenominatorAndRightNumeratorUnit, LeftNumeratorLeftAndRightDenominatorQuantity, LeftNumeratorLeftAndRightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    right times this

@JvmName("usCustomaryUndefinedBXUndefinedCPerUndefinedAValueTimesUSCustomaryUndefinedAPerUndefinedBValue")
infix operator fun <
    LeftNumeratorLeftAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorLeftAndRightDenominatorUnit,
    LeftNumeratorRightQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorAndRightNumeratorQuantity : UndefinedQuantityType,
    LeftDenominatorAndRightNumeratorUnit,
    LeftUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorQuantity, LeftNumeratorRightQuantity>, LeftDenominatorAndRightNumeratorQuantity>, LeftUnit>.times(
    right: UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftDenominatorAndRightNumeratorQuantity, LeftNumeratorLeftAndRightDenominatorQuantity>, RightUnit>,
) where
        LeftNumeratorLeftAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorQuantity>,
        LeftNumeratorLeftAndRightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightDenominatorQuantity, LeftNumeratorLeftAndRightDenominatorUnit, LeftNumeratorRightQuantity, LeftNumeratorRightUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorAndRightNumeratorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorQuantity>,
        LeftDenominatorAndRightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorQuantity, LeftNumeratorRightQuantity>, LeftNumeratorUnit, LeftDenominatorAndRightNumeratorQuantity, LeftDenominatorAndRightNumeratorUnit>,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<LeftDenominatorAndRightNumeratorQuantity, LeftDenominatorAndRightNumeratorUnit, LeftNumeratorLeftAndRightDenominatorQuantity, LeftNumeratorLeftAndRightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    right times this

@JvmName("metricAndUKImperialUndefinedBXUndefinedCPerUndefinedAValueTimesMetricAndUKImperialUndefinedAPerUndefinedBValue")
infix operator fun <
    LeftNumeratorLeftAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorLeftAndRightDenominatorUnit,
    LeftNumeratorRightQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorAndRightNumeratorQuantity : UndefinedQuantityType,
    LeftDenominatorAndRightNumeratorUnit,
    LeftUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorQuantity, LeftNumeratorRightQuantity>, LeftDenominatorAndRightNumeratorQuantity>, LeftUnit>.times(
    right: UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftDenominatorAndRightNumeratorQuantity, LeftNumeratorLeftAndRightDenominatorQuantity>, RightUnit>,
) where
        LeftNumeratorLeftAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorQuantity>,
        LeftNumeratorLeftAndRightDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorLeftAndRightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightDenominatorQuantity, LeftNumeratorLeftAndRightDenominatorUnit, LeftNumeratorRightQuantity, LeftNumeratorRightUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorAndRightNumeratorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorQuantity>,
        LeftDenominatorAndRightNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorAndRightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorQuantity, LeftNumeratorRightQuantity>, LeftNumeratorUnit, LeftDenominatorAndRightNumeratorQuantity, LeftDenominatorAndRightNumeratorUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedDividedUnit<LeftDenominatorAndRightNumeratorQuantity, LeftDenominatorAndRightNumeratorUnit, LeftNumeratorLeftAndRightDenominatorQuantity, LeftNumeratorLeftAndRightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    right times this

@JvmName("metricAndUSCustomaryUndefinedBXUndefinedCPerUndefinedAValueTimesMetricAndUSCustomaryUndefinedAPerUndefinedBValue")
infix operator fun <
    LeftNumeratorLeftAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorLeftAndRightDenominatorUnit,
    LeftNumeratorRightQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorAndRightNumeratorQuantity : UndefinedQuantityType,
    LeftDenominatorAndRightNumeratorUnit,
    LeftUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorQuantity, LeftNumeratorRightQuantity>, LeftDenominatorAndRightNumeratorQuantity>, LeftUnit>.times(
    right: UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftDenominatorAndRightNumeratorQuantity, LeftNumeratorLeftAndRightDenominatorQuantity>, RightUnit>,
) where
        LeftNumeratorLeftAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorQuantity>,
        LeftNumeratorLeftAndRightDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorLeftAndRightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightDenominatorQuantity, LeftNumeratorLeftAndRightDenominatorUnit, LeftNumeratorRightQuantity, LeftNumeratorRightUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorAndRightNumeratorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorQuantity>,
        LeftDenominatorAndRightNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorAndRightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorQuantity, LeftNumeratorRightQuantity>, LeftNumeratorUnit, LeftDenominatorAndRightNumeratorQuantity, LeftDenominatorAndRightNumeratorUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<LeftDenominatorAndRightNumeratorQuantity, LeftDenominatorAndRightNumeratorUnit, LeftNumeratorLeftAndRightDenominatorQuantity, LeftNumeratorLeftAndRightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    right times this

@JvmName("genericUndefinedBXUndefinedCPerUndefinedAValueTimesGenericUndefinedAPerUndefinedBValue")
infix operator fun <
    LeftNumeratorLeftAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorLeftAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorQuantity>,
    LeftNumeratorRightQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightQuantity>,
    LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightDenominatorQuantity, LeftNumeratorLeftAndRightDenominatorUnit, LeftNumeratorRightQuantity, LeftNumeratorRightUnit>,
    LeftDenominatorAndRightNumeratorQuantity : UndefinedQuantityType,
    LeftDenominatorAndRightNumeratorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorQuantity>,
    LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorQuantity, LeftNumeratorRightQuantity>, LeftNumeratorUnit, LeftDenominatorAndRightNumeratorQuantity, LeftDenominatorAndRightNumeratorUnit>,
    RightUnit : UndefinedDividedUnit<LeftDenominatorAndRightNumeratorQuantity, LeftDenominatorAndRightNumeratorUnit, LeftNumeratorLeftAndRightDenominatorQuantity, LeftNumeratorLeftAndRightDenominatorUnit>,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorQuantity, LeftNumeratorRightQuantity>, LeftDenominatorAndRightNumeratorQuantity>, LeftUnit>.times(
    right: UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftDenominatorAndRightNumeratorQuantity, LeftNumeratorLeftAndRightDenominatorQuantity>, RightUnit>,
) = right times this
