/*
 Copyright 2021 Splendo Consulting B.V. The Netherlands

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

package com.splendo.kaluga.scientific.converter.time

import com.splendo.kaluga.scientific.PhysicalQuantity
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.converter.area.area
import com.splendo.kaluga.scientific.converter.dynamicViscosity.dynamicViscosity
import com.splendo.kaluga.scientific.converter.force.div
import com.splendo.kaluga.scientific.converter.kinematicViscosity.kinematicViscosity
import com.splendo.kaluga.scientific.converter.momentum.div
import com.splendo.kaluga.scientific.invoke
import com.splendo.kaluga.scientific.times
import com.splendo.kaluga.scientific.unit.Area
import com.splendo.kaluga.scientific.unit.ImperialArea
import com.splendo.kaluga.scientific.unit.KinematicViscosity
import com.splendo.kaluga.scientific.unit.MetricArea
import com.splendo.kaluga.scientific.unit.MetricKinematicViscosity
import com.splendo.kaluga.scientific.unit.Second
import com.splendo.kaluga.scientific.unit.SquareCentimeter
import com.splendo.kaluga.scientific.unit.Time
import com.splendo.kaluga.scientific.unit.per
import com.splendo.kaluga.scientific.unit.x
import kotlin.jvm.JvmName

@JvmName("timeTimesMetricArea")
infix operator fun <TimeUnit : Time> ScientificValue<PhysicalQuantity.Time, TimeUnit>.times(
    kinematicViscosity: ScientificValue<PhysicalQuantity.KinematicViscosity, MetricKinematicViscosity>
) = kinematicViscosity.unit.area.area(kinematicViscosity, this)