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

package com.splendo.kaluga.test

import com.splendo.kaluga.base.utils.EmptyCompletableDeferred
import com.splendo.kaluga.base.utils.complete
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeout
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.time.seconds

class SimpleUIThreadTestTest : SimpleUIThreadTest() {

    @Test
    fun testSimpleUIThreadTest() = testOnUIThread {
        withTimeout(2.seconds) {
            coroutineScope {
                val e = EmptyCompletableDeferred()
                launch(Dispatchers.Main) {
                    e.complete()
                }
                e.await()
            }
        }
    }
}

class UIThreadTestTest : UIThreadTest<UIThreadTestTest.MyTestContext>() {
    inner class MyTestContext : TestContext {
        var myContext = "myContext"
    }

    override fun createTestContext(): MyTestContext = MyTestContext()

    @Test
    fun testUIThreadTest() = testOnUIThread {
        assertEquals("myContext", myContext)
        myContext = "someContext"
    }
}
