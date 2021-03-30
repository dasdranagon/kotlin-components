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

package com.splendo.kaluga.bluetooth.mock

import android.bluetooth.BluetoothGattCallback
import android.content.Context
import com.splendo.kaluga.bluetooth.device.BluetoothGattWrapper
import com.splendo.kaluga.bluetooth.device.DeviceWrapper
import com.splendo.kaluga.bluetooth.device.Identifier
import com.splendo.kaluga.utils.EmptyCompletableDeferred
import com.splendo.kaluga.utils.complete
import kotlinx.coroutines.CompletableDeferred

class MockDeviceWrapper(override val name: String?, override val address: Identifier, override val bondState: Int) : DeviceWrapper {

    val connectGattCompleted = CompletableDeferred<BluetoothGattCallback>()
    val removeBondCompleted = EmptyCompletableDeferred()

    override fun connectGatt(context: Context, autoConnect: Boolean, callback: BluetoothGattCallback): BluetoothGattWrapper {
        connectGattCompleted.complete(callback)
        return MockBluetoothGattWrapper()
    }

    override fun removeBond() {
        removeBondCompleted.complete()
    }
}
