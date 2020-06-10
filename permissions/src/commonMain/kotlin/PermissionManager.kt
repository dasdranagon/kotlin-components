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

package com.splendo.kaluga.permissions

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * Manager for maintaining the [PermissionState] of a given [Permission]
 * @param stateRepo The [PermissionStateRepo] managed by this manager.
 */
abstract class PermissionManager<P : Permission>internal constructor(private val stateRepo: PermissionStateRepo<P>) : CoroutineScope by stateRepo {

    /**
     * Requests the permission
     */
    abstract suspend fun requestPermission()

    /**
     * Determines the [PermissionState] at which to start.
     */
    abstract suspend fun initializeState(): PermissionState<P>

    /**
     * Starts monitoring for changes to the permission.
     * @param interval The interval in milliseconds between checking for changes to the permission state
     */
    abstract suspend fun startMonitoring(interval: Long)

    /**
     * Stops monitoring for chabges to the permission.
     */
    abstract suspend fun stopMonitoring()

    /**
     * Grants the permission
     * This will bring the [PermissionStateRepo] to [PermissionState.Allowed]
     */
    open fun grantPermission() {
        stateRepo.launch {
            stateRepo.takeAndChangeState { state ->
                when (state) {
                    is PermissionState.Denied -> state.allow
                    is PermissionState.Allowed -> state.remain
                }
            }
        }
    }

    /**
     * Revokes the permission
     * This will bring the [PermissionStateRepo] to [PermissionState.Denied]
     * @param locked `true` if the permission can no longer be requested after this. This corresponds to [PermissionState.Denied.Locked] when `true` and [PermissionState.Denied.Requestable] otherwise.
     */
    open fun revokePermission(locked: Boolean) {
        stateRepo.launch {
            stateRepo.takeAndChangeState { state ->
                when (state) {
                    is PermissionState.Allowed -> suspend { state.deny(locked) }
                    is PermissionState.Denied.Requestable -> {
                        if (locked) state.lock else state.remain
                    }
                    is PermissionState.Denied.Locked -> {
                        if (locked) state.remain else state.unlock
                    }
                }
            }
        }
    }
}
