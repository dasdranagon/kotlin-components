/*
 Copyright (c) 2020. Splendo Consulting B.V. The Netherlands

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

import com.splendo.kaluga.base.MainQueueDispatcher
import com.splendo.kaluga.permissions.Permission
import com.splendo.kaluga.permissions.Permissions
import com.splendo.kaluga.permissions.PermissionsBuilder
import kotlin.coroutines.CoroutineContext

actual class LocationManager(
    locationPermission: Permission.Location,
    permissions: Permissions,
    autoRequestPermission: Boolean,
    autoEnableLocations: Boolean,
    locationStateRepo: LocationStateRepo
) : BaseLocationManager(locationPermission, permissions, autoRequestPermission, autoEnableLocations, locationStateRepo) {

    class Builder : BaseLocationManager.Builder {

        override fun create(
            locationPermission: Permission.Location,
            permissions: Permissions,
            autoRequestPermission: Boolean,
            autoEnableLocations: Boolean,
            locationStateRepo: LocationStateRepo
        ): BaseLocationManager {
            return LocationManager(locationPermission, permissions, autoRequestPermission, autoEnableLocations, locationStateRepo)
        }
    }

    override suspend fun startMonitoringLocationEnabled() {
        TODO("not implemented")
    }

    override suspend fun stopMonitoringLocationEnabled() {
        TODO("not implemented")
    }

    override suspend fun isLocationEnabled(): Boolean {
        TODO("not implemented")
    }

    override suspend fun requestLocationEnable() {
        TODO("not implemented")
    }

    override suspend fun startMonitoringLocation() {
        TODO("not implemented")
    }

    override suspend fun stopMonitoringLocation() {
        TODO("not implemented")
    }
}

actual class LocationStateRepoBuilder(private val permissions: Permissions = Permissions(PermissionsBuilder(), MainQueueDispatcher)) : LocationStateRepo.Builder {

    override fun create(locationPermission: Permission.Location, autoRequestPermission: Boolean, autoEnableLocations: Boolean, coroutineContext: CoroutineContext): LocationStateRepo {
        return LocationStateRepo(locationPermission, permissions, autoRequestPermission, autoEnableLocations, LocationManager.Builder(), coroutineContext)
    }
}
