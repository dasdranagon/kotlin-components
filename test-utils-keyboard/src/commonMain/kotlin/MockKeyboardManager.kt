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

import co.touchlab.stately.collections.IsoMutableList
import co.touchlab.stately.concurrency.AtomicReference
import co.touchlab.stately.concurrency.value
import com.splendo.kaluga.keyboard.BaseKeyboardManager
import com.splendo.kaluga.keyboard.FocusHandler
import com.splendo.kaluga.test.base.mock.call
import com.splendo.kaluga.test.base.mock.on
import com.splendo.kaluga.test.base.mock.parameters.mock
import kotlinx.coroutines.CoroutineScope

/**
 * Mock implementation of [BaseKeyboardManager]
 * @param setupMocks If `true` configure mocks to display the keyboard
 */
class MockKeyboardManager(setupMocks: Boolean = true) : BaseKeyboardManager {

    /**
     * Mock implementation of [BaseKeyboardManager.Builder]
     * @param setupMocks If `true` sets up [createMock] to build [MockKeyboardManager]
     */
    class Builder(setupMocks: Boolean = true) : BaseKeyboardManager.Builder {

        /**
         * List of created [MockKeyboardManager]
         */
        val builtKeyboardManagers = IsoMutableList<MockKeyboardManager>()

        /**
         * [com.splendo.kaluga.test.base.mock.BaseMethodMock] for [create]
         */
        val createMock = ::create.mock()

        init {
            if (setupMocks) {
                createMock.on().doExecute { _ ->
                    MockKeyboardManager(setupMocks).also {
                        builtKeyboardManagers.add(it)
                    }
                }
            }
        }

        override fun create(coroutineScope: CoroutineScope): MockKeyboardManager = createMock.call(coroutineScope)
    }

    val _focusHandler = AtomicReference<FocusHandler?>(null)

    /**
     * Gets the current [FocusHandler]
     */
    var focusHandler: FocusHandler?
        get() = _focusHandler.value
        private set(value) = _focusHandler.set(value)

    /**
     * [com.splendo.kaluga.test.base.mock.BaseMethodMock] for [show]
     */
    val showMock = ::show.mock()

    /**
     * [com.splendo.kaluga.test.base.mock.BaseMethodMock] for [hide]
     */
    val hideMock = ::hide.mock()

    init {
        if (setupMocks) {
            showMock.on().doExecute { (focusHandler) ->
                this.focusHandler = focusHandler
                (focusHandler as? MockFocusHandler)?.simulateGiveFocus()
            }
            hideMock.on().doExecute {
                (focusHandler as? MockFocusHandler)?.simulateRemoveFocus()
                focusHandler = null
            }
        }
    }

    override fun show(focusHandler: FocusHandler): Unit = showMock.call(focusHandler)

    override fun hide(): Unit = hideMock.call()
}