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

@JvmName("metricAndImperialUndefinedCPerUndefinedDXUndefinedBValueTimesMetricAndImperialUndefinedAXUndefinedBPerUndefinedCValue")
infix operator fun <
    LeftNumeratorAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorAndRightDenominatorUnit,
    LeftDenominatorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorLeftUnit,
    LeftDenominatorRightAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftDenominatorRightAndRightNumeratorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorLeftQuantity : UndefinedQuantityType,
    RightNumeratorLeftUnit,
    RightNumeratorUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorAndRightDenominatorQuantity, UndefinedQuantityType.Multiplying<LeftDenominatorLeftQuantity, LeftDenominatorRightAndRightNumeratorRightQuantity>>, LeftUnit>.times(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<RightNumeratorLeftQuantity, LeftDenominatorRightAndRightNumeratorRightQuantity>, LeftNumeratorAndRightDenominatorQuantity>, RightUnit>,
) where
        LeftNumeratorAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
        LeftNumeratorAndRightDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorAndRightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorAndRightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftQuantity>,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorRightAndRightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorRightQuantity>,
        LeftDenominatorRightAndRightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorRightAndRightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorRightAndRightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftQuantity, LeftDenominatorLeftUnit, LeftDenominatorRightAndRightNumeratorRightQuantity, LeftDenominatorRightAndRightNumeratorRightUnit>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftQuantity, LeftDenominatorRightAndRightNumeratorRightQuantity>, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorLeftUnit : UndefinedScientificUnit<RightNumeratorLeftQuantity>,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedMultipliedUnit<RightNumeratorLeftQuantity, RightNumeratorLeftUnit, LeftDenominatorRightAndRightNumeratorRightQuantity, LeftDenominatorRightAndRightNumeratorRightUnit>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<RightNumeratorLeftQuantity, LeftDenominatorRightAndRightNumeratorRightQuantity>, RightNumeratorUnit, LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    right times this

@JvmName("metricUndefinedCPerUndefinedDXUndefinedBValueTimesMetricUndefinedAXUndefinedBPerUndefinedCValue")
infix operator fun <
    LeftNumeratorAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorAndRightDenominatorUnit,
    LeftDenominatorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorLeftUnit,
    LeftDenominatorRightAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftDenominatorRightAndRightNumeratorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorLeftQuantity : UndefinedQuantityType,
    RightNumeratorLeftUnit,
    RightNumeratorUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorAndRightDenominatorQuantity, UndefinedQuantityType.Multiplying<LeftDenominatorLeftQuantity, LeftDenominatorRightAndRightNumeratorRightQuantity>>, LeftUnit>.times(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<RightNumeratorLeftQuantity, LeftDenominatorRightAndRightNumeratorRightQuantity>, LeftNumeratorAndRightDenominatorQuantity>, RightUnit>,
) where
        LeftNumeratorAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
        LeftNumeratorAndRightDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftQuantity>,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorRightAndRightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorRightQuantity>,
        LeftDenominatorRightAndRightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftQuantity, LeftDenominatorLeftUnit, LeftDenominatorRightAndRightNumeratorRightQuantity, LeftDenominatorRightAndRightNumeratorRightUnit>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : UndefinedDividedUnit<LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftQuantity, LeftDenominatorRightAndRightNumeratorRightQuantity>, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorLeftUnit : UndefinedScientificUnit<RightNumeratorLeftQuantity>,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : UndefinedMultipliedUnit<RightNumeratorLeftQuantity, RightNumeratorLeftUnit, LeftDenominatorRightAndRightNumeratorRightQuantity, LeftDenominatorRightAndRightNumeratorRightUnit>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<RightNumeratorLeftQuantity, LeftDenominatorRightAndRightNumeratorRightQuantity>, RightNumeratorUnit, LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInMetric =
    right times this

