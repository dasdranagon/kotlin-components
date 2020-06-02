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

package com.splendo.kaluga.architecture.observable

import kotlin.native.internal.GC

typealias DisposeHandler = () -> Unit

/**
 * Reference to an object that should be disposed in time
 * @param onDispose Function to call when disposing the object
 */
class Disposable(onDispose: DisposeHandler) {

    private var disposeHandler: DisposeHandler? = onDispose

    /**
     * Disposes the associated object
     */
    fun dispose() {
        disposeHandler?.invoke()
        disposeHandler = null
        GC.collect()
    }

    /**
     * Adds this disposable to a [DisposeBag]
     */
    fun addTo(disposeBag: DisposeBag) {
        disposeBag.add(this)
    }
}

/**
 * Container for multiple [Disposable]. Allows nested [DisposeBag]
 */
class DisposeBag {

    private val disposables = mutableListOf<Disposable>()
    private val nestedBags = mutableListOf<DisposeBag>()

    /**
     * Adds a nested [DisposeBag]
     */
    fun add(disposeBag: DisposeBag) {
        nestedBags.add(disposeBag)
    }

    /**
     * Adds a [Disposable] to this [DisposeBag]
     */
    fun add(disposable: Disposable) {
        disposables.add(disposable)
    }

    /**
     * Disposes all [Disposable]s and nested [DisposeBag]s added to this [DisposeBag].
     * Added elements can only be disposed once
     */
    fun dispose() {
        disposables.forEach { it.dispose() }
        disposables.clear()
        nestedBags.forEach { it.dispose() }
        nestedBags.clear()
    }
}
