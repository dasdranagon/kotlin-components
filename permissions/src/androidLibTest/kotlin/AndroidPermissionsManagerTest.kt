import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import com.splendo.kaluga.base.runBlocking
import com.splendo.kaluga.permissions.AndroidPermissionsManager
import com.splendo.kaluga.permissions.Permission
import com.splendo.kaluga.permissions.PermissionManager
import com.splendo.kaluga.test.BaseTest
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.assertEquals
import kotlin.test.assertTrue

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

class AndroidPermissionsManagerTest : BaseTest() {

    companion object {
        private const val packageName = "package"
        private val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
    }

    @Mock
    lateinit var context: Context
    @Mock
    lateinit var packageManager: PackageManager
    @Mock
    lateinit var packageInfo: PackageInfo

    @Mock
    lateinit var permissionsManager: PermissionManager<Permission.Storage>
    private lateinit var androidPermissionsManager: AndroidPermissionsManager<Permission.Storage>

    @BeforeTest
    fun setUp() {
        super.beforeTest()
        MockitoAnnotations.initMocks(this)

        `when`(context.packageManager).thenReturn(packageManager)
        `when`(context.packageName).thenReturn(packageName)
        `when`(packageManager.getPackageInfo(eq(packageName), eq(PackageManager.GET_PERMISSIONS))).thenReturn(packageInfo)
    }

    @AfterTest
    fun tearDown() {
        super.afterTest()
    }

    @Test
    fun testMissingDeclaration() = runBlockingTest {
        androidPermissionsManager = AndroidPermissionsManager(context, permissionsManager, permissions, this)
        packageInfo.requestedPermissions = emptyArray()
        androidPermissionsManager.requestPermissions()

        verify(permissionsManager).revokePermission(eq(true))
    }

    @Test
    fun testRequestPermissions() = runBlockingTest {
        androidPermissionsManager = AndroidPermissionsManager(context, permissionsManager, permissions, this)
        packageInfo.requestedPermissions = permissions
        androidPermissionsManager.requestPermissions()

        assertTrue(AndroidPermissionsManager.waitingPermissions.containsAll(permissions.toList()))
        verify(context).startActivity(ArgumentMatchers.any(Intent::class.java))
    }

    @Test
    fun testStartMonitoring() = runBlocking {
        androidPermissionsManager = AndroidPermissionsManager(context, permissionsManager, permissions, this)
        packageInfo.requestedPermissions = permissions
        permissions.forEach {
            `when`(context.checkPermission(eq(it), ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt())).thenReturn(PackageManager.PERMISSION_DENIED)
        }

        androidPermissionsManager.startMonitoring(50)
        permissions.forEach {
            assertEquals(PackageManager.PERMISSION_DENIED, AndroidPermissionsManager.lastPermission[it])
        }
        delay(50)
        verify(permissionsManager, never()).grantPermission()
        verify(permissionsManager, never()).revokePermission(ArgumentMatchers.anyBoolean())

        permissions.forEach {
            `when`(context.checkPermission(eq(it), ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt())).thenReturn(PackageManager.PERMISSION_GRANTED)
        }
        reset(permissionsManager)
        delay(50)
        verify(permissionsManager).grantPermission()

        permissions.forEach {
            AndroidPermissionsManager.waitingPermissions.add(it)
            `when`(context.checkPermission(eq(it), ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt())).thenReturn(PackageManager.PERMISSION_DENIED)
        }
        reset(permissionsManager)
        delay(50)
        verify(permissionsManager, never()).grantPermission()
        verify(permissionsManager, never()).revokePermission(ArgumentMatchers.anyBoolean())

        permissions.forEach {
            AndroidPermissionsManager.waitingPermissions.remove(it)
        }
        delay(50)
        verify(permissionsManager).revokePermission(true)

        permissions.forEach {
            `when`(context.checkPermission(eq(it), ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt())).thenReturn(PackageManager.PERMISSION_GRANTED)
        }
        reset(permissionsManager)
        androidPermissionsManager.stopMonitoring()
        delay(50)
        verify(permissionsManager, never()).grantPermission()
        verify(permissionsManager, never()).revokePermission(ArgumentMatchers.anyBoolean())
    }

}