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

package com.splendo.kaluga.test.bluetooth

import com.splendo.kaluga.bluetooth.Descriptor
import com.splendo.kaluga.bluetooth.DescriptorWrapper
import com.splendo.kaluga.bluetooth.device.DeviceAction
import com.splendo.kaluga.test.base.mock.call
import com.splendo.kaluga.test.base.mock.parameters.mock
import kotlinx.coroutines.flow.MutableSharedFlow

/**
 * Mock implementation of [Descriptor]
 */
class MockDescriptor(descriptorWrapper: DescriptorWrapper, newActionFlow: MutableSharedFlow<DeviceAction>) : Descriptor(descriptorWrapper, newActionFlow = newActionFlow) {

    /**
     * [com.splendo.kaluga.test.base.mock.BaseMethodMock] for [updateValue]
     */
    val updateMock = ::updateValue.mock()
    override suspend fun updateValue(): Unit = updateMock.call()
}
