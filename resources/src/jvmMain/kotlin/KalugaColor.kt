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

@file:JvmName("JvmKalugaColor")

package com.splendo.kaluga.resources

actual typealias KalugaColor = Int

actual val KalugaColor.red: Double get() = redInt.toDouble() / 255.0
actual val KalugaColor.redInt: Int get() = this shr 16 and 0xFF
actual val KalugaColor.green: Double get() = greenInt.toDouble() / 255.0
actual val KalugaColor.greenInt: Int get() = this shr 8 and 0xFF
actual val KalugaColor.blue: Double get() = blueInt.toDouble() / 255.0
actual val KalugaColor.blueInt: Int get() = this and 0xFF
actual val KalugaColor.alpha: Double get() = alphaInt.toDouble() / 255.0
actual val KalugaColor.alphaInt: Int get() = this ushr 24

actual fun colorFrom(red: Double, green: Double, blue: Double, alpha: Double): KalugaColor {
    return colorFrom((red * 255.0).toInt(), (green * 255.0).toInt(), (blue * 255.0).toInt(), (alpha * 255.0).toInt())
}

actual fun colorFrom(redInt: Int, greenInt: Int, blueInt: Int, alphaInt: Int): KalugaColor = alphaInt shl 24 or (redInt shl 16) or (greenInt shl 8) or blueInt
