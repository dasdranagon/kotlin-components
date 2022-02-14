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

package com.splendo.kaluga.scientific.converter.decimal

import com.splendo.kaluga.base.utils.Decimal
import com.splendo.kaluga.base.utils.toDecimal
import com.splendo.kaluga.scientific.converter.dimensionless.div
import com.splendo.kaluga.scientific.converter.dimensionless.times
import com.splendo.kaluga.scientific.unit.Dimensionless.Companion.invoke
import com.splendo.kaluga.scientific.unit.DimensionlessScientificValue
import com.splendo.kaluga.scientific.unit.One

infix operator fun Decimal.div(
    modifier: DimensionlessScientificValue<*>
) = this.invoke(One).div(modifier).value.toDecimal()

infix operator fun Decimal.times(
    modifier: DimensionlessScientificValue<*>
) = this.invoke(One).times(modifier).value.toDecimal()