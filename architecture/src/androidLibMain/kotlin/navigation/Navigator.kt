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

package com.splendo.kaluga.architecture.navigation

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import android.provider.Settings
import androidx.fragment.app.FragmentManager

/**
 * Implementation of [Navigator]. Takes a mapper function to map all [NavigationAction] to a [NavigationSpec]
 * Whenever [navigate] is called, this class maps it to a [NavigationSpec] and performs navigation according to that
 * Requires to be subscribed to an activity via [subscribe] to work
 * @param navigationMapper A function mapping the [NavigationAction] to [NavigationSpec]
 */
actual class Navigator<A : NavigationAction<*>>(private val navigationMapper: (A) -> NavigationSpec) {

    private var activity: Activity? = null
    private var fragmentManager: FragmentManager? = null

    /**
     * Subscribes the Navigator to a [Activity] and [FragmentManager]
     * Subscription is used to determine which activity/fragmentManager is responsible for certain navigating actions
     * @param activity The [Activity] to handle navigation
     * @param fragmentManager The [FragmentManager] to handle fragment navigation
     */
    fun subscribe(activity: Activity, fragmentManager: FragmentManager) {
        this.activity = activity
        this.fragmentManager = fragmentManager
    }

    /**
     * Unsubscribes the Navigator from its current [Activity] and [FragmentManager]
     */
    fun unsubscribe() {
        activity = null
        fragmentManager = null
    }

    actual fun navigate(action: A) {
        navigate(navigationMapper.invoke(action), action.bundle)
    }

    private fun navigate(spec: NavigationSpec, bundle: NavigationBundle<*>?) {
        when (spec) {
            is NavigationSpec.Activity<*> -> navigateToActivity(spec, bundle)
            is NavigationSpec.Close -> closeActivity(spec, bundle)
            is NavigationSpec.Fragment -> navigateToFragment(spec)
            is NavigationSpec.Dialog -> navigateToDialog(spec)
            is NavigationSpec.Camera -> navigateToCamera(spec)
            is NavigationSpec.Email -> navigateToEmail(spec)
            is NavigationSpec.FileSelector -> navigateToFileSelector(spec)
            is NavigationSpec.Phone -> navigateToPhone(spec)
            is NavigationSpec.Settings -> navigateToSettings(spec)
            is NavigationSpec.TextMessenger -> navigateToMessenger(spec)
            is NavigationSpec.Browser -> navigateToBrowser(spec)
        }
    }

    private fun navigateToActivity(activitySpec: NavigationSpec.Activity<*>, bundle: NavigationBundle<*>?) {
        assert(this.activity != null)
        val activity = this.activity ?: return
        val intent = Intent(activity, activitySpec.activityClass).apply {
            bundle?.let {
                putExtras(it.toBundle())
            }
            flags = activitySpec.flags.toFlags()
        }
        activitySpec.requestCode?.let {
            activity.startActivityForResult(intent, it)
        } ?: activity.startActivity(intent)
    }

    private fun closeActivity(closeSpec: NavigationSpec.Close, bundle: NavigationBundle<*>?) {
        assert(this.activity != null)
        val activity = this.activity ?: return
        closeSpec.result?.let { resultCode ->
            val data = Intent().apply {
                bundle?.let {
                    putExtras(it.toBundle())
                }
            }
            activity.setResult(resultCode, data)
        }
        activity.finish()
    }

    private fun navigateToFragment(fragmentSpec: NavigationSpec.Fragment) {
        assert(this.fragmentManager != null)
        val fragmentManager = fragmentManager ?: return
        val transaction = fragmentManager.beginTransaction()

        when (val backtrackSettings = fragmentSpec.backStackSettings) {
            is NavigationSpec.Fragment.BackStackSettings.Add -> transaction.addToBackStack(backtrackSettings.name)
        }

        fragmentSpec.animationSettings?.let { animationSettings ->
            transaction.setCustomAnimations(animationSettings.enter, animationSettings.exit, animationSettings.popEnter, animationSettings.popExit)
        }

        val fragment = fragmentSpec.createFragment()
        when (fragmentSpec.type) {
            is NavigationSpec.Fragment.Type.Add -> transaction.add(fragmentSpec.containerId, fragment, fragmentSpec.tag)
            is NavigationSpec.Fragment.Type.Replace -> transaction.replace(fragmentSpec.containerId, fragment, fragmentSpec.tag)
        }

        transaction.commit()
    }

    private fun navigateToDialog(dialogSpec: NavigationSpec.Dialog) {
        assert(this.fragmentManager != null)
        val fragmentManager = fragmentManager ?: return
        dialogSpec.createDialog().show(fragmentManager, dialogSpec.tag)
    }

    private fun navigateToCamera(cameraSpec: NavigationSpec.Camera) {
        assert(this.activity != null)
        val activity = this.activity ?: return
        val intent = when (cameraSpec.type) {
            is NavigationSpec.Camera.Type.Image -> Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            is NavigationSpec.Camera.Type.Video -> Intent(MediaStore.ACTION_VIDEO_CAPTURE)
        }

        cameraSpec.uri?.let { uri ->
            intent.putExtra(MediaStore.EXTRA_OUTPUT, uri)
        }

        intent.resolveActivity(activity.packageManager)?.let {
            activity.startActivityForResult(intent, cameraSpec.requestCode)
        }
    }

    private fun navigateToEmail(emailSpec: NavigationSpec.Email) {
        assert(this.activity != null)
        val activity = this.activity ?: return
        val settings = emailSpec.emailSettings
        val intent = when (settings.attachments.size) {
            0 -> Intent(Intent.ACTION_SEND)
            1 -> Intent(Intent.ACTION_SEND).apply { putExtra(Intent.EXTRA_STREAM, settings.attachments[0]) }
            else -> Intent(Intent.ACTION_SEND_MULTIPLE).apply { putExtra(Intent.EXTRA_STREAM, ArrayList(settings.attachments)) }
        }.apply {
            data = Uri.parse("mailto:")
            type = when (settings.type) {
                is NavigationSpec.Email.Type.Plain -> "text/plain"
                is NavigationSpec.Email.Type.Stylized -> "*/*"
            }
            if (settings.to.isNotEmpty()) {
                putExtra(Intent.EXTRA_EMAIL, settings.to.toTypedArray())
            }
            if (settings.cc.isNotEmpty()) {
                putExtra(Intent.EXTRA_CC, settings.cc.toTypedArray())
            }
            if (settings.bcc.isNotEmpty()) {
                putExtra(Intent.EXTRA_BCC, settings.bcc.toTypedArray())
            }
            settings.subject?.let { putExtra(Intent.EXTRA_SUBJECT, it) }
            settings.body?.let { putExtra(Intent.EXTRA_TEXT, it) }
        }

        intent.resolveActivity(activity.packageManager)?.let {
            activity.startActivity(intent)
        }
    }

    private fun navigateToFileSelector(fileSelectorSpec: NavigationSpec.FileSelector) {
        assert(this.activity != null)
        val activity = this.activity ?: return
        val settings = fileSelectorSpec.fileSelectorSettings
        val intent = Intent(Intent.ACTION_GET_CONTENT).apply {
            type = settings.type
            putExtra(Intent.EXTRA_ALLOW_MULTIPLE, settings.allowMultiple)
            putExtra(Intent.EXTRA_LOCAL_ONLY, settings.localOnly)
        }

        intent.resolveActivity(activity.packageManager)?.let {
            activity.startActivityForResult(intent, fileSelectorSpec.requestCode)
        }
    }

    private fun navigateToPhone(phoneSpec: NavigationSpec.Phone) {
        assert(this.activity != null)
        val activity = this.activity ?: return

        val intent = when (phoneSpec.type) {
            is NavigationSpec.Phone.Type.Dial -> Intent(Intent.ACTION_DIAL)
            is NavigationSpec.Phone.Type.Call -> Intent(Intent.ACTION_CALL)
        }.apply {
            data = Uri.parse("tel:${phoneSpec.phoneNumber}")
        }

        intent.resolveActivity(activity.packageManager)?.let {
            activity.startActivity(intent)
        }
    }

    private fun navigateToSettings(settingsSpec: NavigationSpec.Settings) {
        assert(this.activity != null)
        val activity = this.activity ?: return
        val intent = when (settingsSpec.type) {
            is NavigationSpec.Settings.Type.General -> Intent(Settings.ACTION_SETTINGS)
            is NavigationSpec.Settings.Type.Wireless -> Intent(Settings.ACTION_WIRELESS_SETTINGS)
            is NavigationSpec.Settings.Type.AirplaneMode -> Intent(Settings.ACTION_AIRPLANE_MODE_SETTINGS)
            is NavigationSpec.Settings.Type.Wifi -> Intent(Settings.ACTION_WIFI_SETTINGS)
            is NavigationSpec.Settings.Type.Apn -> Intent(Settings.ACTION_APN_SETTINGS)
            is NavigationSpec.Settings.Type.Bluetooth -> Intent(Settings.ACTION_BLUETOOTH_SETTINGS)
            is NavigationSpec.Settings.Type.Date -> Intent(Settings.ACTION_DATE_SETTINGS)
            is NavigationSpec.Settings.Type.Locale -> Intent(Settings.ACTION_LOCALE_SETTINGS)
            is NavigationSpec.Settings.Type.InputMethod -> Intent(Settings.ACTION_INPUT_METHOD_SETTINGS)
            is NavigationSpec.Settings.Type.Display -> Intent(Settings.ACTION_DISPLAY_SETTINGS)
            is NavigationSpec.Settings.Type.Security -> Intent(Settings.ACTION_SECURITY_SETTINGS)
            is NavigationSpec.Settings.Type.LocationSource -> Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
            is NavigationSpec.Settings.Type.InternalStorage -> Intent(Settings.ACTION_INTERNAL_STORAGE_SETTINGS)
            is NavigationSpec.Settings.Type.MemoryCard -> Intent(Settings.ACTION_MEMORY_CARD_SETTINGS)
        }

        intent.resolveActivity(activity.packageManager)?.let {
            activity.startActivity(intent)
        }
    }

    private fun navigateToMessenger(messengerSpec: NavigationSpec.TextMessenger) {
        assert(this.activity != null)
        val activity = this.activity ?: return
        val settings = messengerSpec.settings
        val intent = when (settings.attachments.size) {
            0 -> Intent(Intent.ACTION_SEND)
            1 -> Intent(Intent.ACTION_SEND).apply { putExtra(Intent.EXTRA_STREAM, settings.attachments[0]) }
            else -> Intent(Intent.ACTION_SEND_MULTIPLE).apply { putExtra(Intent.EXTRA_STREAM, ArrayList(settings.attachments)) }
        }.apply {
            val recipients = settings.recipients.fold("") { acc, recipient -> if (acc.isNotEmpty()) "$acc;$recipient" else recipient }
            data = Uri.parse("smsto:$recipients")
            type = when (settings.type) {
                is NavigationSpec.TextMessenger.Type.Plain -> "text/plain"
                is NavigationSpec.TextMessenger.Type.Image -> "image/*"
                is NavigationSpec.TextMessenger.Type.Video -> "video/*"
            }
            settings.subject?.let { putExtra("subject", it) }
            settings.body?.let { putExtra("sms_body", it) }
        }

        intent.resolveActivity(activity.packageManager)?.let {
            activity.startActivity(intent)
        }
    }

    private fun navigateToBrowser(browserSpec: NavigationSpec.Browser) {
        assert(this.activity != null)
        val activity = this.activity ?: return
        val uri = Uri.parse(browserSpec.url.toURI().toString())
        val intent = Intent(Intent.ACTION_VIEW, uri)

        intent.resolveActivity(activity.packageManager)?.let {
            activity.startActivity(intent)
        }
    }
}
