package com.splendo.kaluga.state
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

import com.splendo.kaluga.base.MainQueueDispatcher
import com.splendo.kaluga.base.flow.ColdFlowable
import com.splendo.kaluga.base.flow.HotFlowable
import com.splendo.kaluga.flow.BaseFlowable
import com.splendo.kaluga.flow.FlowConfig
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlin.coroutines.CoroutineContext

/**
 * State to be represented in a state machine
 *
 */
open class State {

    /**
     * Called when this state is the first state of the state machine
     */
    open suspend fun initialState() {}

    /**
     * Called while transitioning to a new state before the new state is created
     */
    open suspend fun beforeCreatingNewState() {}
    /**
     * Called while transitioning to a new state after the new state is created
     *
     * @param newState the newly created state
     */
    open suspend fun afterCreatingNewState(newState:State) {}

    /**
     * Called while transitioning to a new state after the new state is set.
     */
    open suspend fun afterNewStateIsSet() {}

    /**
     * Called while transitioning from an old state before it is removed.
     */
    open suspend fun beforeOldStateIsRemoved() {}

    /**
     * Called while transitioning from an old state after it is removed
     *
     * @param oldState the removed state
     */
    open suspend fun afterOldStateIsRemoved(oldState:State) {}

    /**
     * Called when this state is the final state of the state machine
     */
    open suspend fun finalState() {}
}

/**
 * The state repo can change holds the current [State] (which can be accessed as a flow), and can be used to change the current state
 *
 * @param T the [State] represented by this repo.
 * @param coroutineContext the [CoroutineContext] used to create a coroutine scope for this state machine.
 */
abstract class StateRepo<T:State>(coroutineContext: CoroutineContext = MainQueueDispatcher) : CoroutineScope by CoroutineScope(coroutineContext + CoroutineName("State Repo")) {

    abstract val flowable: Lazy<BaseFlowable<T>>

    @Suppress("LeakingThis") // we are using this method so we can hold an initial state that holds this repo as a reference.
    internal lateinit var changedState:T
    private suspend fun setChangedState(value: T) {
        changedState = value
        flowable.value.set(value)
    }

    /**
     * Provides a [Flow] of the [State] of this repo.
     *
     * @param flowConfig the [FlowConfig] to apply to the returned [Flow]
     * @return a [Flow] of the [State] of this repo
     */
    fun flow(flowConfig: FlowConfig = FlowConfig.Conflate): Flow<T> {
        return flowable.value.flow(flowConfig)
    }

    internal fun initialize() : T {
        val value = initialValue()
        changedState = value
        launch {
            value.initialState()
        }
        return value
    }

    /**
     * Gets the initial value of the repo
     * @return the initial value of the repo
     */
    abstract fun initialValue() : T

    internal fun state():T {
        return changedState
    }

    /**
     * Peek the current state of the state machine. The current state could change immediately after it is returned.
     *
     * If any actions are taken based on the current state that affect the state machine you should not use this method.
     *
     * If your code relies on the state not changing use [useState].
     * If you want to change the state based on the current state use [takeAndChangeState]
     *
     * @return the current [State] of the [StateRepo]
     */
    fun peekState() = state()

    // TODO: when Kotlin coroutinesx will include readwrite locks multiple useState blocks could run at the same time
    private val stateMutex = Mutex()

    /**
     * Makes the current [State] available in [action]. The state is guaranteed not to change during the execution of [action] .
     *
     * @param action the function for determining which [State] to transition to.
     */
     suspend fun useState(action:suspend (State:T) -> Unit) {
        try {
            stateMutex.withLock(this) {
                coroutineScope {
                    launch {
                        action(state())
                    }
                }
            }
        } catch (e:IllegalStateException) {
            throw IllegalStateException("Seems like you tried to change to a new a state while are inside a code block requesting the state to not change (see [useState]) ")
        }
    }

    /**
     * Changes from the current [State] to a new [State].
     *
     * Note you should use the [State] supplied to action as the current [State], if you previously
     *
     * @param action the function for determining which [State] to transition to from the current [State]
     */
    suspend fun takeAndChangeState(action: suspend (state:T) -> T):T {

        try {
            stateMutex.withLock(this) {
                val result = CompletableDeferred<T>()
                coroutineScope {
                    launch {
                        val beforeState = state()
                        beforeState.beforeCreatingNewState()
                        val newState = action(beforeState)
                        beforeState.afterCreatingNewState(newState)
                        newState.beforeOldStateIsRemoved()
                        setChangedState(newState)
                        beforeState.afterNewStateIsSet()
                        newState.afterOldStateIsRemoved(beforeState)
                        result.complete(newState)
                    }
                }
                return result.await()
            }
        } catch (e:IllegalStateException) {
            throw IllegalStateException("Seems like you tried to change to a new a state while you were still in the process of changing to the current state (see [useAndChangeState])")
        }
    }
}

/**
 * A [StateRepo] that represents its [State] as a Hot flow.
 */
abstract class HotStateRepo<T:State>(coroutineContext: CoroutineContext = MainQueueDispatcher) : StateRepo<T>(coroutineContext) {

    override val flowable = lazy {
        HotFlowable(initialize())
    }

}

/**
 * A [StateRepo] that represents its [State] as a Cold flow. Data will only be set when the State repo is observed
 */
abstract class ColdStateRepo<T:State>(coroutineContext: CoroutineContext = MainQueueDispatcher) : StateRepo<T>(coroutineContext) {

    override val flowable = lazy {
        ColdFlowable({
            initialize()
        }, {
            state ->
            launch {
                state.finalState()
            }
            this.deinitialize(state)
        })
    }

    abstract fun deinitialize(state: T)

}