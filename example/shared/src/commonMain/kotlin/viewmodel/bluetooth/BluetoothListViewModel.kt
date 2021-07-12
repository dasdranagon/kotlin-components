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

import com.splendo.kaluga.architecture.navigation.NavigationAction
import com.splendo.kaluga.architecture.navigation.NavigationBundle
import com.splendo.kaluga.architecture.navigation.Navigator
import com.splendo.kaluga.architecture.observable.toInitializedObservable
import com.splendo.kaluga.architecture.observable.toUninitializedObservable
import com.splendo.kaluga.architecture.viewmodel.NavigatingViewModel
import com.splendo.kaluga.bluetooth.Bluetooth
import com.splendo.kaluga.bluetooth.BluetoothMonitor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.launch

class BluetoothListNavigation(bundle: NavigationBundle<DeviceDetailsSpecRow<*>>) : NavigationAction<DeviceDetailsSpecRow<*>>(bundle)

class BluetoothListViewModel(private val bluetooth: Bluetooth, private val monitor: BluetoothMonitor, navigator: Navigator<BluetoothListNavigation>) : NavigatingViewModel<BluetoothListNavigation>(navigator) {

    private val _isScanning = MutableStateFlow(false)
    val isScanning = _isScanning.toInitializedObservable(coroutineScope)

    val title = monitor.isEnabled
        .mapLatest { if (it) "Enabled" else "Disabled" }
        .toInitializedObservable("Initializing...", coroutineScope)

    private val _devices = MutableStateFlow(emptyList<BluetoothListDeviceViewModel>())
    val devices = _devices.toInitializedObservable(coroutineScope)

    override fun onResume(scope: CoroutineScope) {
        super.onResume(scope)

        monitor.startMonitoring()
        scope.launch { bluetooth.isScanning().collect { _isScanning.value = it } }
        scope.launch { bluetooth.devices().map { devices -> devices.map { BluetoothListDeviceViewModel(it.identifier, bluetooth, navigator) } }.collect { devices ->
            cleanDevices()
            _devices.value = devices.sortedByDescending { it.name.currentOrNull }
        } }
    }

    override fun onPause() {
        super.onPause()
        monitor.stopMonitoring()
    }

    fun onScanPressed() {
        if (_isScanning.value) {
            bluetooth.stopScanning()
        } else {
            bluetooth.startScanning()
        }
    }

    override fun onCleared() {
        super.onCleared()
        cleanDevices()
    }

    private fun cleanDevices() {
        _devices.value.forEach { it.onCleared() }
    }
}
