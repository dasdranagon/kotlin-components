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
@file:JvmName("JvmFont")
package com.splendo.kaluga.resources

actual class Font

actual val defaultFont: Font get() = Font()
actual val defaultBoldFont: Font get() = Font()
actual val defaultItalicFont: Font get() = Font()
actual val defaultMonospaceFont: Font get() = Font()
