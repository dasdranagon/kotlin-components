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

package com.splendo.kaluga.test.keyboard

import com.splendo.kaluga.base.runBlocking
import com.splendo.kaluga.test.mock.focus.MockFocusHandler
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class MockFocusHandlerTest {

    @Test
    fun test_initial_state() = testFocusHandler {
        assertFalse(it.isFocused)
    }

    @Test
    fun test_give_focus() = testFocusHandler {
        assertFalse(it.isFocused)
        it.simulateGiveFocus()
        assertTrue(it.isFocused)
    }

    @Test
    fun test_remove_focus() = testFocusHandler {
        assertFalse(it.isFocused)
        it.simulateGiveFocus()
        assertTrue(it.isFocused)

        it.simulateRemoveFocus()
        assertFalse(it.isFocused)
    }

    @Test
    fun test_give_remove_multiple_times() = testFocusHandler { focusHandler ->
        assertFalse(focusHandler.isFocused)
        repeat(10) {
            focusHandler.simulateGiveFocus()
            assertTrue(focusHandler.isFocused)

            focusHandler.simulateRemoveFocus()
            assertFalse(focusHandler.isFocused)
        }
    }

    private fun testFocusHandler(block: (focusHandler: MockFocusHandler) -> Unit) = runBlocking {
        block(MockFocusHandler())
    }
}
