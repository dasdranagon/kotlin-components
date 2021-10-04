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

package com.splendo.kaluga.bluetooth.beacons

import com.splendo.kaluga.base.utils.bytesOf
import com.splendo.kaluga.base.utils.decodeHex
import com.splendo.kaluga.bluetooth.device.BaseDeviceConnectionManager
import com.splendo.kaluga.bluetooth.device.ConnectionSettings
import com.splendo.kaluga.bluetooth.device.Device
import com.splendo.kaluga.bluetooth.device.DeviceStateFlowRepo
import com.splendo.kaluga.bluetooth.device.DeviceWrapper
import com.splendo.kaluga.test.mock.bluetooth.createDevice
import com.splendo.kaluga.test.mock.bluetooth.device.MockDeviceConnectionManager
import kotlin.coroutines.CoroutineContext

object BeaconMock {

    private fun BeaconID.asByteArray() = bytesOf(0x00, 0xdc) +
        namespace.decodeHex()!! +
        instance.decodeHex()!!

    fun mockGenericDevice(name: String, coroutineContext: CoroutineContext) = createDevice(
        name,
        connectionSettings = settings,
        connectionManagerBuilder = manager,
        coroutineContext = coroutineContext
    )

    fun mockBeaconDevice(id: String, coroutineContext: CoroutineContext): Device {
        val beaconId = BeaconID(
            namespace = id.substring(0..19),
            instance = id.substring(20)
        )
        return createDevice(
            name = "Beacon:" + beaconId.namespace + beaconId.instance,
            serviceData = mapOf(
                Eddystone.SERVICE_UUID to beaconId.asByteArray()
            ),
            connectionSettings = settings,
            connectionManagerBuilder = manager,
            coroutineContext = coroutineContext
        )
    }

    private val settings = ConnectionSettings(
        ConnectionSettings.ReconnectionSettings.Limited(2)
    )

    private val manager = object : BaseDeviceConnectionManager.Builder {
        override fun create(
            connectionSettings: ConnectionSettings,
            deviceWrapper: DeviceWrapper,
            stateRepo: DeviceStateFlowRepo
        ) = MockDeviceConnectionManager(
            connectionSettings,
            deviceWrapper,
            stateRepo
        )
    }
}
