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

package com.splendo.kaluga.permissions

import com.splendo.kaluga.base.runBlocking
import com.splendo.kaluga.test.BaseTest
import com.splendo.kaluga.utils.EmptyCompletableDeferred
import com.splendo.kaluga.utils.complete
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.delay

class PermissionRefreshSchedulerTest : BaseTest() {

    private lateinit var permissionsManager: MockStoragePermissionManager

    @BeforeTest
    fun setUp() {
        super.beforeTest()

        val repo = MockStoragePermissionStateRepo()
        permissionsManager = repo.permissionManager
    }

    @AfterTest
    fun tearDown() {
        super.afterTest()
    }

    @Test
    fun testStartMonitoring() = runBlocking {
        var authorization: IOSPermissionsHelper.AuthorizationStatus = IOSPermissionsHelper.AuthorizationStatus.NotDetermined
        val timerHelper = PermissionRefreshScheduler(permissionsManager, { authorization }, this)

        timerHelper.startMonitoring(50)
        delay(50)
        assertFalse(permissionsManager.didGrantPermission.isCompleted)
        assertFalse(permissionsManager.didRevokePermission.isCompleted)

        authorization = IOSPermissionsHelper.AuthorizationStatus.Authorized
        permissionsManager.reset()
        delay(60)
        assertTrue(permissionsManager.didGrantPermission.isCompleted)

        timerHelper.isWaiting = true
        authorization = IOSPermissionsHelper.AuthorizationStatus.Denied
        permissionsManager.reset()
        delay(60)
        assertFalse(permissionsManager.didGrantPermission.isCompleted)
        assertFalse(permissionsManager.didRevokePermission.isCompleted)

        timerHelper.isWaiting = false
        delay(50)
        assertTrue(permissionsManager.didRevokePermission.await())

        authorization = IOSPermissionsHelper.AuthorizationStatus.Authorized
        permissionsManager.reset()
        timerHelper.stopMonitoring()
        delay(50)
        assertFalse(permissionsManager.didGrantPermission.isCompleted)
        assertFalse(permissionsManager.didRevokePermission.isCompleted)
        Unit
    }
}

private class MockStoragePermissionStateRepo : PermissionStateRepo<Permission.Storage>() {

    override val permissionManager = MockStoragePermissionManager(this)
}

private class MockStoragePermissionManager(mockPermissionRepo: MockStoragePermissionStateRepo) : PermissionManager<Permission.Storage>(mockPermissionRepo) {

    var didGrantPermission: EmptyCompletableDeferred
    var didRevokePermission: CompletableDeferred<Boolean>

    init {
        didGrantPermission = EmptyCompletableDeferred()
        didRevokePermission = CompletableDeferred()
    }

    var initialState: PermissionState<Permission.Storage> = PermissionState.Denied.Requestable(this)

    val hasRequestedPermission = EmptyCompletableDeferred()
    val hasStartedMonitoring = CompletableDeferred<Long>()
    val hasStoppedMonitoring = EmptyCompletableDeferred()

    override suspend fun requestPermission() {
        hasRequestedPermission.complete()
    }

    override suspend fun initializeState(): PermissionState<Permission.Storage> {
        return initialState
    }

    override suspend fun startMonitoring(interval: Long) {
        hasStartedMonitoring.complete(interval)
    }

    override suspend fun stopMonitoring() {
        hasStoppedMonitoring.complete()
    }

    override fun grantPermission() {
        didGrantPermission.complete()
    }

    override fun revokePermission(locked: Boolean) {
        didRevokePermission.complete(locked)
    }

    fun reset() {
        didGrantPermission = EmptyCompletableDeferred()
        didRevokePermission = CompletableDeferred()
    }
}
