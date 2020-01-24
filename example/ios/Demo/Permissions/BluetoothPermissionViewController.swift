//
//  BluetoothPermissionViewController.swift
//  Demo
//
//  Created by arnoid on 21/10/2019.
//  Copyright © 2019 Splendo. All rights reserved.
//

import UIKit
import Foundation
import KotlinNativeFramework

class BluetoothPermissionViewController: UITableViewController {

    let bluetoothManager = KotlinNativeFramework().permissions(nsBundle: Bundle.main).getBluetoothManager()

    override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        tableView.deselectRow(at: indexPath, animated: true)
        
        switch (indexPath.row) {
        case 1:
            debugPrint(bluetoothManager.checkPermit().name)
        case 2:
            debugPrint(bluetoothManager.checkSupport().name)
        case 3:
            bluetoothManager.openSettings()
        default:
            break
        }
    }

}
