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

import android.content.Context
import com.splendo.kaluga.permissions.bluetooth.BaseBluetoothPermissionManagerBuilder
import com.splendo.kaluga.permissions.bluetooth.BluetoothPermissionManagerBuilder
import com.splendo.kaluga.permissions.calendar.BaseCalendarPermissionManagerBuilder
import com.splendo.kaluga.permissions.calendar.CalendarPermissionManagerBuilder
import com.splendo.kaluga.permissions.camera.BaseCameraPermissionManagerBuilder
import com.splendo.kaluga.permissions.camera.CameraPermissionManagerBuilder
import com.splendo.kaluga.permissions.contacts.BaseContactsPermissionManagerBuilder
import com.splendo.kaluga.permissions.contacts.ContactsPermissionManagerBuilder
import com.splendo.kaluga.permissions.location.BaseLocationPermissionManagerBuilder
import com.splendo.kaluga.permissions.location.LocationPermissionManagerBuilder
import com.splendo.kaluga.permissions.microphone.BaseMicrophonePermissionManagerBuilder
import com.splendo.kaluga.permissions.microphone.MicrophonePermissionManagerBuilder
import com.splendo.kaluga.permissions.notifications.BaseNotificationsPermissionManagerBuilder
import com.splendo.kaluga.permissions.notifications.NotificationsPermissionManagerBuilder
import com.splendo.kaluga.permissions.storage.BaseStoragePermissionManagerBuilder
import com.splendo.kaluga.permissions.storage.StoragePermissionManagerBuilder

actual data class PermissionsBuilder(
    override val bluetoothPMBuilder: BaseBluetoothPermissionManagerBuilder = BluetoothPermissionManagerBuilder(),
    override val calendarPMBuilder: BaseCalendarPermissionManagerBuilder = CalendarPermissionManagerBuilder(),
    override val cameraPMBuilder: BaseCameraPermissionManagerBuilder = CameraPermissionManagerBuilder(),
    override val contactsPMBuilder: BaseContactsPermissionManagerBuilder = ContactsPermissionManagerBuilder(),
    override val locationPMBuilder: BaseLocationPermissionManagerBuilder = LocationPermissionManagerBuilder(),
    override val microphonePMBuilder: BaseMicrophonePermissionManagerBuilder = MicrophonePermissionManagerBuilder(),
    override val notificationsPMBuilder: BaseNotificationsPermissionManagerBuilder = NotificationsPermissionManagerBuilder(),
    override val storagePMBuilder: BaseStoragePermissionManagerBuilder = StoragePermissionManagerBuilder()
) : BasePermissionsBuilder {
    constructor(context: Context) : this(
        BluetoothPermissionManagerBuilder(context),
        CalendarPermissionManagerBuilder(context),
        CameraPermissionManagerBuilder(context),
        ContactsPermissionManagerBuilder(context),
        LocationPermissionManagerBuilder(context),
        MicrophonePermissionManagerBuilder(context),
        NotificationsPermissionManagerBuilder(),
        StoragePermissionManagerBuilder(context)
    )
}
