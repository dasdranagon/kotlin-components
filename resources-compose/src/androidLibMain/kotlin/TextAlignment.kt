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

package com.splendo.kaluga.resources.compose

import androidx.compose.ui.text.style.TextAlign
import com.splendo.kaluga.resources.stylable.TextAlignment

val TextAlignment.composable: TextAlign
    get() = when (this) {
        TextAlignment.CENTER -> TextAlign.Center
        TextAlignment.LEFT -> TextAlign.Left
        TextAlignment.START -> TextAlign.Start
        TextAlignment.END -> TextAlign.End
        TextAlignment.RIGHT -> TextAlign.Right
    }
