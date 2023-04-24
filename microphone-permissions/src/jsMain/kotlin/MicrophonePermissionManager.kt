/*
 Copyright (c) 2020. Splendo Consulting B.V. The Netherlands

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

package com.splendo.kaluga.permissions.microphone

import com.splendo.kaluga.permissions.base.BasePermissionManager
import com.splendo.kaluga.permissions.base.BasePermissionManager.Settings
import com.splendo.kaluga.permissions.base.PermissionContext
import com.splendo.kaluga.permissions.base.PermissionManager
import kotlinx.coroutines.CoroutineScope
import kotlin.time.Duration

/**
 * The [BasePermissionManager] to use as a default for [MicrophonePermission]
 * @param settings the [Settings] to apply to this manager.
 * @param coroutineScope the [CoroutineScope] of this manager.
 */
actual class DefaultMicrophonePermissionManager(
    settings: Settings,
    coroutineScope: CoroutineScope,
) : BasePermissionManager<MicrophonePermission>(MicrophonePermission, settings, coroutineScope) {

    override fun requestPermissionDidStart() {
        TODO("Not yet implemented")
    }

    override fun monitoringDidStart(interval: Duration) {
        TODO("Not yet implemented")
    }

    override fun monitoringDidStop() {
        TODO("Not yet implemented")
    }
}

/**
 * A [BaseMicrophonePermissionManagerBuilder]
 * @param context the [PermissionContext] this permissions manager builder runs on
 */
actual class MicrophonePermissionManagerBuilder actual constructor(context: PermissionContext) : BaseMicrophonePermissionManagerBuilder {

    override fun create(settings: Settings, coroutineScope: CoroutineScope): PermissionManager<MicrophonePermission> {
        return DefaultMicrophonePermissionManager(settings, coroutineScope)
    }
}
