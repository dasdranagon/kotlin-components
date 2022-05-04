/*
 Copyright 2021 Splendo Consulting B.V. The Netherlands

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

package com.splendo.kaluga.test.mock.resources

import android.graphics.drawable.ColorDrawable
import com.splendo.kaluga.resources.Font
import com.splendo.kaluga.resources.Image
import com.splendo.kaluga.resources.KalugaColor
import org.mockito.Mockito

actual fun mockColor(): KalugaColor = 0
actual fun mockImage(): Image = Image(ColorDrawable(0))
actual fun mockFont(): Font = Font.DEFAULT ?: Mockito.mock(Font::class.java)
