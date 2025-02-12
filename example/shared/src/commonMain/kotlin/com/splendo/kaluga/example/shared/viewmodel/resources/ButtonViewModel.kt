/*
 Copyright 2022 Splendo Consulting B.V. The Netherlands

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

package com.splendo.kaluga.example.shared.viewmodel.resources

import com.splendo.kaluga.alerts.BaseAlertPresenter
import com.splendo.kaluga.alerts.buildAlert
import com.splendo.kaluga.architecture.observable.observableOf
import com.splendo.kaluga.architecture.viewmodel.BaseLifecycleViewModel
import com.splendo.kaluga.example.shared.stylable.ButtonStyles
import com.splendo.kaluga.resources.StringStyleAttribute
import com.splendo.kaluga.resources.StyledStringBuilder
import com.splendo.kaluga.resources.stylable.KalugaButtonStyle
import com.splendo.kaluga.resources.styled
import com.splendo.kaluga.resources.view.KalugaButton
import kotlinx.coroutines.launch

class ButtonViewModel(styledStringBuilderProvider: StyledStringBuilder.Provider, private val alertPresenterBuilder: BaseAlertPresenter.Builder) :
    BaseLifecycleViewModel(alertPresenterBuilder) {

    val buttons = observableOf(
        listOf(
            "Text Button".toButton(ButtonStyles.textButton),
            "Red Button".toButton(ButtonStyles.redButton),
            "Rounded Button".toButton(ButtonStyles.roundedButton),
            "Oval Button".toButton(ButtonStyles.ovalButton),
            "Stroke Button".toButton(ButtonStyles.redButtonWithStroke),
            "Rounded Stroke Button".toButton(ButtonStyles.roundedButtonWithStroke),
            "Oval Stroke Button".toButton(ButtonStyles.ovalButtonWithStroke),
            "Linear Gradient Button".toButton(ButtonStyles.linearGradientButton),
            "Radial Gradient Button".toButton(ButtonStyles.radialGradientButton),
            "Angular Gradient Button".toButton(ButtonStyles.angularGradientButton),
            "Disabled Button".toButton(ButtonStyles.redButton, false),
            "Left Image Button".toButton(ButtonStyles.textButtonWithImageLeft),
            "Start Image Button".toButton(ButtonStyles.textButtonWithImageStart),
            "Right Image Button".toButton(ButtonStyles.textButtonWithImageRight),
            "End Image Button".toButton(ButtonStyles.textButtonWithImageEnd),
            "Top Image Button".toButton(ButtonStyles.textButtonWithImageTop),
            "Bottom Image Button".toButton(ButtonStyles.textButtonWithImageBottom),
            "Intrinsic Size Image Button".toButton(ButtonStyles.textButtonWithImageIntrinsicSize),
            "State Image Button".toButton(ButtonStyles.textButtonWithStateImage),
            listOf(
                KalugaButton.Styled(
                    "Styled Button".styled(
                        styledStringBuilderProvider,
                        ButtonStyles.textButton.getStateTextStyle(
                            isEnabled = true,
                            isPressed = false,
                        ),
                        StringStyleAttribute.CharacterStyleAttribute.Strikethrough,
                    ),
                    ButtonStyles.textButton,
                ) {
                    showAlert("Styled Button")
                },
                KalugaButton.WithoutText(ButtonStyles.imageOnly) { showAlert("Image Only") },
                KalugaButton.WithoutText(ButtonStyles.imageOnlyIntrinsic) { showAlert("Image Only Intrinsic") },
                KalugaButton.WithoutText(ButtonStyles.noContent) { showAlert("No Content") },
            ),
        ).flatten(),
    )

    private fun showAlert(message: String) {
        coroutineScope.launch {
            alertPresenterBuilder.buildAlert(this) {
                setTitle("Button Pressed")
                setMessage(message)
                setNeutralButton("Ok")
            }.show()
        }
    }

    private fun String.toButton(style: KalugaButtonStyle.WithText<*>, isEnabled: Boolean = true): List<KalugaButton.Plain> = listOf(
        KalugaButton.Plain(this, style, isEnabled) {
            showAlert(this)
        },
    )
}
