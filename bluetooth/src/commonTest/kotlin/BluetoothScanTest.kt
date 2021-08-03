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

import com.splendo.kaluga.base.runBlocking
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BluetoothScanTest: BluetoothFlowTest<Boolean>() {

    override val flow: () -> Flow<Boolean> = {
        runBlocking {
            setup(Setup.BLUETOOTH)
            bluetooth.isScanning()
        }
    }

    @Test
    fun testIsScanning() = testWithFlow {
        val bluetooth = bluetooth
        val devicesJob = launch {
            bluetooth.devices().collect { }
        }
        test {
            assertFalse(it)
        }
        action {
            bluetooth.startScanning()
        }
        test {
            assertTrue(it)
        }
        action {
            bluetooth.stopScanning()
        }
        test {
            assertFalse(it)
        }
        devicesJob.cancel()
    }
}
