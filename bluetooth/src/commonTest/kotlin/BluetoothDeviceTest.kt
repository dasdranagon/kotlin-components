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

package com.splendo.kaluga.bluetooth

import com.splendo.kaluga.bluetooth.device.Device
import com.splendo.kaluga.test.mock.bluetooth.device.MockDeviceConnectionManager
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlin.test.Test
import kotlin.test.assertEquals

class BluetoothDeviceTest:BluetoothFlowTest<Device?>() {

    override val flow: suspend () -> Flow<Device?> = {
        setup(Setup.DEVICE)
        bluetooth.devices()[device.identifier]
    }

    @Test
    fun testGetDevice() = testWithFlow {

        launch {
            scanDevice(device, deviceWrapper)
        }

        bluetooth.startScanning()
        val foundDevice = CompletableDeferred<Device>()
        awaitDevice(this, foundDevice)
        assertEquals(device, foundDevice.await())
        action { bluetooth.stopScanning() }
        test {
            assertEquals(device, it)
        }

        permissionManager.hasStoppedMonitoring.await()
        mockBaseScanner().stopMonitoringPermissions.await()
        mockBaseScanner().stopMonitoringBluetoothCompleted.await()
    }

    @Test
    fun testConnectDevice() = testWithFlow {
        launch {
            scanDevice(device, deviceWrapper)
        }
        bluetooth.startScanning()

        val deviceConnectionManager = device.peekState().connectionManager as MockDeviceConnectionManager

        // device.deviceConnectionManager as MockDeviceConnectionManager
        connectDevice(device, deviceConnectionManager, this)
        disconnectDevice(device, connectionManager, this)

        resetFlow()
        //permissionManager.hasStoppedMonitoring.await()
        mockBaseScanner().stopMonitoringPermissions.await()
        mockBaseScanner().stopMonitoringBluetoothCompleted.await()
    }
}