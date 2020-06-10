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

package com.splendo.kaluga.permissions

import com.splendo.kaluga.permissions.bluetooth.BluetoothPermissionManagerBuilder
import com.splendo.kaluga.permissions.bluetooth.BluetoothPermissionStateRepo
import com.splendo.kaluga.permissions.calendar.CalendarPermissionManagerBuilder
import com.splendo.kaluga.permissions.calendar.CalendarPermissionStateRepo
import com.splendo.kaluga.permissions.camera.CameraPermissionManagerBuilder
import com.splendo.kaluga.permissions.camera.CameraPermissionStateRepo
import com.splendo.kaluga.permissions.contacts.ContactsPermissionManagerBuilder
import com.splendo.kaluga.permissions.contacts.ContactsPermissionStateRepo
import com.splendo.kaluga.permissions.location.LocationPermissionManagerBuilder
import com.splendo.kaluga.permissions.location.LocationPermissionStateRepo
import com.splendo.kaluga.permissions.microphone.MicrophonePermissionManagerBuilder
import com.splendo.kaluga.permissions.microphone.MicrophonePermissionStateRepo
import com.splendo.kaluga.permissions.notifications.NotificationOptions
import com.splendo.kaluga.permissions.notifications.NotificationsPermissionManagerBuilder
import com.splendo.kaluga.permissions.notifications.NotificationsPermissionStateRepo
import com.splendo.kaluga.permissions.storage.StoragePermissionManagerBuilder
import com.splendo.kaluga.permissions.storage.StoragePermissionStateRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.transformLatest

/**
 * Permissions that can be requested by Kaluga
 */
sealed class Permission {
    /**
     * Permission to access the Bluetooth scanner
     */
    object Bluetooth : Permission()

    /**
     * Permission to access the users Calendar
     * @param allowWrite If `true` writing to the calendar is permitted
     */
    data class Calendar(val allowWrite: Boolean = false) : Permission()

    /**
     * Permission to access the users Camera
     */
    object Camera : Permission()
    /**
     * Permission to access the users Contacts
     * @param allowWrite If `true` writing to the contacts is permitted
     */
    data class Contacts(val allowWrite: Boolean = false) : Permission()

    /**
     * Permission to access the users Location
     * @param background If `true` scanning for location in the background is permitted
     * @param precise If `true` precise location scanning is permitted
     */
    data class Location(val background: Boolean = false, val precise: Boolean = false) : Permission()

    /**
     * Permission to access the users Microphone
     */
    object Microphone : Permission()

    /**
     * Permission to access the users Notifications.
     * @param options The [NotificationOptions] determining the type of notifications that can be accessed
     */
    data class Notifications(val options: NotificationOptions? = null) : Permission()

    /**
     * Permission to access the users device storage.
     * On iOS this corresponds to the Photos permission
     * @param allowWrite If `true` writing to the storage is permitted
     */
    data class Storage(val allowWrite: Boolean = false) : Permission()
}

/**
 * Builder for providing the proper [PermissionManager] for each [Permission]
 */
expect class PermissionsBuilder {
    val bluetoothPMBuilder: BluetoothPermissionManagerBuilder
    val calendarPMBuilder: CalendarPermissionManagerBuilder
    val cameraPMBuilder: CameraPermissionManagerBuilder
    val contactsPMBuilder: ContactsPermissionManagerBuilder
    val locationPMBuilder: LocationPermissionManagerBuilder
    val microphonePMBuilder: MicrophonePermissionManagerBuilder
    val notificationsPMBuilder: NotificationsPermissionManagerBuilder
    val storagePMBuilder: StoragePermissionManagerBuilder
}

/**
 * Manager to request the [PermissionStateRepo] of a given [Permission]
 * @param builder The [PermissionsBuilder] to build the [PermissionManager] associated with each [Permission]
 */
class Permissions(private val builder: PermissionsBuilder) {

    private val permissionStateRepos: MutableMap<Permission, PermissionStateRepo<*>> = mutableMapOf()

    /**
     * Gets a [Flow] of [PermissionState] for a given [Permission]
     * @param permission The [Permission] for which the [PermissionState] flow should be provided
     * @return A [Flow] of [PermissionState] for the given [Permission]
     */
    operator fun get(permission: Permission): Flow<PermissionState<*>> {
        val permissionStateRepo = permissionStateRepos[permission] ?: createPermissionStateRepo(permission).also { permissionStateRepos[permission] = it }
        return permissionStateRepo.flow()
    }

    private fun createPermissionStateRepo(permission: Permission): PermissionStateRepo<*> {
        return when (permission) {
            is Permission.Bluetooth -> BluetoothPermissionStateRepo(builder.bluetoothPMBuilder)
            is Permission.Calendar -> CalendarPermissionStateRepo(permission, builder.calendarPMBuilder)
            is Permission.Camera -> CameraPermissionStateRepo(builder.cameraPMBuilder)
            is Permission.Contacts -> ContactsPermissionStateRepo(permission, builder.contactsPMBuilder)
            is Permission.Location -> LocationPermissionStateRepo(permission, builder.locationPMBuilder)
            is Permission.Microphone -> MicrophonePermissionStateRepo(builder.microphonePMBuilder)
            is Permission.Notifications -> NotificationsPermissionStateRepo(permission, builder.notificationsPMBuilder)
            is Permission.Storage -> StoragePermissionStateRepo(permission, builder.storagePMBuilder)
        }
    }
}

/**
 * Requests a [Permission] on a [Flow] of [PermissionState]
 * @return `true` if the permission was granted, `false` otherwise.
 */
suspend fun Flow<PermissionState<*>>.request(): Boolean {
    return this.transformLatest { state ->
        when (state) {
            is PermissionState.Allowed -> emit(true)
            is PermissionState.Denied.Requestable -> state.request()
            is PermissionState.Denied.Locked -> emit(false)
        }
    }.first()
}
