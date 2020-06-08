package com.splendo.kaluga.keyboard

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

/**
 * Class that can a keyboard can be shown for
 */
expect class KeyboardHostingView

/**
 * Interface that defines the actions available for the Keyboard Manager
 */
interface BaseKeyboardManager {

    /**
     * Shows the keyboard for a given [KeyboardHostingView]
     *
     * @param keyboardHostingView The view for which the keyboard will be shown
     */
    fun show(keyboardHostingView: KeyboardHostingView)

    /**
     * Dismisses the current keyboard
     */
    fun hide()
}

expect class KeyboardManager : BaseKeyboardManager

/**
 * Base KeyboardManager builder class, which used to create an KeyboardManager
 *
 * @see KeyboardManager
 */
abstract class BaseKeyboardManagerBuilder {

    /**
     * Creates KeyboardManager object
     *
     * @return The KeyboardManager object
     */
    abstract fun create(): KeyboardManager
}

expect class KeyboardManagerBuilder : BaseKeyboardManagerBuilder
