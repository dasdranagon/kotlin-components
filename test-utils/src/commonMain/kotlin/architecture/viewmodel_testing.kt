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

package com.splendo.kaluga.test.architecture

import co.touchlab.stately.ensureNeverFrozen
import com.splendo.kaluga.architecture.viewmodel.LifecycleViewModel
import com.splendo.kaluga.test.BaseTest
import com.splendo.kaluga.test.UIThreadTest
import kotlinx.coroutines.CoroutineScope
import kotlin.test.BeforeTest

abstract class ViewModelTest<VM : LifecycleViewModel>(allowFreezing: Boolean = false) : BaseTest() {

    init {
        if (!allowFreezing) ensureNeverFrozen()
    }

    lateinit var viewModel: VM

    protected abstract fun createViewModel(): VM

    @BeforeTest
    override fun beforeTest() {
        super.beforeTest()
        viewModel = createViewModel()
    }
}

abstract class SimpleUIThreadViewModelTest<VM : LifecycleViewModel> :
    UIThreadViewModelTest<UIThreadViewModelTest.ViewModelTestContext<VM>, VM>(allowFreezing = true) {

    override val createTestContext: suspend (CoroutineScope) -> ViewModelTestContext<VM> =
        { LazyViewModelTestContext(it, ::createViewModel) }

    abstract fun createViewModel(): VM
}

abstract class UIThreadViewModelTest<VMC : UIThreadViewModelTest.ViewModelTestContext<VM>, VM : LifecycleViewModel>(allowFreezing: Boolean = false) :
    UIThreadTest<VMC>(allowFreezing) {

    open class LazyViewModelTestContext<VM>(coroutineScope: CoroutineScope, private val createViewModel: () -> VM) :
        ViewModelTestContext<VM>, CoroutineScope by coroutineScope {
        override val viewModel: VM by lazy { createViewModel() }
    }

    interface ViewModelTestContext<VM> : TestContext {
        val viewModel: VM
    }
}
