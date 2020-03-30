package com.splendo.kaluga.hud

import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue
import platform.UIKit.UIScreen
import platform.UIKit.UIViewController
import platform.UIKit.UIWindow

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

class IOSHUDTests {

    private lateinit var window: UIWindow

    @BeforeTest
    fun setUp() {
        window = UIWindow(UIScreen.mainScreen.bounds).apply { makeKeyAndVisible() }
    }

    @Test
    fun builderInitializer() {
        assertNotNull(
            IOSHUD.Builder(UIViewController()).build()
        )
    }

    @Test
    fun builderSetStyleAndTitle() {
        assertNotNull(
            IOSHUD.Builder(UIViewController()).build {
                setStyle(HUD.Style.CUSTOM)
                setTitle("Foo")
            }
        )
    }

    @Test
    fun presentIndicator() {
        val hostView = UIViewController()
        val indicator = IOSHUD.Builder(hostView).build()
        window.rootViewController = hostView
        assertNull(hostView.presentedViewController)
        assertFalse(indicator.isVisible)
        indicator.present(false)
        assertTrue(indicator.isVisible)
    }

    @Test
    fun dismissIndicator() {
        val hostView = UIViewController()
        val indicator = IOSHUD.Builder(hostView).build()
        window.rootViewController = hostView
        assertNull(hostView.presentedViewController)
        assertFalse(indicator.isVisible)
        indicator.present(false) {
            assertTrue(indicator.isVisible)
            indicator.dismiss(false) {
                assertNull(hostView.presentedViewController)
                assertFalse(indicator.isVisible)
            }
        }
    }
}