@JvmName("imperialUndefinedCPerUndefinedDXUndefinedBValueTimesImperialUndefinedAXUndefinedBPerUndefinedCValue")
infix operator fun <
    LeftNumeratorAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorAndRightDenominatorUnit,
    LeftDenominatorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorLeftUnit,
    LeftDenominatorRightAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftDenominatorRightAndRightNumeratorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorLeftQuantity : UndefinedQuantityType,
    RightNumeratorLeftUnit,
    RightNumeratorUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorAndRightDenominatorQuantity, UndefinedQuantityType.Multiplying<LeftDenominatorLeftQuantity, LeftDenominatorRightAndRightNumeratorRightQuantity>>, LeftUnit>.times(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<RightNumeratorLeftQuantity, LeftDenominatorRightAndRightNumeratorRightQuantity>, LeftNumeratorAndRightDenominatorQuantity>, RightUnit>,
) where
        LeftNumeratorAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
        LeftNumeratorAndRightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorAndRightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftQuantity>,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorRightAndRightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorRightQuantity>,
        LeftDenominatorRightAndRightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorRightAndRightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftQuantity, LeftDenominatorLeftUnit, LeftDenominatorRightAndRightNumeratorRightQuantity, LeftDenominatorRightAndRightNumeratorRightUnit>,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftQuantity, LeftDenominatorRightAndRightNumeratorRightQuantity>, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorLeftUnit : UndefinedScientificUnit<RightNumeratorLeftQuantity>,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedMultipliedUnit<RightNumeratorLeftQuantity, RightNumeratorLeftUnit, LeftDenominatorRightAndRightNumeratorRightQuantity, LeftDenominatorRightAndRightNumeratorRightUnit>,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<RightNumeratorLeftQuantity, LeftDenominatorRightAndRightNumeratorRightQuantity>, RightNumeratorUnit, LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    right times this

@JvmName("ukImperialUndefinedCPerUndefinedDXUndefinedBValueTimesUKImperialUndefinedAXUndefinedBPerUndefinedCValue")
infix operator fun <
    LeftNumeratorAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorAndRightDenominatorUnit,
    LeftDenominatorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorLeftUnit,
    LeftDenominatorRightAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftDenominatorRightAndRightNumeratorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorLeftQuantity : UndefinedQuantityType,
    RightNumeratorLeftUnit,
    RightNumeratorUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorAndRightDenominatorQuantity, UndefinedQuantityType.Multiplying<LeftDenominatorLeftQuantity, LeftDenominatorRightAndRightNumeratorRightQuantity>>, LeftUnit>.times(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<RightNumeratorLeftQuantity, LeftDenominatorRightAndRightNumeratorRightQuantity>, LeftNumeratorAndRightDenominatorQuantity>, RightUnit>,
) where
        LeftNumeratorAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
        LeftNumeratorAndRightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftQuantity>,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorRightAndRightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorRightQuantity>,
        LeftDenominatorRightAndRightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftQuantity, LeftDenominatorLeftUnit, LeftDenominatorRightAndRightNumeratorRightQuantity, LeftDenominatorRightAndRightNumeratorRightUnit>,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftQuantity, LeftDenominatorRightAndRightNumeratorRightQuantity>, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorLeftUnit : UndefinedScientificUnit<RightNumeratorLeftQuantity>,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : UndefinedMultipliedUnit<RightNumeratorLeftQuantity, RightNumeratorLeftUnit, LeftDenominatorRightAndRightNumeratorRightQuantity, LeftDenominatorRightAndRightNumeratorRightUnit>,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<RightNumeratorLeftQuantity, LeftDenominatorRightAndRightNumeratorRightQuantity>, RightNumeratorUnit, LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    right times this

@JvmName("usCustomaryUndefinedCPerUndefinedDXUndefinedBValueTimesUSCustomaryUndefinedAXUndefinedBPerUndefinedCValue")
infix operator fun <
    LeftNumeratorAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorAndRightDenominatorUnit,
    LeftDenominatorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorLeftUnit,
    LeftDenominatorRightAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftDenominatorRightAndRightNumeratorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorLeftQuantity : UndefinedQuantityType,
    RightNumeratorLeftUnit,
    RightNumeratorUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorAndRightDenominatorQuantity, UndefinedQuantityType.Multiplying<LeftDenominatorLeftQuantity, LeftDenominatorRightAndRightNumeratorRightQuantity>>, LeftUnit>.times(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<RightNumeratorLeftQuantity, LeftDenominatorRightAndRightNumeratorRightQuantity>, LeftNumeratorAndRightDenominatorQuantity>, RightUnit>,
) where
        LeftNumeratorAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
        LeftNumeratorAndRightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftQuantity>,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorRightAndRightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorRightQuantity>,
        LeftDenominatorRightAndRightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftQuantity, LeftDenominatorLeftUnit, LeftDenominatorRightAndRightNumeratorRightQuantity, LeftDenominatorRightAndRightNumeratorRightUnit>,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftQuantity, LeftDenominatorRightAndRightNumeratorRightQuantity>, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorLeftUnit : UndefinedScientificUnit<RightNumeratorLeftQuantity>,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedMultipliedUnit<RightNumeratorLeftQuantity, RightNumeratorLeftUnit, LeftDenominatorRightAndRightNumeratorRightQuantity, LeftDenominatorRightAndRightNumeratorRightUnit>,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<RightNumeratorLeftQuantity, LeftDenominatorRightAndRightNumeratorRightQuantity>, RightNumeratorUnit, LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    right times this

