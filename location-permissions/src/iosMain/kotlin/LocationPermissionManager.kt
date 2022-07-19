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

package com.splendo.kaluga.permissions.location

import com.splendo.kaluga.base.IOSVersion
import com.splendo.kaluga.permissions.base.AuthorizationStatusHandler
import com.splendo.kaluga.permissions.base.DefaultAuthorizationStatusHandler
import com.splendo.kaluga.permissions.base.BasePermissionManager
import com.splendo.kaluga.permissions.base.IOSPermissionsHelper
import com.splendo.kaluga.permissions.base.PermissionContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import platform.CoreLocation.CLAccuracyAuthorization
import platform.CoreLocation.CLAuthorizationStatus
import platform.CoreLocation.CLLocationManager
import platform.CoreLocation.CLLocationManagerDelegateProtocol
import platform.CoreLocation.kCLAuthorizationStatusAuthorizedAlways
import platform.CoreLocation.kCLAuthorizationStatusAuthorizedWhenInUse
import platform.CoreLocation.kCLAuthorizationStatusDenied
import platform.CoreLocation.kCLAuthorizationStatusNotDetermined
import platform.CoreLocation.kCLAuthorizationStatusRestricted
import platform.CoreLocation.kCLLocationAccuracyBest
import platform.CoreLocation.kCLLocationAccuracyReduced
import platform.Foundation.NSBundle
import platform.darwin.NSObject
import kotlin.time.Duration

const val NSLocationWhenInUseUsageDescription = "NSLocationWhenInUseUsageDescription"
const val NSLocationAlwaysAndWhenInUseUsageDescription = "NSLocationAlwaysAndWhenInUseUsageDescription"
const val NSLocationAlwaysUsageDescription = "NSLocationAlwaysUsageDescription"

actual class DefaultLocationPermissionManager(
    private val bundle: NSBundle,
    locationPermission: LocationPermission,
    settings: Settings,
    coroutineScope: CoroutineScope
) : BasePermissionManager<LocationPermission>(locationPermission, settings, coroutineScope) {

    private class Delegate(private val locationPermission: LocationPermission, private val onPermissionChanged: AuthorizationStatusHandler, private val coroutineScope: CoroutineScope) : NSObject(), CLLocationManagerDelegateProtocol {
        override fun locationManagerDidChangeAuthorization(manager: CLLocationManager) {
            onPermissionChanged.status(manager.authorizationStatus(locationPermission))
        }
        override fun locationManager(manager: CLLocationManager, didChangeAuthorizationStatus: CLAuthorizationStatus /* = kotlin.Int */) {
            onPermissionChanged.status(manager.authorizationStatus(locationPermission))
        }
    }

    private val permissionHandler = DefaultAuthorizationStatusHandler(eventChannel, logTag, logger)
    private val locationManager = MainCLLocationManagerAccessor {
        desiredAccuracy = if (permission.precise) kCLLocationAccuracyBest else kCLLocationAccuracyReduced
    }

    private val authorizationDelegate = Delegate(permission, permissionHandler, coroutineScope)

    override fun requestPermissionDidStart() {
        val locationDeclarations = mutableListOf(NSLocationWhenInUseUsageDescription)
        if (permission.background) {
            locationDeclarations.addAll(listOf(NSLocationAlwaysAndWhenInUseUsageDescription, NSLocationAlwaysUsageDescription))
        }
        if (IOSPermissionsHelper.missingDeclarationsInPList(bundle, *locationDeclarations.toTypedArray()).isEmpty()) {
            launch {
                locationManager.updateLocationManager {
                    if (permission.background)
                        requestAlwaysAuthorization()
                    else
                        requestWhenInUseAuthorization()
                }
            }
        } else {
            permissionHandler.status(IOSPermissionsHelper.AuthorizationStatus.Restricted)
        }
    }

    override fun monitoringDidStart(interval: Duration) {
        val permission = permission
        launch {
            val status = locationManager.updateLocationManager {
                delegate = authorizationDelegate
                authorizationStatus(permission)
            }
            permissionHandler.status(status)
        }
    }

    override fun monitoringDidStop() {
        launch {
            locationManager.updateLocationManager {
                delegate = null
            }
        }
    }
}

actual class LocationPermissionManagerBuilder actual constructor(private val context: PermissionContext) : BaseLocationPermissionManagerBuilder {

    override fun create(locationPermission: LocationPermission, settings: BasePermissionManager.Settings, coroutineScope: CoroutineScope): LocationPermissionManager {
        return DefaultLocationPermissionManager(context, locationPermission, settings, coroutineScope)
    }
}

private fun Pair<CLAuthorizationStatus, Boolean>.toAuthorizationStatus(permission: LocationPermission): IOSPermissionsHelper.AuthorizationStatus {
    return when (first) {
        kCLAuthorizationStatusNotDetermined -> IOSPermissionsHelper.AuthorizationStatus.NotDetermined
        kCLAuthorizationStatusRestricted -> IOSPermissionsHelper.AuthorizationStatus.Restricted
        kCLAuthorizationStatusDenied -> IOSPermissionsHelper.AuthorizationStatus.Denied
        kCLAuthorizationStatusAuthorizedAlways -> if (permission.precise && !second) IOSPermissionsHelper.AuthorizationStatus.Denied else IOSPermissionsHelper.AuthorizationStatus.Authorized
        kCLAuthorizationStatusAuthorizedWhenInUse -> if (permission.background || (permission.precise && !second)) IOSPermissionsHelper.AuthorizationStatus.Denied else IOSPermissionsHelper.AuthorizationStatus.Authorized
        else -> {
            com.splendo.kaluga.logging.error("Unknown CLAuthorizationStatus $first")
            IOSPermissionsHelper.AuthorizationStatus.Denied
        }
    }
}

fun CLLocationManager.authorizationStatus(locationPermission: LocationPermission): IOSPermissionsHelper.AuthorizationStatus = if (IOSVersion.systemVersion > IOSVersion(13)) {
    authorizationStatus to (accuracyAuthorization == CLAccuracyAuthorization.CLAccuracyAuthorizationFullAccuracy)
} else {
    CLLocationManager.authorizationStatus() to true
}.toAuthorizationStatus(locationPermission)
