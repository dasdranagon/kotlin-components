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

package com.splendo.kaluga.permissions.bluetooth

import android.Manifest
import android.bluetooth.BluetoothAdapter
import android.content.Context
import com.splendo.kaluga.base.ApplicationHolder
import com.splendo.kaluga.permissions.AndroidPermissionsManager
import com.splendo.kaluga.permissions.Permission
import com.splendo.kaluga.permissions.PermissionManager
import com.splendo.kaluga.permissions.PermissionState

actual class BluetoothPermissionManager(
    context: Context,
    bluetoothAdapter: BluetoothAdapter?,
    stateRepo: BluetoothPermissionStateRepo
) : PermissionManager<Permission.Bluetooth>(stateRepo) {

    private val permissionsManager = AndroidPermissionsManager(context, this, arrayOf(Manifest.permission.BLUETOOTH, Manifest.permission.BLUETOOTH_ADMIN))
    private val supported: Boolean = bluetoothAdapter != null

    override suspend fun requestPermission() {
        if (supported)
            permissionsManager.requestPermissions()
    }

    override suspend fun initializeState(): PermissionState<Permission.Bluetooth> {
        return when {
            !supported -> PermissionState.Denied.Locked(this)
            permissionsManager.hasPermissions -> PermissionState.Allowed(this)
            else -> PermissionState.Denied.Requestable(this)
        }
    }

    override suspend fun startMonitoring(interval: Long) {
        if (supported)
            permissionsManager.startMonitoring(interval)
    }

    override suspend fun stopMonitoring() {
        if (supported)
            permissionsManager.stopMonitoring()
    }
}

actual class BluetoothPermissionManagerBuilder(
    private val context: Context = ApplicationHolder.applicationContext,
    private val bluetoothAdapter: BluetoothAdapter? = BluetoothAdapter.getDefaultAdapter()
) {

    actual fun create(repo: BluetoothPermissionStateRepo): BluetoothPermissionManager {
        return BluetoothPermissionManager(context, bluetoothAdapter, repo)
    }
}
