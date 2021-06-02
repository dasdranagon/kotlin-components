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

import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class BluetoothCharacteristicTest: BluetoothFlowTest<Characteristic?>() {

    override val flow: suspend () -> Flow<Characteristic?> = {
        setup(Setup.CHARACTERISTIC)
        bluetooth.devices()[device.identifier].services()[service.uuid].characteristics()[characteristic.uuid]

    }

    @Test
    fun testGetCharacteristic() = testWithFlow {
        launch {
            scanDevice(device, deviceWrapper)
        }
        bluetooth.startScanning()

        test {
            assertNull(it)
        }

        action {
            connectDevice(device, connectionManager, this)
            discoverService(service, device)
        }
        val foundCharacteristic = CompletableDeferred<Characteristic>()
        awaitCharacteristic(this@BluetoothCharacteristicTest, foundCharacteristic)
        assertEquals(characteristic, foundCharacteristic.await())

        permissionManager.hasStoppedMonitoring.await()
        mockBaseScanner().stopMonitoringPermissions.await()
        mockBaseScanner().stopMonitoringBluetoothCompleted.await()
    }
}