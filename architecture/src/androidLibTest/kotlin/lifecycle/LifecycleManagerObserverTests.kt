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

package com.splendo.kaluga.architecture.lifecycle

import android.app.Activity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LifecycleOwner
import com.splendo.kaluga.base.runBlocking
import com.splendo.kaluga.test.BaseTest
import kotlin.test.assertEquals
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class LifecycleManagerObserverTests : BaseTest() {

    @Mock
    private lateinit var activity: Activity
    @Mock
    private lateinit var lifecycleOwner: LifecycleOwner
    @Mock
    private lateinit var fragmentManager: FragmentManager

    @Before
    fun setUp() {
        super.beforeTest()
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun testUIContextObserverHandlerCalled() = runBlocking {
        val observer = LifecycleManagerObserver()
        val data: LifecycleSubscribable.LifecycleManager? = LifecycleSubscribable.LifecycleManager(
            activity, lifecycleOwner, fragmentManager
        )

        val deferredUIContext = MutableList(3) { CompletableDeferred<LifecycleSubscribable.LifecycleManager?>() }
        val job = launch(Dispatchers.Main) {
            observer.managerState.collect { context ->
                deferredUIContext.firstOrNull { !it.isCompleted }?.complete(context)
            }
        }

        assertNull(deferredUIContext[0].await())
        observer.subscribe(activity, lifecycleOwner, fragmentManager)
        assertEquals(data, deferredUIContext[1].await())
        observer.unsubscribe()
        assertNull(deferredUIContext[2].await())
        job.cancel()
    }
}
