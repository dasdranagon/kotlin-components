package com.splendo.kaluga.hud

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

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

class HUDTests {

    class MockHUD(val style: HUD.Style, val title: String?) : HUD {
        lateinit var onPresentCalled: () -> Unit
        lateinit var onDismissCalled: () -> Unit

        override val isVisible: Boolean = false
        override fun present(animated: Boolean, completion: () -> Unit): HUD {
            onPresentCalled()
            return this
        }

        override fun dismiss(animated: Boolean, completion: () -> Unit) {
            onDismissCalled()
        }

        override fun dismissAfter(timeMillis: Long, animated: Boolean) = apply {
            onDismissCalled()
        }
    }

    class MockBuilder : HUD.Builder() {
        override fun create(hudConfig: HudConfig) = MockHUD(hudConfig.style, hudConfig.title)
    }

    @Test
    fun testBuilder() {
        val builder = MockBuilder()
        val hud1 = builder.build() as MockHUD
        assertEquals(hud1.style, HUD.Style.SYSTEM)
        assertNull(hud1.title)
        val hud2 = builder.build {
            setStyle(HUD.Style.CUSTOM)
            setTitle("Title")
        } as MockHUD
        assertEquals(hud2.style, HUD.Style.CUSTOM)
        assertEquals(hud2.title, "Title")
    }
}
