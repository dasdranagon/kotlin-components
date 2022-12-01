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

package com.splendo.kaluga.example.architecture.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.splendo.kaluga.architecture.compose.navigation.HardwareBackButtonNavigation
import com.splendo.kaluga.architecture.compose.navigation.ModalBottomSheetNavigator
import com.splendo.kaluga.architecture.compose.viewModel.ViewModelComposable
import com.splendo.kaluga.architecture.compose.viewModel.storeAndRemember
import com.splendo.kaluga.example.compose.Constants
import com.splendo.kaluga.example.shared.viewmodel.architecture.BottomSheetViewModel
import com.splendo.kaluga.resources.compose.Composable

@Composable
fun BottomSheetLayout(contentNavHostController: NavHostController, sheetContentNavHostController: NavHostController, sheetState: ModalBottomSheetState) {
    val navigator = ModalBottomSheetNavigator(
        contentNavHostController,
        sheetContentNavHostController,
        sheetState,
        rememberCoroutineScope(),
        ::bottomSheetNavigationRouteMapper,
    )

    val viewModel = storeAndRemember {
        BottomSheetViewModel(navigator)
    }

    ViewModelComposable(viewModel) {
        HardwareBackButtonNavigation(onBackButtonClickHandler = { onClosePressed() })
        Column(
            Modifier
                .fillMaxWidth()
                .padding(Constants.Padding.default)
        ) {
            Text(text)
            button.Composable(modifier = Modifier
                .fillMaxWidth()
                .padding(Constants.Padding.default))
        }
    }
}