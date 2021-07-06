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

package com.splendo.kaluga.permissions.contacts

import com.splendo.kaluga.basepermissions.BasePermissionsBuilder
import com.splendo.kaluga.basepermissions.PermissionManager
import com.splendo.kaluga.basepermissions.PermissionStateRepo
import com.splendo.kaluga.permissions.ContactsPermission
import kotlin.coroutines.CoroutineContext

/**
 * A [PermissionManager] for managing [Permission.Contacts]
 */
expect class ContactsPermissionManager : PermissionManager<ContactsPermission> {
    /**
     * The [Permission.Contacts] managed by this manager
     */
    val contacts: ContactsPermission
}

interface BaseContactsPermissionManagerBuilder: BasePermissionsBuilder {

    /**
     * Creates a [ContactsPermissionManager]
     * @param repo The [ContactsPermissionStateRepo] associated with the [Permission.Contacts]
     */
    fun create(contacts: ContactsPermission, repo: ContactsPermissionStateRepo): PermissionManager<ContactsPermission>
}

/**
 * A builder for creating a [ContactsPermissionManager]
 */
expect class ContactsPermissionManagerBuilder : BaseContactsPermissionManagerBuilder

/**
 * A [PermissionStateRepo] for [Permission.Contacts]
 * @param builder The [ContactsPermissionManagerBuilder] for creating the [ContactsPermissionManager] associated with the permission
 * @param coroutineContext The [CoroutineContext] to run the state machine on.
 */
class ContactsPermissionStateRepo(contacts: ContactsPermission, builder: BaseContactsPermissionManagerBuilder, coroutineContext: CoroutineContext) : PermissionStateRepo<ContactsPermission>(coroutineContext = coroutineContext) {

    override val permissionManager: PermissionManager<ContactsPermission> = builder.create(contacts, this)
}
