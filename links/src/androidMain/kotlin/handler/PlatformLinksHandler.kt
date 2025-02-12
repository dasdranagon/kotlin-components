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

package com.splendo.kaluga.links.handler

import android.net.Uri
import android.webkit.URLUtil

/**
 * Android implementation of [LinksHandler]
 */
actual class PlatformLinksHandler : LinksHandler {
    actual override fun isValid(url: String): Boolean = URLUtil.isValidUrl(url)

    actual override fun extractQueryAsMap(url: String): Map<String, List<String>> = with(Uri.parse(url)) {
        queryParameterNames.associateWith { getQueryParameters(it) }
    }
}
