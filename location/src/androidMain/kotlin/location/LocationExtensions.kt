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

package com.splendo.kaluga.location

import android.os.Build
import com.google.android.gms.location.LocationResult
import com.splendo.kaluga.base.utils.DefaultKalugaDate
import kotlin.time.Duration.Companion.milliseconds

/**
 * Converts a [android.location.Location] into a [Location.KnownLocation]
 * @return the [Location.KnownLocation] matching the location
 */
fun android.location.Location.toKnownLocation(): Location.KnownLocation = Location.KnownLocation(
    latitude = latitude,
    longitude = longitude,
    altitude = altitude,
    horizontalAccuracy = accuracy.toDouble(),
    verticalAccuracy = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) verticalAccuracyMeters.toDouble() else 0.0,
    speed = speed.toDouble(),
    course = bearing.toDouble(),
    time = DefaultKalugaDate.epoch(time.milliseconds),
)

/**
 * Converts a [LocationResult] to a list of [Location.KnownLocation]
 * @return the list of [Location.KnownLocation] in the [LocationResult]
 */
fun LocationResult.toKnownLocations(): List<Location.KnownLocation> = locations.mapNotNull {
    it.toKnownLocation()
}
