/*
 Copyright 2023 Splendo Consulting B.V. The Netherlands

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

package com.splendo.kaluga.media

import platform.AVFoundation.AVAsset
import platform.Foundation.NSURL

actual sealed class MediaSource {
    data class Asset(val asset: AVAsset) : MediaSource()
    data class URL(val url: NSURL) : MediaSource()
}

actual fun mediaSourceFromUrl(url: String): MediaSource? = NSURL.URLWithString(url)?.let { MediaSource.URL(it) }