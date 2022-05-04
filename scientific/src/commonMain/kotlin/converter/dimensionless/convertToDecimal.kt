/*
 Copyright 2022 Splendo Consulting B.V. The Netherlands

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

package com.splendo.kaluga.scientific.converter.dimensionless

import com.splendo.kaluga.base.utils.Decimal
import com.splendo.kaluga.scientific.PhysicalQuantity
import com.splendo.kaluga.scientific.byDividing
import com.splendo.kaluga.scientific.byMultiplying
import com.splendo.kaluga.scientific.unit.DefaultDimensionlessScientificValue
import com.splendo.kaluga.scientific.unit.Dimensionless.Companion.invoke
import com.splendo.kaluga.scientific.unit.DimensionlessScientificValue
import com.splendo.kaluga.scientific.unit.One
import com.splendo.kaluga.scientific.unit.ScientificUnit

infix operator fun <
    Unit : ScientificUnit<PhysicalQuantity.Dimensionless>
    > DimensionlessScientificValue<Unit>.times(
    decimal: Decimal
) = convertToOneByMultiplying(decimal, ::DefaultDimensionlessScientificValue)

fun <
    Unit : ScientificUnit<PhysicalQuantity.Dimensionless>,
    Value : DimensionlessScientificValue<One>
    > DimensionlessScientificValue<Unit>.convertToOneByMultiplying(
    decimal: Decimal,
    factory: (Decimal, One) -> Value
) = decimal.invoke(One).let { it.unit.byMultiplying(this, it, factory) }

infix operator fun <
    Unit : ScientificUnit<PhysicalQuantity.Dimensionless>
    > DimensionlessScientificValue<Unit>.div(
    decimal: Decimal
) = convertToOneByDividing(decimal, ::DefaultDimensionlessScientificValue)

fun <
    Unit : ScientificUnit<PhysicalQuantity.Dimensionless>,
    Value : DimensionlessScientificValue<One>
    > DimensionlessScientificValue<Unit>.convertToOneByDividing(
    decimal: Decimal,
    factory: (Decimal, One) -> Value
) = decimal.invoke(One).let { it.unit.byDividing(this, it, factory) }
