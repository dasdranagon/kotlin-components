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

package com.splendo.kaluga.permissions.notifications

import com.splendo.kaluga.permissions.Permission
import com.splendo.kaluga.permissions.PermissionManager
import com.splendo.kaluga.permissions.PermissionStateRepo

/**
 * Options for configuring a [Permission.Notifications]
 */
expect class NotificationOptions

/**
 * A [PermissionManager] for managing [Permission.Notifications]
 */
expect class NotificationsPermissionManager : PermissionManager<Permission.Notifications> {
    /**
     * The [Permission.Notifications] managed by this manager.
     */
    val notifications: Permission.Notifications
}

/**
 * A builder for creating a [NotificationsPermissionManager]
 */
expect class NotificationsPermissionManagerBuilder {
    /**
     * Creates a [NotificationsPermissionManager]
     * @param repo The [NotificationsPermissionStateRepo] associated with the [Permission.Notifications]
     */
    fun create(notifications: Permission.Notifications, repo: NotificationsPermissionStateRepo): NotificationsPermissionManager
}

/**
 * A [PermissionStateRepo] for [Permission.Notifications]
 * @param builder The [NotificationsPermissionManagerBuilder] for creating the [NotificationsPermissionManager] associated with the permission
 */
class NotificationsPermissionStateRepo(notifications: Permission.Notifications, builder: NotificationsPermissionManagerBuilder) : PermissionStateRepo<Permission.Notifications>() {

    override val permissionManager: PermissionManager<Permission.Notifications> = builder.create(notifications, this)
}
