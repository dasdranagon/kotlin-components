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

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewModelScope

actual open class ViewModel internal actual constructor(allowFreezing:Boolean) : androidx.lifecycle.ViewModel() {

    actual val coroutineScope = viewModelScope

    actual override fun onCleared() {
        super.onCleared()
    }
}

/**
 * Binds an [AppCompatActivity] to the [ViewModel] to manage the viewmodel lifecycle.
 * @param activity The [AppCompatActivity] to bind to.
 */
fun <VM : BaseViewModel> VM.bind(activity: AppCompatActivity) {
    activity.lifecycle.addObserver(KalugaViewModelLifecycleObserver(this, activity, activity, activity.supportFragmentManager))
}

/**
 * Binds a [Fragment] to the [ViewModel] to manage the viewmodel lifecycle
 * @param fragment The [Fragment] to bind to.
 * @return `true` if the ViewModel could be bound to the [Fragment].
 */
fun <VM : BaseViewModel> VM.bind(fragment: Fragment): Boolean {
    val fragmentManager = fragment.fragmentManager ?: return false
    fragment.lifecycle.addObserver(KalugaViewModelLifecycleObserver(this, fragment.activity, fragment.viewLifecycleOwner, fragmentManager))
    return true
}
