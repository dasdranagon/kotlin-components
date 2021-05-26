//
//  KeyboardManagerViewController.swift
//  Demo
//
//  Created by Gijs van Veen on 04/12/2019.
//  Copyright © 2019 Splendo. All rights reserved.
//

import UIKit
import KotlinNativeFramework

class KeyboardManagerViewController : UIViewController {
    
    @IBOutlet private var editField: UITextField!
    
    private lazy var editFieldFocusHandler = {
        return UIKitFocusHandler(view: self.editField)
    }()
    lazy var viewModel = KNArchitectureFramework().createKeyboardViewModel(focusHandler: self.editFieldFocusHandler)
    private var lifecycleManager: LifecycleManager!
    
    deinit {
        lifecycleManager.unbind()
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        lifecycleManager = KNArchitectureFramework().bind(viewModel: viewModel, to: self, onLifecycleChanges: { return [] })
    }
    
    @IBAction
    func showButtonPressed() {
        viewModel.onShowPressed()
    }
    
    @IBAction
    func hideButtonPressed() {
        viewModel.onHidePressed()
    }
}
