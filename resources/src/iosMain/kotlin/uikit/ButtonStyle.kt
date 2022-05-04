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

package com.splendo.kaluga.resources.uikit

import com.splendo.kaluga.resources.stylable.ButtonStateStyle
import com.splendo.kaluga.resources.stylable.ButtonStyle
import com.splendo.kaluga.resources.view.KalugaButton
import kotlinx.cinterop.ObjCAction
import kotlinx.cinterop.useContents
import platform.CoreGraphics.CGFloat
import platform.CoreGraphics.CGSizeMake
import platform.Foundation.NSMapTable
import platform.Foundation.NSPointerFunctionsStrongMemory
import platform.Foundation.NSPointerFunctionsWeakMemory
import platform.QuartzCore.CALayer
import platform.UIKit.UIButton
import platform.UIKit.UIControlEventTouchUpInside
import platform.UIKit.UIControlState
import platform.UIKit.UIControlStateDisabled
import platform.UIKit.UIControlStateHighlighted
import platform.UIKit.UIControlStateNormal
import platform.UIKit.UIGraphicsBeginImageContext
import platform.UIKit.UIGraphicsEndImageContext
import platform.UIKit.UIGraphicsGetCurrentContext
import platform.UIKit.UIGraphicsGetImageFromCurrentImageContext
import platform.UIKit.setFont
import platform.darwin.NSObject
import platform.objc.sel_registerName

class UIControlClosure(private val action: () -> Unit) : NSObject() {

    @ThreadLocal
    object Registry {
        val registeredUIControl = NSMapTable(NSPointerFunctionsWeakMemory, NSPointerFunctionsStrongMemory, 0)
    }

    @ObjCAction
    fun invoke() {
        action()
    }
}

fun UIButton.bindButton(button: KalugaButton) {
    applyStyle(button.style)
    when (button) {
        is KalugaButton.Plain -> setTitle(button.text, UIControlStateNormal)
        is KalugaButton.Styled -> setAttributedTitle(button.text.attributeString, UIControlStateNormal)
    }
    setEnabled(button.isEnabled)
    val wrappedAction = UIControlClosure(button.action)
    UIControlClosure.Registry.registeredUIControl.setObject(wrappedAction, this)
    addTarget(wrappedAction, sel_registerName("invoke"), UIControlEventTouchUpInside)
}

fun UIButton.applyStyle(buttonStyle: ButtonStyle) {
    setFont(buttonStyle.font.fontWithSize(buttonStyle.textSize.toDouble() as CGFloat))
    setContentHorizontalAlignment(buttonStyle.textAlignment.contentHorizontalAlignment)
    applyButtonStateStyle(buttonStyle.defaultStyle, UIControlStateNormal)
    applyButtonStateStyle(buttonStyle.pressedStyle, UIControlStateHighlighted)
    applyButtonStateStyle(buttonStyle.disabledStyle, UIControlStateDisabled)
}

private fun UIButton.applyButtonStateStyle(style: ButtonStateStyle, state: UIControlState) {
    setTitleColor(style.textColor.uiColor, state)
    val bounds = bounds
    UIGraphicsBeginImageContext(CGSizeMake(bounds.useContents { size.width }, bounds.useContents { size.height }))
    CALayer().apply {
        frame = bounds
        applyBackgroundStyle(style.backgroundStyle, bounds)
        renderInContext(UIGraphicsGetCurrentContext())
    }
    setBackgroundImage(UIGraphicsGetImageFromCurrentImageContext(), state)
    UIGraphicsEndImageContext()
}
