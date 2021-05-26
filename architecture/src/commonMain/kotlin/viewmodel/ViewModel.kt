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

package com.splendo.kaluga.architecture.viewmodel

import com.splendo.kaluga.architecture.navigation.NavigationAction
import com.splendo.kaluga.architecture.navigation.Navigator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancelChildren

/**
 * Simple ViewModel class
 */
expect open class ViewModel internal constructor(allowFreezing:Boolean = false) {
    /**
     * [CoroutineScope] of the ViewModel
     */
    val coroutineScope: CoroutineScope

    /**
     * Called when the ViewModel is cleared
     */
    protected open fun onCleared()
}

/**
 * Default [ViewModel] implementation respecting the Lifecycle of the presenting view
 */
open class BaseViewModel(allowFreezing:Boolean = false) : ViewModel(allowFreezing) {

    private val resumedJobs = SupervisorJob()

    /**
     * Function to be called when the presenting views lifecycle begins
     */
    fun didResume() {
        onResume(CoroutineScope(coroutineScope.coroutineContext + resumedJobs))
    }

    /**
     * Custom handler when the presenting views lifecycle begins
     * @param scope A [CoroutineScope] that lives during the lifecycle of the presenting view
     */
    protected open fun onResume(scope: CoroutineScope) {}

    /**
     * Function to be called when the presenting views lifecycle ends
     */
    fun didPause() {
        onPause()
        resumedJobs.cancelChildren()
    }

    /**
     * Custom handler when the presenting views lifecycle ends
     */
    protected open fun onPause() {}
}

/**
 * Default [ViewModel] allowing navigation
 * @param navigator The [Navigator] handling navigation
 */
open class NavigatingViewModel<A : NavigationAction<*>>(val navigator: Navigator<A>, allowFreezing: Boolean = false) : BaseViewModel(allowFreezing)
