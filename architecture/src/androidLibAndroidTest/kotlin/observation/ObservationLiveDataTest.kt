/*
 Copyright 2021 Splendo Consulting B.V. The Netherlands

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

package com.splendo.kaluga.architecture.observation

import androidx.lifecycle.MutableLiveData
import com.splendo.kaluga.architecture.observable.liveData
import com.splendo.kaluga.architecture.observable.liveDataObserver
import com.splendo.kaluga.architecture.observable.toDefaultObservable
import com.splendo.kaluga.architecture.observable.toInitializedObservable
import com.splendo.kaluga.architecture.observable.toInitializedSubject
import com.splendo.kaluga.test.BaseTest
import com.splendo.kaluga.test.testBlockingAndCancelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class ObservationLiveDataTest: BaseTest() {

    @Test
    fun testLiveData() = testBlockingAndCancelScope {

        val flow = MutableStateFlow("initial")
        val subject = flow.toInitializedSubject(this)
        val channel = Channel<String>(4)

        launch(Dispatchers.Main) {
            subject.liveData.observeForever {
                channel.offer(it)
            }
        }

        assertEquals("initial", channel.receive())

        flow.value = "value"
        assertEquals("value", channel.receive())
    }

    @Test
    fun testLiveDataWithNull() = testBlockingAndCancelScope {

        val flow = MutableStateFlow<String?>(null)
        val observable = flow.toInitializedObservable(this)
        val channel = Channel<String?>(4)

        launch(Dispatchers.Main) {
            observable.liveData.observeForever {
                channel.offer(it)
            }
        }

        assertNull(channel.receive())

        flow.value = "value"
        assertEquals("value", channel.receive())

        flow.value = null
        assertNull(channel.receive())

    }

    @Test
    fun testLiveDataWithNullAndDefault() = testBlockingAndCancelScope {

        val flow = MutableStateFlow<String?>(null)
        val observable = flow.toDefaultObservable("default", coroutineScope = this)
        val channel = Channel<String?>(4)

        launch(Dispatchers.Main) {
            observable.liveData.observeForever {
                channel.offer(it)
            }
        }

        assertEquals("default", channel.receive())

        flow.value = "value"
        assertEquals("value", channel.receive())

        flow.value = null
        assertEquals("default", channel.receive())

    }

    @Test
    fun testLiveDataObserver() = testBlockingAndCancelScope {
        val flow = MutableStateFlow("initial")
        val subject = flow.toInitializedSubject(this)

        val liveData = MutableLiveData("value")


        withContext(Dispatchers.Main) {
            liveData.observeForever(subject.liveDataObserver)
            assertEquals("value", subject.current)

            liveData.value ="foo"
            assertEquals("foo", subject.current)
        }


    }
}