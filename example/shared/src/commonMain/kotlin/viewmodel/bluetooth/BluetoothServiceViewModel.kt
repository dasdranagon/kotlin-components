/*
 Copyright 2020 Splendo Consulting B.V. The Netherlands

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

import com.splendo.kaluga.architecture.observable.toObservable
import com.splendo.kaluga.architecture.viewmodel.BaseViewModel
import com.splendo.kaluga.base.UUID
import com.splendo.kaluga.base.uuidString
import com.splendo.kaluga.bluetooth.Bluetooth
import com.splendo.kaluga.bluetooth.Service
import com.splendo.kaluga.bluetooth.characteristics
import com.splendo.kaluga.bluetooth.device.Identifier
import com.splendo.kaluga.bluetooth.get
import com.splendo.kaluga.bluetooth.services
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class BluetoothServiceViewModel(private val bluetooth: Bluetooth, private val deviceIdentifier: Identifier, private val serviceUUID: UUID) : BaseViewModel() {

    private val service: Flow<Service?> get() = bluetooth.devices()[deviceIdentifier].services()[serviceUUID]

    val uuid = serviceUUID.uuidString
    private val _characteristics = ConflatedBroadcastChannel<List<BluetoothCharacteristicViewModel>>()
    val characteristics = _characteristics.toObservable(coroutineScope)

    override fun onResume(scope: CoroutineScope) {
        super.onResume(scope)

        scope.launch {
            service.characteristics().map { characteristics -> characteristics.map { BluetoothCharacteristicViewModel(bluetooth, deviceIdentifier, serviceUUID, it.uuid) } }.collect {
                cleanCharacteristics()
                _characteristics.send(it)
            }
        }
    }

    public override fun onCleared() {
        super.onCleared()
        cleanCharacteristics()
    }

    private fun cleanCharacteristics() {
        _characteristics.valueOrNull?.forEach { it.onCleared() }
    }
}
