/*
 Copyright 2021 Splendo Consulting B.V. The Netherlands

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

package com.splendo.kaluga.architecture.observable

import co.touchlab.stately.concurrency.AtomicReference
import com.splendo.kaluga.base.runBlocking
import kotlinx.coroutines.flow.MutableStateFlow
import kotlin.properties.ReadOnlyProperty
import kotlin.test.Test
import kotlin.test.assertEquals

// Observables run on the Main dispatcher. This automatically also tests thread switching.
class ReadOnlyPropertyTest : ObservableBaseTest() {

    @Test
    fun testReadOnlyPropertyDefaultObservable() = runBlocking {

        val nullableString = MutableStateFlow<String?>(null)
        val ro = ReadOnlyProperty<Any?, String?> { _, _ -> nullableString.value }

        val observable = ro.toDefaultObservable("default")

        val observed = AtomicReference("nothing yet")
        observable.observeInitialized { observed.set(it) }

        testStringDefaultObservable(
            observable = observable,
            initialExpected = "default",
            shortDelayAfterUpdate = false,
            {
                nullableString.value = "new"
                assertEquals("default", observed.get(), "the property will only report the new value upon read")
                "new"
            }, // when we actually read the property to test this, the new value will propagate
            {
                nullableString.value = null
                "default"
            }
        )
        Unit
    }

    @Test
    fun testReadOnlyPropertyObservable() = runBlocking {
        val s = MutableStateFlow("initial")
        val ro = ReadOnlyProperty<Any?, String> { _, _ -> s.value }

        testInitializedStringObservable(
            observable = ro.toInitializedObservable(),
            initialExpected = "initial",
            shortDelayAfterUpdate = false,
            { s.value = "new"; "new" }, //
            { s.value = "other"; "other" }
        )
    }

    @Test
    fun testReadOnlyNullablePropertyObservableWithInitialValue() = testReadOnlyNullablePropertyObservable("initial")
    @Test
    fun testReadOnlyNullablePropertyObservableWithInitialNull() = testReadOnlyNullablePropertyObservable(null)
    private fun testReadOnlyNullablePropertyObservable(initial: String?) = runBlocking {
        val s = MutableStateFlow(initial)
        val ro = ReadOnlyProperty<Any?, String?> { _, _ -> s.value }

        testInitializedNullableStringObservable(
            observable = ro.toInitializedObservable(),
            initialExpected = initial,
            shortDelayAfterUpdate = false,
            { s.value = "new"; "new" },
            { s.value = null; null },
            { s.value = "other"; "other" }
        )
    }
}
