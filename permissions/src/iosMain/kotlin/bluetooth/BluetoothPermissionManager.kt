package com.splendo.kaluga.permissions.bluetooth

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

import com.splendo.kaluga.base.IOSVersion
import com.splendo.kaluga.log.error
import com.splendo.kaluga.permissions.*
import platform.CoreBluetooth.*
import platform.Foundation.NSBundle
import platform.darwin.NSObject
import platform.darwin.dispatch_get_main_queue

actual class BluetoothPermissionManager(
    private val bundle: NSBundle,
    stateRepo: BluetoothPermissionStateRepo
) : PermissionManager<Permission.Bluetooth>(stateRepo) {

    private val centralManager = lazy {
        val options = mapOf<Any?, Any>(CBCentralManagerOptionShowPowerAlertKey to false)
        CBCentralManager(null, dispatch_get_main_queue(), options)
    }

    private val delegate = object : NSObject(), CBCentralManagerDelegateProtocol {

        override fun centralManagerDidUpdateState(central: CBCentralManager) {
            IOSPermissionsHelper.handleAuthorizationStatus(checkAuthorization(), this@BluetoothPermissionManager)
        }
    }

    override suspend fun requestPermission() {
        if (IOSPermissionsHelper.missingDeclarationsInPList(bundle, "NSBluetoothAlwaysUsageDescription", "NSBluetoothPeripheralUsageDescription").isEmpty()) {
            if (!centralManager.isInitialized()) {
                centralManager.value
            }
        } else {
            revokePermission(true)
        }
    }

    override suspend fun initializeState(): PermissionState<Permission.Bluetooth> {
        return IOSPermissionsHelper.getPermissionState(checkAuthorization(), this)
    }

    override suspend fun startMonitoring(interval: Long) {
        centralManager.value.delegate = delegate
    }

    override suspend fun stopMonitoring() {
        centralManager.value.delegate = null
    }

    private fun checkAuthorization(): IOSPermissionsHelper.AuthorizationStatus {
        val version = IOSVersion.systemVersion
        return when {
            version.isOSVersionOrNewer(IOSVersion(13,0,0)) -> CBCentralManager().authorization.toAuthorizationStatus()
            else -> CBPeripheralManager.authorizationStatus().toPeripheralAuthorizationStatus()
        }
    }

}

actual class BluetoothPermissionManagerBuilder(
    private val bundle: NSBundle = NSBundle.mainBundle) : BaseBluetoothPermissionManagerBuilder {

    override fun create(repo: BluetoothPermissionStateRepo): BluetoothPermissionManager {
        return BluetoothPermissionManager(bundle, repo)
    }

}

private fun CBPeripheralManagerAuthorizationStatus.toPeripheralAuthorizationStatus(): IOSPermissionsHelper.AuthorizationStatus {
    return when(this) {
        CBPeripheralManagerAuthorizationStatusAuthorized -> IOSPermissionsHelper.AuthorizationStatus.Authorized
        CBPeripheralManagerAuthorizationStatusDenied -> IOSPermissionsHelper.AuthorizationStatus.Denied
        CBPeripheralManagerAuthorizationStatusRestricted -> IOSPermissionsHelper.AuthorizationStatus.Restricted
        CBPeripheralManagerAuthorizationStatusNotDetermined -> IOSPermissionsHelper.AuthorizationStatus.NotDetermined
        else -> {
            error(
                "BluetoothPermissionManager",
                "Unknown CBPeripheralManagerAuthorizationStatus status={$this}"
            )
            IOSPermissionsHelper.AuthorizationStatus.NotDetermined
        }
    }
}

private fun CBManagerAuthorization.toAuthorizationStatus(): IOSPermissionsHelper.AuthorizationStatus {
    return when(this) {
        CBManagerAuthorizationAllowedAlways -> IOSPermissionsHelper.AuthorizationStatus.Authorized
        CBManagerAuthorizationDenied -> IOSPermissionsHelper.AuthorizationStatus.Denied
        CBManagerAuthorizationRestricted -> IOSPermissionsHelper.AuthorizationStatus.Restricted
        CBManagerAuthorizationNotDetermined -> IOSPermissionsHelper.AuthorizationStatus.NotDetermined
        else -> {
            error(
                "BluetoothPermissionManager",
                "Unknown CBManagerAuthorization status={$this}"
            )
            IOSPermissionsHelper.AuthorizationStatus.NotDetermined
        }
    }
}