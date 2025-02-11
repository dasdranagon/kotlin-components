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

@JvmName("metricAndImperialUndefinedCPerUndefinedAXUndefinedDValueTimesMetricAndImperialUndefinedAXUndefinedBPerUndefinedCValue")
infix operator fun <
    LeftNumeratorAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorAndRightDenominatorUnit,
    LeftDenominatorLeftAndRightNumeratorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorLeftAndRightNumeratorLeftUnit,
    LeftDenominatorRightQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorRightQuantity : UndefinedQuantityType,
    RightNumeratorRightUnit,
    RightNumeratorUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorAndRightDenominatorQuantity, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorLeftQuantity, LeftDenominatorRightQuantity>>, LeftUnit>.times(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorLeftQuantity, RightNumeratorRightQuantity>, LeftNumeratorAndRightDenominatorQuantity>, RightUnit>,
) where
        LeftNumeratorAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
        LeftNumeratorAndRightDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorAndRightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorAndRightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorLeftAndRightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorLeftQuantity>,
        LeftDenominatorLeftAndRightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorLeftAndRightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorLeftAndRightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftAndRightNumeratorLeftQuantity, LeftDenominatorLeftAndRightNumeratorLeftUnit, LeftDenominatorRightQuantity, LeftDenominatorRightUnit>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorLeftQuantity, LeftDenominatorRightQuantity>, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorRightUnit : UndefinedScientificUnit<RightNumeratorRightQuantity>,
        RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftAndRightNumeratorLeftQuantity, LeftDenominatorLeftAndRightNumeratorLeftUnit, RightNumeratorRightQuantity, RightNumeratorRightUnit>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorLeftQuantity, RightNumeratorRightQuantity>, RightNumeratorUnit, LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    right times this

@JvmName("metricUndefinedCPerUndefinedAXUndefinedDValueTimesMetricUndefinedAXUndefinedBPerUndefinedCValue")
infix operator fun <
    LeftNumeratorAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorAndRightDenominatorUnit,
    LeftDenominatorLeftAndRightNumeratorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorLeftAndRightNumeratorLeftUnit,
    LeftDenominatorRightQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorRightQuantity : UndefinedQuantityType,
    RightNumeratorRightUnit,
    RightNumeratorUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorAndRightDenominatorQuantity, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorLeftQuantity, LeftDenominatorRightQuantity>>, LeftUnit>.times(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorLeftQuantity, RightNumeratorRightQuantity>, LeftNumeratorAndRightDenominatorQuantity>, RightUnit>,
) where
        LeftNumeratorAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
        LeftNumeratorAndRightDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorLeftAndRightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorLeftQuantity>,
        LeftDenominatorLeftAndRightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftAndRightNumeratorLeftQuantity, LeftDenominatorLeftAndRightNumeratorLeftUnit, LeftDenominatorRightQuantity, LeftDenominatorRightUnit>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : UndefinedDividedUnit<LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorLeftQuantity, LeftDenominatorRightQuantity>, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorRightUnit : UndefinedScientificUnit<RightNumeratorRightQuantity>,
        RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftAndRightNumeratorLeftQuantity, LeftDenominatorLeftAndRightNumeratorLeftUnit, RightNumeratorRightQuantity, RightNumeratorRightUnit>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorLeftQuantity, RightNumeratorRightQuantity>, RightNumeratorUnit, LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInMetric =
    right times this

@JvmName("imperialUndefinedCPerUndefinedAXUndefinedDValueTimesImperialUndefinedAXUndefinedBPerUndefinedCValue")
infix operator fun <
    LeftNumeratorAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorAndRightDenominatorUnit,
    LeftDenominatorLeftAndRightNumeratorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorLeftAndRightNumeratorLeftUnit,
    LeftDenominatorRightQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorRightQuantity : UndefinedQuantityType,
    RightNumeratorRightUnit,
    RightNumeratorUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorAndRightDenominatorQuantity, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorLeftQuantity, LeftDenominatorRightQuantity>>, LeftUnit>.times(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorLeftQuantity, RightNumeratorRightQuantity>, LeftNumeratorAndRightDenominatorQuantity>, RightUnit>,
) where
        LeftNumeratorAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
        LeftNumeratorAndRightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorAndRightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorLeftAndRightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorLeftQuantity>,
        LeftDenominatorLeftAndRightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorLeftAndRightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftAndRightNumeratorLeftQuantity, LeftDenominatorLeftAndRightNumeratorLeftUnit, LeftDenominatorRightQuantity, LeftDenominatorRightUnit>,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorLeftQuantity, LeftDenominatorRightQuantity>, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorRightUnit : UndefinedScientificUnit<RightNumeratorRightQuantity>,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftAndRightNumeratorLeftQuantity, LeftDenominatorLeftAndRightNumeratorLeftUnit, RightNumeratorRightQuantity, RightNumeratorRightUnit>,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorLeftQuantity, RightNumeratorRightQuantity>, RightNumeratorUnit, LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    right times this

