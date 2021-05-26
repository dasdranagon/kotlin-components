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

package com.splendo.kaluga.links.manager

import platform.Foundation.NSURL
import platform.Foundation.NSURLComponents
import platform.Foundation.NSURLConnection
import platform.Foundation.NSURLQueryItem
import platform.Foundation.NSURLRequest

actual class PlatformLinksHandler : LinksHandler {
    override fun isValid(url: String): Boolean {
        val _url = NSURL.URLWithString(url) ?: return false
        return NSURLConnection.canHandleRequest(NSURLRequest.requestWithURL(_url))
    }

    override fun extractQueryAsList(url: String): List<Any> {
        val url = NSURLComponents(url)
        val queryItems = url.queryItems as List<NSURLQueryItem>? ?: return emptyList()

        return queryItems.mapNotNull { it.value }
    }
}
