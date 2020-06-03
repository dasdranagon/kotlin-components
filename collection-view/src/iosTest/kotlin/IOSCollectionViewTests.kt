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
package com.splendo.kaluga.collectionview

import com.splendo.kaluga.architecture.observable.DisposeBag
import com.splendo.kaluga.base.runBlocking
import com.splendo.kaluga.logging.debug
import kotlinx.coroutines.CompletableDeferred
import kotlin.test.AfterTest
import kotlin.test.Test
import kotlin.test.assertEquals

class IOSCollectionViewTests : AbstractCollectionViewTest() {

    private val disposeBag = DisposeBag()

    @AfterTest
    fun tearDown() {
        disposeBag.dispose()
    }

    override fun observe(viewModel: MockCollectionItemsViewModel, deferredItems: List<CompletableDeferred<List<CollectionViewItem>>>) {
        viewModel.items.observe { items ->
            deferredItems.firstOrNull { !it.isCompleted }?.complete(items)
        }.addTo(disposeBag)
    }

}