@JvmName("ukImperialUndefinedCPerUndefinedAXUndefinedDValueTimesUKImperialUndefinedAXUndefinedBPerUndefinedCValue")
infix operator fun <
    LeftNumeratorAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorAndRightDenominatorUnit,
    LeftDenominatorLeftAndRightNumeratorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorLeftAndRightNumeratorLeftUnit,
    LeftDenominatorRightQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorRightQuantity : UndefinedQuantityType,
    RightNumeratorRightUnit,
    RightNumeratorUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorAndRightDenominatorQuantity, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorLeftQuantity, LeftDenominatorRightQuantity>>, LeftUnit>.times(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorLeftQuantity, RightNumeratorRightQuantity>, LeftNumeratorAndRightDenominatorQuantity>, RightUnit>,
) where
        LeftNumeratorAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
        LeftNumeratorAndRightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorLeftAndRightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorLeftQuantity>,
        LeftDenominatorLeftAndRightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftAndRightNumeratorLeftQuantity, LeftDenominatorLeftAndRightNumeratorLeftUnit, LeftDenominatorRightQuantity, LeftDenominatorRightUnit>,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorLeftQuantity, LeftDenominatorRightQuantity>, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorRightUnit : UndefinedScientificUnit<RightNumeratorRightQuantity>,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftAndRightNumeratorLeftQuantity, LeftDenominatorLeftAndRightNumeratorLeftUnit, RightNumeratorRightQuantity, RightNumeratorRightUnit>,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorLeftQuantity, RightNumeratorRightQuantity>, RightNumeratorUnit, LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    right times this

@JvmName("usCustomaryUndefinedCPerUndefinedAXUndefinedDValueTimesUSCustomaryUndefinedAXUndefinedBPerUndefinedCValue")
infix operator fun <
    LeftNumeratorAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorAndRightDenominatorUnit,
    LeftDenominatorLeftAndRightNumeratorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorLeftAndRightNumeratorLeftUnit,
    LeftDenominatorRightQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorRightQuantity : UndefinedQuantityType,
    RightNumeratorRightUnit,
    RightNumeratorUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorAndRightDenominatorQuantity, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorLeftQuantity, LeftDenominatorRightQuantity>>, LeftUnit>.times(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorLeftQuantity, RightNumeratorRightQuantity>, LeftNumeratorAndRightDenominatorQuantity>, RightUnit>,
) where
        LeftNumeratorAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
        LeftNumeratorAndRightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorLeftAndRightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorLeftQuantity>,
        LeftDenominatorLeftAndRightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftAndRightNumeratorLeftQuantity, LeftDenominatorLeftAndRightNumeratorLeftUnit, LeftDenominatorRightQuantity, LeftDenominatorRightUnit>,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorLeftQuantity, LeftDenominatorRightQuantity>, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorRightUnit : UndefinedScientificUnit<RightNumeratorRightQuantity>,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftAndRightNumeratorLeftQuantity, LeftDenominatorLeftAndRightNumeratorLeftUnit, RightNumeratorRightQuantity, RightNumeratorRightUnit>,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorLeftQuantity, RightNumeratorRightQuantity>, RightNumeratorUnit, LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    right times this

@JvmName("metricAndUKImperialUndefinedCPerUndefinedAXUndefinedDValueTimesMetricAndUKImperialUndefinedAXUndefinedBPerUndefinedCValue")
infix operator fun <
    LeftNumeratorAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorAndRightDenominatorUnit,
    LeftDenominatorLeftAndRightNumeratorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorLeftAndRightNumeratorLeftUnit,
    LeftDenominatorRightQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorRightQuantity : UndefinedQuantityType,
    RightNumeratorRightUnit,
    RightNumeratorUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorAndRightDenominatorQuantity, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorLeftQuantity, LeftDenominatorRightQuantity>>, LeftUnit>.times(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorLeftQuantity, RightNumeratorRightQuantity>, LeftNumeratorAndRightDenominatorQuantity>, RightUnit>,
) where
        LeftNumeratorAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
        LeftNumeratorAndRightDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorAndRightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorLeftAndRightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorLeftQuantity>,
        LeftDenominatorLeftAndRightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorLeftAndRightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftAndRightNumeratorLeftQuantity, LeftDenominatorLeftAndRightNumeratorLeftUnit, LeftDenominatorRightQuantity, LeftDenominatorRightUnit>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorLeftQuantity, LeftDenominatorRightQuantity>, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorRightUnit : UndefinedScientificUnit<RightNumeratorRightQuantity>,
        RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftAndRightNumeratorLeftQuantity, LeftDenominatorLeftAndRightNumeratorLeftUnit, RightNumeratorRightQuantity, RightNumeratorRightUnit>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorLeftQuantity, RightNumeratorRightQuantity>, RightNumeratorUnit, LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    right times this

@JvmName("metricAndUSCustomaryUndefinedCPerUndefinedAXUndefinedDValueTimesMetricAndUSCustomaryUndefinedAXUndefinedBPerUndefinedCValue")
infix operator fun <
    LeftNumeratorAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorAndRightDenominatorUnit,
    LeftDenominatorLeftAndRightNumeratorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorLeftAndRightNumeratorLeftUnit,
    LeftDenominatorRightQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorRightQuantity : UndefinedQuantityType,
    RightNumeratorRightUnit,
    RightNumeratorUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorAndRightDenominatorQuantity, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorLeftQuantity, LeftDenominatorRightQuantity>>, LeftUnit>.times(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorLeftQuantity, RightNumeratorRightQuantity>, LeftNumeratorAndRightDenominatorQuantity>, RightUnit>,
) where
        LeftNumeratorAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
        LeftNumeratorAndRightDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorAndRightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorLeftAndRightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorLeftQuantity>,
        LeftDenominatorLeftAndRightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorLeftAndRightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftAndRightNumeratorLeftQuantity, LeftDenominatorLeftAndRightNumeratorLeftUnit, LeftDenominatorRightQuantity, LeftDenominatorRightUnit>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorLeftQuantity, LeftDenominatorRightQuantity>, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorRightUnit : UndefinedScientificUnit<RightNumeratorRightQuantity>,
        RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftAndRightNumeratorLeftQuantity, LeftDenominatorLeftAndRightNumeratorLeftUnit, RightNumeratorRightQuantity, RightNumeratorRightUnit>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorLeftQuantity, RightNumeratorRightQuantity>, RightNumeratorUnit, LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    right times this
