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

package com.splendo.kaluga.bluetooth.beacons

import co.touchlab.stately.collections.IsoMutableMap
import com.splendo.kaluga.base.AtomicReferenceDelegate
import com.splendo.kaluga.base.utils.Date
import com.splendo.kaluga.bluetooth.BluetoothService
import com.splendo.kaluga.bluetooth.device.Device
import com.splendo.kaluga.bluetooth.device.Identifier
import com.splendo.kaluga.logging.debug
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

private typealias BeaconJob = Pair<BeaconInfo, Job>
private typealias BeaconsMap = IsoMutableMap<BeaconID, BeaconJob>

class Beacons(
    private val bluetooth: BluetoothService,
    private val timeoutMs: Long = 10_000,
) {

    private companion object { const val TAG = "Beacons" }

    private val cache = BeaconsMap()
    private val cacheJob = Job()
    private val coroutineScope = CoroutineScope(Dispatchers.Default + cacheJob)
    private var monitoringJob: Job? by AtomicReferenceDelegate()

    private val _beacons = MutableStateFlow(emptySet<BeaconInfo>())
    val beacons: StateFlow<Set<BeaconInfo>>
        get() = _beacons.asStateFlow()

    fun startMonitoring(coroutineScope: CoroutineScope) {
        debug(TAG, "Start monitoring")
        _beacons.value = emptySet()
        bluetooth.startScanning()
        monitoringJob = coroutineScope.launch {
            bluetooth.devices().collect { list ->
                debug(TAG, "Total Bluetooth devices discovered: ${list.size}")
                updateBeacons(list.mapNotNull { createBeaconWith(it) })
            }
        }
    }

    fun stopMonitoring() {
        debug(TAG, "Stop monitoring")
        bluetooth.stopScanning()
        monitoringJob?.cancel()
        monitoringJob = null
        _beacons.value = emptySet()
    }

    suspend fun isMonitoring() = bluetooth.isScanning()

    fun isAnyInRange(beaconIds: List<String>) = beacons.map { list ->
        list.any { beaconIds.containsLowerCased(it.beaconID.asString()) }
    }

    private suspend fun updateBeacons(discovered: List<BeaconInfo>) {
        debug(TAG, "Total Beacons discovered: ${discovered.size}")
        discovered.forEach { beacon ->
            if (cache.containsKey(beacon.beaconID)) {
                debug(TAG, "[Found] $beacon")
                cache.remove(beacon.beaconID)?.second?.cancel()
                debug(TAG, "[Removed] $beacon")
            } else {
                debug(TAG, "[New] $beacon")
            }
            cache[beacon.beaconID] = beacon to coroutineScope.launch {
                debug(TAG, "[Added] $beacon")
                delay(timeoutMs)
                debug(TAG, "[Lost] $beacon")
                cache.remove(beacon.beaconID)
                updateList()
            }
        }
        updateList()
    }

    private fun updateList() = _beacons.update {
        cache.values.map(BeaconJob::first).toSet()
    }

    private fun List<String>.containsLowerCased(element: String): Boolean =
        this.map(String::lowercase).contains(element.lowercase())

    private suspend fun createBeaconWith(device: Device): BeaconInfo? {
        val serviceData = device.map { it.advertisementData.serviceData }.firstOrNull() ?: return null
        val data = serviceData[Eddystone.SERVICE_UUID] ?: return null
        val frame = Eddystone.unpack(data) ?: return null
        val rssi = device.map { it.rssi }.firstOrNull() ?: 0
        val lastSeen = device.map { it.updatedAt }.firstOrNull() ?: Date.now()
        return BeaconInfo(device.identifier, frame.uid, frame.txPower, rssi, lastSeen)
    }
}

operator fun Flow<Set<BeaconInfo>>.get(identifier: Identifier) = map { beacons ->
    beacons.firstOrNull { it.identifier == identifier }
}
