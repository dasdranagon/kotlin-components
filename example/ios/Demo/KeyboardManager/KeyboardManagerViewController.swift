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

import UIKit
import KalugaExampleShared

class KeyboardManagerViewController : UIViewController {
    
    @IBOutlet private var editField: UITextField!
    @IBOutlet private var showButton: UIButton!
    @IBOutlet private var hideButton: UIButton!
    
    private lazy var editFieldFocusHandler = {
        return UIKitFocusHandler(view: self.editField)
    }()
    lazy var viewModel = KeyboardViewModel(keyboardManagerBuilder: UIKitKeyboardManager.Builder(application: UIApplication.shared), editFieldFocusHandler: editFieldFocusHandler)
    private var lifecycleManager: LifecycleManager!

    deinit {
        lifecycleManager.unbind()
    }

    override func viewDidLoad() {
        super.viewDidLoad()

        lifecycleManager = viewModel.addLifecycleManager(parent: self) { return [] }
        ButtonStyleKt.bindButton(showButton, button: viewModel.showButton)
        ButtonStyleKt.bindButton(hideButton, button: viewModel.hideButton)
    }
}
