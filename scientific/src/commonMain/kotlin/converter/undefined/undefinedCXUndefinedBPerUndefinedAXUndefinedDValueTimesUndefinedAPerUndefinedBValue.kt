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

@JvmName("metricAndImperialUndefinedCXUndefinedBPerUndefinedAXUndefinedDValueTimesMetricAndImperialUndefinedAPerUndefinedBValue")
infix operator fun <
    LeftNumeratorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit,
    LeftNumeratorRightAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorRightAndRightDenominatorUnit,
    LeftNumeratorUnit,
    LeftDenominatorLeftAndRightNumeratorQuantity : UndefinedQuantityType,
    LeftDenominatorLeftAndRightNumeratorUnit,
    LeftDenominatorRightQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorRightQuantity>>, LeftUnit>.times(
    right: UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftDenominatorLeftAndRightNumeratorQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, RightUnit>,
) where
        LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorQuantity>,
        LeftNumeratorRightAndRightDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightAndRightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightAndRightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftQuantity, LeftNumeratorLeftUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorLeftAndRightNumeratorUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorQuantity>,
        LeftDenominatorLeftAndRightNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorLeftAndRightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorLeftAndRightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorLeftAndRightNumeratorUnit, LeftDenominatorRightQuantity, LeftDenominatorRightUnit>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, LeftNumeratorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorRightQuantity>, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorLeftAndRightNumeratorUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    right times this

@JvmName("metricUndefinedCXUndefinedBPerUndefinedAXUndefinedDValueTimesMetricUndefinedAPerUndefinedBValue")
infix operator fun <
    LeftNumeratorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit,
    LeftNumeratorRightAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorRightAndRightDenominatorUnit,
    LeftNumeratorUnit,
    LeftDenominatorLeftAndRightNumeratorQuantity : UndefinedQuantityType,
    LeftDenominatorLeftAndRightNumeratorUnit,
    LeftDenominatorRightQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorRightQuantity>>, LeftUnit>.times(
    right: UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftDenominatorLeftAndRightNumeratorQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, RightUnit>,
) where
        LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorQuantity>,
        LeftNumeratorRightAndRightDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftQuantity, LeftNumeratorLeftUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorLeftAndRightNumeratorUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorQuantity>,
        LeftDenominatorLeftAndRightNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorLeftAndRightNumeratorUnit, LeftDenominatorRightQuantity, LeftDenominatorRightUnit>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, LeftNumeratorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorRightQuantity>, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        RightUnit : UndefinedDividedUnit<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorLeftAndRightNumeratorUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInMetric =
    right times this

@JvmName("imperialUndefinedCXUndefinedBPerUndefinedAXUndefinedDValueTimesImperialUndefinedAPerUndefinedBValue")
infix operator fun <
    LeftNumeratorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit,
    LeftNumeratorRightAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorRightAndRightDenominatorUnit,
    LeftNumeratorUnit,
    LeftDenominatorLeftAndRightNumeratorQuantity : UndefinedQuantityType,
    LeftDenominatorLeftAndRightNumeratorUnit,
    LeftDenominatorRightQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorRightQuantity>>, LeftUnit>.times(
    right: UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftDenominatorLeftAndRightNumeratorQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, RightUnit>,
) where
        LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorQuantity>,
        LeftNumeratorRightAndRightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightAndRightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftQuantity, LeftNumeratorLeftUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorLeftAndRightNumeratorUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorQuantity>,
        LeftDenominatorLeftAndRightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorLeftAndRightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorLeftAndRightNumeratorUnit, LeftDenominatorRightQuantity, LeftDenominatorRightUnit>,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, LeftNumeratorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorRightQuantity>, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorLeftAndRightNumeratorUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    right times this

