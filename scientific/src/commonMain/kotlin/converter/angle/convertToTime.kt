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

package com.splendo.kaluga.scientific.converter.angle

import com.splendo.kaluga.scientific.PhysicalQuantity
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.converter.time.time
import com.splendo.kaluga.scientific.unit.Angle
import com.splendo.kaluga.scientific.unit.AngularVelocity
import kotlin.jvm.JvmName

@JvmName("angleDivAngularVelocity")
infix operator fun <AngleUnit : Angle> ScientificValue<PhysicalQuantity.Angle, AngleUnit>.div(
    angularVelocity: ScientificValue<PhysicalQuantity.AngularVelocity, AngularVelocity>
) = angularVelocity.unit.per.time(this, angularVelocity)
