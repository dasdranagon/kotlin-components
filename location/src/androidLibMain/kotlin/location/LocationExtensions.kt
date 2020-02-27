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

import android.os.Build
import android.os.Looper
import com.google.android.gms.location.*
import com.google.android.gms.tasks.Task
import com.splendo.kaluga.log.debug
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

fun android.location.Location.toKnownLocation(): Location.KnownLocation {
    return Location.KnownLocation(
            latitude = latitude,
            longitude = longitude,
            altitude = altitude,
            horizontalAccuracy = accuracy.toDouble(),
            verticalAccuracy = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) verticalAccuracyMeters.toDouble() else 0.0,
            speed = speed.toDouble(),
            time = Location.Time.MeasuredTime(time)
        )
}

fun LocationResult.toKnownLocations(): List<Location.KnownLocation> {
    return locations.mapNotNull {
        it.toKnownLocation()
    }
}
