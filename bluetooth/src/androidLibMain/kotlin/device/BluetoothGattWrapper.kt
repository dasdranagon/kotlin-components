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

package com.splendo.kaluga.bluetooth.device

import android.bluetooth.BluetoothGatt
import android.bluetooth.BluetoothGattCharacteristic
import android.bluetooth.BluetoothGattDescriptor
import com.splendo.kaluga.bluetooth.CharacteristicWrapper
import com.splendo.kaluga.bluetooth.DescriptorWrapper

interface BluetoothGattWrapper {
    fun connect(): Boolean
    fun discoverServices(): Boolean
    fun disconnect()
    fun readRemoteRssi(): Boolean

    fun readCharacteristic(wrapper: CharacteristicWrapper): Boolean
    fun readDescriptor(wrapper: DescriptorWrapper): Boolean
    fun writeCharacteristic(wrapper: CharacteristicWrapper): Boolean
    fun writeDescriptor(wrapper: DescriptorWrapper): Boolean
    fun setCharacteristicNotification(wrapper: CharacteristicWrapper, enable: Boolean): Boolean
}

class DefaultBluetoothGattWrapper(private val gatt: BluetoothGatt) : BluetoothGattWrapper {

    override fun connect(): Boolean {
        return gatt.connect()
    }

    override fun discoverServices(): Boolean {
        return gatt.discoverServices()
    }

    override fun disconnect() {
        gatt.disconnect()
    }

    override fun readRemoteRssi(): Boolean {
        return gatt.readRemoteRssi()
    }

    override fun readCharacteristic(wrapper: CharacteristicWrapper): Boolean {
        val characteristic = getCharacteristic(wrapper) ?: return false
        return gatt.readCharacteristic(characteristic)
    }

    override fun readDescriptor(wrapper: DescriptorWrapper): Boolean {
        val descriptor = getDescriptor(wrapper) ?: return false
        return gatt.readDescriptor(descriptor)
    }

    override fun writeCharacteristic(wrapper: CharacteristicWrapper): Boolean {
        val characteristic = getCharacteristic(wrapper) ?: return false
        return gatt.writeCharacteristic(characteristic)
    }

    override fun writeDescriptor(wrapper: DescriptorWrapper): Boolean {
        val descriptor = getDescriptor(wrapper) ?: return false
        return gatt.writeDescriptor(descriptor)
    }

    override fun setCharacteristicNotification(wrapper: CharacteristicWrapper, enable: Boolean): Boolean {
        val characteristic = getCharacteristic(wrapper) ?: return false
        return gatt.setCharacteristicNotification(characteristic, enable)
    }

    private fun getCharacteristic(wrapper: CharacteristicWrapper): BluetoothGattCharacteristic? {
        return gatt.getService(wrapper.service.uuid)?.getCharacteristic(wrapper.uuid)
    }

    private fun getDescriptor(wrapper: DescriptorWrapper): BluetoothGattDescriptor? {
        return getCharacteristic(wrapper.characteristic)?.getDescriptor(wrapper.uuid)
    }
}