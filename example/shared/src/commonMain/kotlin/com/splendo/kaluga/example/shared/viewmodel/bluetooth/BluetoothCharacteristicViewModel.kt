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

package com.splendo.kaluga.example.shared.viewmodel.bluetooth

import com.splendo.kaluga.architecture.observable.toInitializedObservable
import com.splendo.kaluga.base.utils.toHexString
import com.splendo.kaluga.bluetooth.Bluetooth
import com.splendo.kaluga.bluetooth.Characteristic
import com.splendo.kaluga.bluetooth.UUID
import com.splendo.kaluga.bluetooth.characteristics
import com.splendo.kaluga.bluetooth.descriptors
import com.splendo.kaluga.bluetooth.device.Identifier
import com.splendo.kaluga.bluetooth.get
import com.splendo.kaluga.bluetooth.services
import com.splendo.kaluga.bluetooth.uuidString
import com.splendo.kaluga.bluetooth.value
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class BluetoothCharacteristicViewModel(
    private val bluetooth: Bluetooth,
    private val deviceIdentifier: Identifier,
    private val serviceUUID: UUID,
    private val characteristicUUID: UUID,
    private val coroutineScope: CoroutineScope,
) {

    private val characteristic: Flow<Characteristic?> get() = bluetooth.scannedDevices()[deviceIdentifier].services()[serviceUUID].characteristics()[characteristicUUID]

    val uuid = characteristicUUID.uuidString
    val value = characteristic.value().map { it?.toHexString() ?: "" }.toInitializedObservable("", coroutineScope)

    private val descriptorsJob = Job(coroutineScope.coroutineContext[Job])
    val descriptors = characteristic.descriptors().map { descriptors ->
        descriptorsJob.cancelChildren()
        descriptors.map {
            BluetoothDescriptorViewModel(
                bluetooth,
                deviceIdentifier,
                serviceUUID,
                characteristicUUID,
                it.uuid,
                CoroutineScope(coroutineScope.coroutineContext + descriptorsJob),
            )
        }
    }.toInitializedObservable(emptyList(), coroutineScope)

    private var readValueJob: Job? = null

    fun onResume() {
        readValueJob?.cancel()
        readValueJob = coroutineScope.launch { characteristic.flatMapLatest { characteristic -> characteristic?.let { flowOf(it) } ?: emptyFlow() }.first().readValue() }
    }

    fun onPause() {
        readValueJob?.cancel()
        readValueJob = null
    }
}
