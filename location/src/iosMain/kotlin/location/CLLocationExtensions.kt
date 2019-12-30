package com.splendo.kaluga.location

/*

Copyright 2019 Splendo Consulting B.V. The Netherlands

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

import kotlinx.cinterop.useContents
import platform.CoreLocation.CLLocation
import platform.Foundation.timeIntervalSince1970

val CLLocation.knownLocation
    get() = coordinate.useContents {
        Location.KnownLocation(
            latitude = latitude,
            longitude = longitude,
            altitude = altitude,
            horizontalAccuracy = horizontalAccuracy,
            verticalAccuracy = verticalAccuracy,
            course = course,
            speed = speed,
            time = Location.Time.MeasuredTime(timestamp.timeIntervalSince1970.toLong() * 1_000L)
        )
    }
