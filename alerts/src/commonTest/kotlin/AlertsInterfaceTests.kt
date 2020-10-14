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

import com.splendo.kaluga.alerts.AlertInterface
import com.splendo.kaluga.alerts.buildActionSheet
import com.splendo.kaluga.alerts.buildAlert
import com.splendo.kaluga.base.MultiplatformMainScope
import com.splendo.kaluga.base.runBlocking
import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertNull
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class AlertsInterfaceTests {

    abstract val builder: AlertInterface.Builder

    @Test
    fun testAlertBuilderExceptionNoActions() = runBlocking {
        assertFailsWith<IllegalArgumentException> {
            builder.buildAlert(MultiplatformMainScope()) {
                setTitle("OK")
            }
        }
        Unit
    }

    @Test
    fun testAlertBuilderExceptionNoTitleOrMessage() = runBlocking {
        assertFailsWith<IllegalArgumentException> {
            builder.buildAlert(MultiplatformMainScope()) {
                setPositiveButton("OK")
            }
        }
        Unit
    }

    @Test
    fun testAlertFlowCancel() = runBlocking {
        val coroutine = CoroutineScope(Dispatchers.Main).launch {
            val presenter = builder.buildAlert(MultiplatformMainScope()) {
                setTitle("Hello")
                setPositiveButton("OK")
                setNegativeButton("Cancel")
            }

            val result = coroutineContext.run { presenter.show() }
            assertNull(result)
        }
        // On cancel call, we expect the dialog to be dismissed
        coroutine.cancel()
    }

    @Test
    fun testActionSheetFlowCancel() = runBlocking {
        val coroutine = CoroutineScope(Dispatchers.Main).launch {
            val presenter = builder.buildActionSheet(MultiplatformMainScope()) {
                setTitle("Choose")
                setPositiveButton("Option 1")
                setPositiveButton("Option 2")
                setPositiveButton("Option 3")
            }

            val result = coroutineContext.run { presenter.show() }
            assertNull(result)
        }
        // On cancel call, we expect the dialog to be dismissed
        coroutine.cancel()
    }
}
