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

import kotlin.math.pow

expect class Identifier

expect class DeviceHolder {
    val name: String?
    val identifier: Identifier
}

interface DeviceInfo {

    val identifier: Identifier
    val name: String?
    val rssi: Int
    val advertisementData: BaseAdvertisementData
    fun distance(environmentalFactor: Double = 2.0): Double

}

data class DeviceInfoImpl(internal val deviceHolder: DeviceHolder, override val rssi: Int, override val advertisementData: BaseAdvertisementData) : DeviceInfo {

    override val identifier: Identifier
        get() = deviceHolder.identifier

    override val name: String?
        get() = deviceHolder.name

    override fun distance(environmentalFactor: Double): Double {
        if (advertisementData.txPowerLevel == Int.MIN_VALUE || environmentalFactor.isNaN())
            return Double.NaN
        return 10.0.pow((advertisementData.txPowerLevel.toDouble() - rssi.toDouble())/(10.0*environmentalFactor))
    }

}