@JvmName("ukImperialUndefinedCXUndefinedBPerUndefinedAXUndefinedDValueTimesUKImperialUndefinedAPerUndefinedBValue")
infix operator fun <
    LeftNumeratorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit,
    LeftNumeratorRightAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorRightAndRightDenominatorUnit,
    LeftNumeratorUnit,
    LeftDenominatorLeftAndRightNumeratorQuantity : UndefinedQuantityType,
    LeftDenominatorLeftAndRightNumeratorUnit,
    LeftDenominatorRightQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorRightQuantity>>, LeftUnit>.times(
    right: UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftDenominatorLeftAndRightNumeratorQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, RightUnit>,
) where
        LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorQuantity>,
        LeftNumeratorRightAndRightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftQuantity, LeftNumeratorLeftUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorLeftAndRightNumeratorUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorQuantity>,
        LeftDenominatorLeftAndRightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorLeftAndRightNumeratorUnit, LeftDenominatorRightQuantity, LeftDenominatorRightUnit>,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, LeftNumeratorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorRightQuantity>, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedDividedUnit<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorLeftAndRightNumeratorUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    right times this

@JvmName("usCustomaryUndefinedCXUndefinedBPerUndefinedAXUndefinedDValueTimesUSCustomaryUndefinedAPerUndefinedBValue")
infix operator fun <
    LeftNumeratorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit,
    LeftNumeratorRightAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorRightAndRightDenominatorUnit,
    LeftNumeratorUnit,
    LeftDenominatorLeftAndRightNumeratorQuantity : UndefinedQuantityType,
    LeftDenominatorLeftAndRightNumeratorUnit,
    LeftDenominatorRightQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorRightQuantity>>, LeftUnit>.times(
    right: UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftDenominatorLeftAndRightNumeratorQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, RightUnit>,
) where
        LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorQuantity>,
        LeftNumeratorRightAndRightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftQuantity, LeftNumeratorLeftUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorLeftAndRightNumeratorUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorQuantity>,
        LeftDenominatorLeftAndRightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorLeftAndRightNumeratorUnit, LeftDenominatorRightQuantity, LeftDenominatorRightUnit>,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, LeftNumeratorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorRightQuantity>, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorLeftAndRightNumeratorUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    right times this

@JvmName("metricAndUKImperialUndefinedCXUndefinedBPerUndefinedAXUndefinedDValueTimesMetricAndUKImperialUndefinedAPerUndefinedBValue")
infix operator fun <
    LeftNumeratorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit,
    LeftNumeratorRightAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorRightAndRightDenominatorUnit,
    LeftNumeratorUnit,
    LeftDenominatorLeftAndRightNumeratorQuantity : UndefinedQuantityType,
    LeftDenominatorLeftAndRightNumeratorUnit,
    LeftDenominatorRightQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorRightQuantity>>, LeftUnit>.times(
    right: UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftDenominatorLeftAndRightNumeratorQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, RightUnit>,
) where
        LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorQuantity>,
        LeftNumeratorRightAndRightDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightAndRightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftQuantity, LeftNumeratorLeftUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorLeftAndRightNumeratorUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorQuantity>,
        LeftDenominatorLeftAndRightNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorLeftAndRightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorLeftAndRightNumeratorUnit, LeftDenominatorRightQuantity, LeftDenominatorRightUnit>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, LeftNumeratorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorRightQuantity>, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedDividedUnit<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorLeftAndRightNumeratorUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    right times this

@JvmName("metricAndUSCustomaryUndefinedCXUndefinedBPerUndefinedAXUndefinedDValueTimesMetricAndUSCustomaryUndefinedAPerUndefinedBValue")
infix operator fun <
    LeftNumeratorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit,
    LeftNumeratorRightAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorRightAndRightDenominatorUnit,
    LeftNumeratorUnit,
    LeftDenominatorLeftAndRightNumeratorQuantity : UndefinedQuantityType,
    LeftDenominatorLeftAndRightNumeratorUnit,
    LeftDenominatorRightQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorRightQuantity>>, LeftUnit>.times(
    right: UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftDenominatorLeftAndRightNumeratorQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, RightUnit>,
) where
        LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorQuantity>,
        LeftNumeratorRightAndRightDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightAndRightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftQuantity, LeftNumeratorLeftUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorLeftAndRightNumeratorUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorQuantity>,
        LeftDenominatorLeftAndRightNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorLeftAndRightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorLeftAndRightNumeratorUnit, LeftDenominatorRightQuantity, LeftDenominatorRightUnit>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, LeftNumeratorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorRightQuantity>, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorLeftAndRightNumeratorUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    right times this
