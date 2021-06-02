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

package com.splendo.kaluga.bluetooth

import com.splendo.kaluga.bluetooth.device.DeviceAction
import com.splendo.kaluga.bluetooth.device.DeviceStateFlowRepo

open class Characteristic(val wrapper: CharacteristicWrapper, initialValue: ByteArray? = null, stateRepo: DeviceStateFlowRepo) : Attribute<DeviceAction.Read.Characteristic, DeviceAction.Write.Characteristic>(initialValue, stateRepo) {

    var isNotifying: Boolean = false

    suspend fun enableNotification() {
        if (!isNotifying)
            addAction(createNotificationAction(true))
        isNotifying = true
    }

    suspend fun disableNotification() {
        if (isNotifying)
            addAction(createNotificationAction(false))
        isNotifying = false
    }

    override val uuid = wrapper.uuid

    val descriptors:List<Descriptor> = wrapper.descriptors.map { Descriptor(it, stateRepo = stateRepo) }

    override fun createReadAction(): DeviceAction.Read.Characteristic {
        return DeviceAction.Read.Characteristic(this)
    }

    override fun createWriteAction(newValue: ByteArray?): DeviceAction.Write.Characteristic {
        return DeviceAction.Write.Characteristic(newValue, this)
    }

    fun createNotificationAction(enabled: Boolean): DeviceAction.Notification {
        return DeviceAction.Notification(this, enabled)
    }

    override fun getUpdatedValue(): ByteArray? {
        return wrapper.value?.asBytes
    }

}

expect interface CharacteristicWrapper {
    val uuid: UUID
    val descriptors: List<DescriptorWrapper>
    val value: Value?
}