@JvmName("metricAndUKImperialUndefinedCPerUndefinedDXUndefinedBValueTimesMetricAndUKImperialUndefinedAXUndefinedBPerUndefinedCValue")
infix operator fun <
    LeftNumeratorAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorAndRightDenominatorUnit,
    LeftDenominatorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorLeftUnit,
    LeftDenominatorRightAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftDenominatorRightAndRightNumeratorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorLeftQuantity : UndefinedQuantityType,
    RightNumeratorLeftUnit,
    RightNumeratorUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorAndRightDenominatorQuantity, UndefinedQuantityType.Multiplying<LeftDenominatorLeftQuantity, LeftDenominatorRightAndRightNumeratorRightQuantity>>, LeftUnit>.times(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<RightNumeratorLeftQuantity, LeftDenominatorRightAndRightNumeratorRightQuantity>, LeftNumeratorAndRightDenominatorQuantity>, RightUnit>,
) where
        LeftNumeratorAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
        LeftNumeratorAndRightDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorAndRightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftQuantity>,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorRightAndRightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorRightQuantity>,
        LeftDenominatorRightAndRightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorRightAndRightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftQuantity, LeftDenominatorLeftUnit, LeftDenominatorRightAndRightNumeratorRightQuantity, LeftDenominatorRightAndRightNumeratorRightUnit>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftQuantity, LeftDenominatorRightAndRightNumeratorRightQuantity>, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorLeftUnit : UndefinedScientificUnit<RightNumeratorLeftQuantity>,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : UndefinedMultipliedUnit<RightNumeratorLeftQuantity, RightNumeratorLeftUnit, LeftDenominatorRightAndRightNumeratorRightQuantity, LeftDenominatorRightAndRightNumeratorRightUnit>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<RightNumeratorLeftQuantity, LeftDenominatorRightAndRightNumeratorRightQuantity>, RightNumeratorUnit, LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    right times this

@JvmName("metricAndUSCustomaryUndefinedCPerUndefinedDXUndefinedBValueTimesMetricAndUSCustomaryUndefinedAXUndefinedBPerUndefinedCValue")
infix operator fun <
    LeftNumeratorAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorAndRightDenominatorUnit,
    LeftDenominatorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorLeftUnit,
    LeftDenominatorRightAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftDenominatorRightAndRightNumeratorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorLeftQuantity : UndefinedQuantityType,
    RightNumeratorLeftUnit,
    RightNumeratorUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorAndRightDenominatorQuantity, UndefinedQuantityType.Multiplying<LeftDenominatorLeftQuantity, LeftDenominatorRightAndRightNumeratorRightQuantity>>, LeftUnit>.times(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<RightNumeratorLeftQuantity, LeftDenominatorRightAndRightNumeratorRightQuantity>, LeftNumeratorAndRightDenominatorQuantity>, RightUnit>,
) where
        LeftNumeratorAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
        LeftNumeratorAndRightDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorAndRightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftQuantity>,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorRightAndRightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorRightQuantity>,
        LeftDenominatorRightAndRightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorRightAndRightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftQuantity, LeftDenominatorLeftUnit, LeftDenominatorRightAndRightNumeratorRightQuantity, LeftDenominatorRightAndRightNumeratorRightUnit>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftQuantity, LeftDenominatorRightAndRightNumeratorRightQuantity>, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorLeftUnit : UndefinedScientificUnit<RightNumeratorLeftQuantity>,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedMultipliedUnit<RightNumeratorLeftQuantity, RightNumeratorLeftUnit, LeftDenominatorRightAndRightNumeratorRightQuantity, LeftDenominatorRightAndRightNumeratorRightUnit>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<RightNumeratorLeftQuantity, LeftDenominatorRightAndRightNumeratorRightQuantity>, RightNumeratorUnit, LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    right times this
