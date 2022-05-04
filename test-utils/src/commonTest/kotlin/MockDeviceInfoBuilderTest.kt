
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

import com.splendo.kaluga.base.runBlocking
import com.splendo.kaluga.bluetooth.uuidFrom
import com.splendo.kaluga.test.mock.bluetooth.createMockDevice
import com.splendo.kaluga.test.mock.bluetooth.uuid
import kotlinx.coroutines.flow.first
import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class MockDeviceInfoBuilderTest {

    @Test
    fun testBuilder() = runBlocking {

        val device = createMockDevice(coroutineContext) {
            deviceName = "foo"
            rssi = -43
            manufacturerId = 0x1234
            manufacturerData = byteArrayOf(1, 2, 3)
            txPowerLevel = 10
            serviceData = mapOf(
                uuidFrom("180a") to byteArrayOf(4, 5, 6)
            )
            services {
                uuid("180d")
            }
        }.first()

        assertEquals("foo", device.name)
        assertEquals(-43, device.rssi)
        assertEquals(0x1234, device.advertisementData.manufacturerId)
        assertContentEquals(
            byteArrayOf(1, 2, 3),
            device.advertisementData.manufacturerData
        )
        assertEquals(10, device.advertisementData.txPowerLevel)
        assertContentEquals(
            listOf(uuidFrom("180d")),
            device.advertisementData.serviceUUIDs
        )
        assertEquals(1, device.advertisementData.serviceData.size)
        assertContentEquals(
            byteArrayOf(4, 5, 6),
            device.advertisementData.serviceData[uuidFrom("180a")]
        )
    }
}
