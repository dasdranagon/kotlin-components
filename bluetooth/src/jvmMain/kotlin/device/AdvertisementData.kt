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

import com.splendo.kaluga.bluetooth.UUID

actual class AdvertisementData : BaseAdvertisementData {

    override val name: String?
        get() = null
    override val manufacturerId: Int?
        get() = null
    override val manufacturerData: ByteArray?
        get() = null
    override val serviceUUIDs: List<UUID>
        get() = emptyList()
    override val serviceData: Map<UUID, ByteArray?>
        get() = emptyMap()
    override val txPowerLevel: Int
        get() = Int.MIN_VALUE
    override val isConnectible: Boolean
        get() = false
}