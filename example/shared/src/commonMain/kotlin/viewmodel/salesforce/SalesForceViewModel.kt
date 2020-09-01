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

package com.splendo.kaluga.example.shared.viewmodel.salesforce

import BaseSalesForceViewModel
import com.splendo.kaluga.architecture.observable.toObservable
import com.splendo.kaluga.base.flow.HotFlowable
import com.splendo.kaluga.logging.warn
import kotlinx.coroutines.CoroutineScope

class SalesForceViewModel : BaseSalesForceViewModel() {

    private val _username = HotFlowable<String?>(null)
    val username = _username.toObservable(coroutineScope)

    override fun onResume(scope: CoroutineScope) {}

    override fun logout() {
        warn("SalesForceViewModel") { "Do logout" }
    }

    override fun onLogoutComplete() {
//        _username.set(null)
    }

    override fun onUserSwitched() {
        // _username.set()
    }

    public override fun onCleared() {
        super.onCleared()
    }
}
