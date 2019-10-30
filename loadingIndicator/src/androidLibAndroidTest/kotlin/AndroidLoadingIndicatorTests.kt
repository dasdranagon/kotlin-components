package com.splendo.kaluga.loadingIndicator

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.Until
import kotlinx.coroutines.*
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertNotNull
import kotlin.test.assertTrue
import com.splendo.kaluga.loadingIndicator.test.R

/*

Copyright 2019 Splendo Consulting B.V. The Netherlands

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

class AndroidLoadingIndicatorTests {

    @get:Rule
    var activityRule = ActivityTestRule<TestActivity>(TestActivity::class.java)

    private val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

    companion object {
        const val DEFAULT_TIMEOUT = 1_000L
    }

    @Test
    fun builderMissingViewException() {
        assertFailsWith<IllegalArgumentException> {
            AndroidLoadingIndicator
                .Builder()
                .create()
        }
    }

    @Test
    fun builderInitializer() = runBlockingTest {
        CoroutineScope(Dispatchers.Main).launch {
            val indicator = AndroidLoadingIndicator
                .Builder()
                .setViewResId(R.layout.loading_indicator_view)
                .create()
            assertNotNull(indicator)
        }
    }

    @Test
    fun indicatorShow() = runBlockingTest {
        CoroutineScope(Dispatchers.Main).launch {
            AndroidLoadingIndicator
                .Builder()
                .setViewResId(R.layout.loading_indicator_view)
                .create()
                .present(activityRule.activity)
            device.wait(Until.findObject(By.text("Loading...")), DEFAULT_TIMEOUT)
        }
    }

    @Test
    fun indicatorDismiss() = runBlockingTest {
        CoroutineScope(Dispatchers.Main).launch(Dispatchers.Main) {
            val indicator = AndroidLoadingIndicator
                .Builder()
                .setViewResId(R.layout.loading_indicator_view)
                .create()
            indicator.present(activityRule.activity)
            device.wait(Until.findObject(By.text("Loading...")), DEFAULT_TIMEOUT)
            indicator.dismiss()
            assertTrue(device.wait(Until.gone(By.text("Loading...")), DEFAULT_TIMEOUT))
        }
        Unit
    }
}
