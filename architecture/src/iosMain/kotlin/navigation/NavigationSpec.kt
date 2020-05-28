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

package com.splendo.kaluga.architecture.navigation

import platform.CoreFoundation.CFStringRef
import platform.CoreServices.kUTTypeImage
import platform.CoreServices.kUTTypeMovie
import platform.Foundation.NSData
import platform.Foundation.NSURL
import platform.MessageUI.MFMailComposeViewController
import platform.MessageUI.MFMailComposeViewControllerDelegateProtocol
import platform.MessageUI.MFMessageComposeViewController
import platform.MessageUI.MFMessageComposeViewControllerDelegateProtocol
import platform.Messages.MSMessage
import platform.UIKit.NSLayoutConstraint
import platform.UIKit.UIBarButtonItem
import platform.UIKit.UIDocumentBrowserAction
import platform.UIKit.UIDocumentBrowserUserInterfaceStyle
import platform.UIKit.UIDocumentBrowserUserInterfaceStyleLight
import platform.UIKit.UIDocumentBrowserViewController
import platform.UIKit.UIDocumentBrowserViewControllerDelegateProtocol
import platform.UIKit.UIImage
import platform.UIKit.UIImagePickerController
import platform.UIKit.UIImagePickerControllerDelegateProtocol
import platform.UIKit.UIImagePickerControllerSourceType
import platform.UIKit.UIInterfaceOrientation
import platform.UIKit.UIInterfaceOrientationMask
import platform.UIKit.UIModalPresentationAutomatic
import platform.UIKit.UIModalPresentationStyle
import platform.UIKit.UIModalTransitionStyle
import platform.UIKit.UIModalTransitionStyleCoverVertical
import platform.UIKit.UINavigationController
import platform.UIKit.UINavigationControllerDelegateProtocol
import platform.UIKit.UINavigationControllerOperation
import platform.UIKit.UIView
import platform.UIKit.UIViewController
import platform.UIKit.UIViewControllerAnimatedTransitioningProtocol
import platform.UIKit.UIViewControllerInteractiveTransitioningProtocol
import platform.darwin.NSObject

/**
 * Spec used by [Navigator] to determine how to perform Navigation
 */
sealed class NavigationSpec {

    /**
     * Navigates to a new view controller by pushing it on top of the parents [UINavigationController]
     * @param animated Specifies whether transition should be animated
     * @param push Function to create the [UIViewController] to push
     */
    data class Push(val animated: Boolean = true, val push: () -> UIViewController) : NavigationSpec()

    /**
     * Pops the viewController on the parents [UINavigationController].
     * @param to Optional [UIViewController] to pop to. If not provided the viewcontroller on top is popped.
     * @param animated Specifies whether transition should be animated
     */
    data class Pop(val to: UIViewController? = null, val animated: Boolean = true) : NavigationSpec()

    /**
     * Lets the parent present a [UIViewController] using [UIViewController.presentViewController].
     * @param animated Specifies whether transition should be animated
     * @param presentationStyle The [UIModalPresentationStyle] to present the viewcontroller in. Defaults to [UIModalPresentationAutomatic]
     * @param transitionStyle The [UIModalTransitionStyle] to transition to. Defaults to [UIModalTransitionStyleCoverVertical]
     * @param present Function to create the [UIViewController] to present
     * @param completion Optional function to call when presentation has completed
     */
    data class Present(
        val animated: Boolean = true,
        val presentationStyle: UIModalPresentationStyle = UIModalPresentationAutomatic,
        val transitionStyle: UIModalTransitionStyle = UIModalTransitionStyleCoverVertical,
        val present: () -> UIViewController,
        val completion: (() -> Unit)? = null
    ) : NavigationSpec()

    /**
     * Dismisses the parent.
     * @param animated Specifies whether transition should be animated
     * @param completion Optional function to call when dismissal has completed
     */
    data class Dismiss(val animated: Boolean = false, val completion: (() -> Unit)? = null) : NavigationSpec()

    /**
     * Lets the parent show a [UIViewController] using [UIViewController.showViewController]
     * @param detail When set too true, shows using [UIViewController.showDetailViewController]
     * @param show Function to create the [UIViewController] to show
     */
    data class Show(val detail: Boolean = false, val show: () -> UIViewController) : NavigationSpec()

    /**
     * Triggers a segue with a given identifier on the parent
     * @param identifier The identifier of the segue to perform
     */
    data class Segue(val identifier: String) : NavigationSpec()

    /**
     * Adds a nested [UIViewController] to a container [UIView].
     * @param type The [Type] of presentation
     * @param containerView The [UIView] to which the [UIViewController] should be added. Must be a child of the parent
     * @param nested Function to create the [UIViewController] to add to the container view
     * @param constraints Optional function that takes the child and container view and returns the constraints to set. If left empty, the child will default to match the container view size
     */
    data class Nested(
        val type: Type = Type.Add,
        val containerView: UIView,
        val nested: () -> UIViewController,
        val constraints: ((UIView, UIView) -> List<NSLayoutConstraint>)? = null
    ) : NavigationSpec() {

        /**
         * Nested Presentation type
         */
        sealed class Type {
            /**
             * Adds the [UIViewController] to the container without removing any other views from the container
             */
            object Add : Type()

            /**
             * Replaces the current content matching a tag from the container before adding the new view
             * @param tag Tag added to the [UIView] of the [UIViewController] to determine whether it should be replaced
             */
            data class Replace(val tag: Long) : Type()
        }
    }

    /**
     * Presents a [UIImagePickerController] to the parent
     * @param mediaType Set of allowed [MediaType]s to pick
     * @param navigationDelegate The [UINavigationControllerDelegateProtocol] added to the [UIImagePickerController]
     * @param imagePickerDelegate The [UIImagePickerControllerDelegateProtocol] added to the [UIImagePickerController]
     * @param animated Specifies whether transition should be animated
     * @param completion Optional function called when presentation is completed
     */
    data class ImagePicker(
        val sourceType: UIImagePickerControllerSourceType = UIImagePickerControllerSourceType.UIImagePickerControllerSourceTypePhotoLibrary,
        val mediaType: Set<MediaType> = setOf(MediaType.Image),
        val navigationDelegate: UINavigationControllerDelegateProtocol,
        val imagePickerDelegate: UIImagePickerControllerDelegateProtocol,
        val animated: Boolean = false,
        val completion: (() -> Unit)? = null
    ) : NavigationSpec() {

        @Suppress("CONFLICTING_OVERLOADS")
        internal val delegate: UINavigationControllerDelegateProtocol = object : NSObject(), UIImagePickerControllerDelegateProtocol, UINavigationControllerDelegateProtocol {

            override fun navigationController(navigationController: UINavigationController, willShowViewController: UIViewController, animated: Boolean) {
                navigationDelegate.navigationController(navigationController, willShowViewController = willShowViewController, animated = animated)
            }

            override fun navigationController(navigationController: UINavigationController, didShowViewController: UIViewController, animated: Boolean) {
                navigationDelegate.navigationController(navigationController, didShowViewController = didShowViewController, animated = animated)
            }

            override fun navigationController(
                navigationController: UINavigationController,
                animationControllerForOperation: UINavigationControllerOperation,
                fromViewController: UIViewController,
                toViewController: UIViewController
            ): UIViewControllerAnimatedTransitioningProtocol? {
                return navigationDelegate.navigationController(navigationController, animationControllerForOperation, fromViewController, toViewController)
            }

            override fun navigationController(
                navigationController: UINavigationController,
                interactionControllerForAnimationController: UIViewControllerAnimatedTransitioningProtocol
            ): UIViewControllerInteractiveTransitioningProtocol? {
                return navigationDelegate.navigationController(navigationController, interactionControllerForAnimationController)
            }

            override fun navigationControllerSupportedInterfaceOrientations(navigationController: UINavigationController): UIInterfaceOrientationMask {
                return navigationDelegate.navigationControllerSupportedInterfaceOrientations(navigationController)
            }

            override fun navigationControllerPreferredInterfaceOrientationForPresentation(navigationController: UINavigationController): UIInterfaceOrientation {
                return navigationDelegate.navigationControllerPreferredInterfaceOrientationForPresentation(navigationController)
            }

            override fun imagePickerController(picker: UIImagePickerController, didFinishPickingMediaWithInfo: Map<Any?, *>) {
                imagePickerDelegate.imagePickerController(picker, didFinishPickingMediaWithInfo)
            }

            override fun imagePickerController(picker: UIImagePickerController, didFinishPickingImage: UIImage, editingInfo: Map<Any?, *>?) {
                imagePickerDelegate.imagePickerController(picker, didFinishPickingImage, editingInfo)
            }

            override fun imagePickerControllerDidCancel(picker: UIImagePickerController) {
                imagePickerDelegate.imagePickerControllerDidCancel(picker)
            }
        }

        /**
         * The type of media that can be picked
         */
        sealed class MediaType {

            abstract val typeString: CFStringRef?

            object Image : MediaType() { override val typeString = kUTTypeImage }
            object Movie : MediaType() { override val typeString = kUTTypeMovie }
        }
    }

    /**
     * Presents a [MFMailComposeViewController]
     * @param emailSettings [EmailSettings] for composing the email
     * @param delegate Optional [MFMailComposeViewControllerDelegateProtocol] added to the [MFMailComposeViewController]
     * @param animated Specifies whether the transition should be animated
     * @param completion Optional function called when presentation is completed
     */
    data class Email(
        val emailSettings: EmailSettings,
        val delegate: MFMailComposeViewControllerDelegateProtocol? = null,
        val animated: Boolean = false,
        val completion: (() -> Unit)? = null
    ) : NavigationSpec() {

        /**
         * The type of formatting used for composing the email
         */
        sealed class Type {
            object Plain : Type()
            object Stylized : Type()
        }

        /**
         * An attachement added to the email
         * @param data [NSData] to add to the email
         * @param mimeType Mime type of the file
         * @param fileName File name of the file
         */
        data class Attachment(val data: NSData, val mimeType: String, val fileName: String)

        /**
         * Settings for composing the email
         * @param type [Type] used for formatting
         * @param to List of emails to send the email to
         * @param cc List of emails to cc the email to
         * @param bcc List of emails to bcc the emails to
         * @param subject Optional subject of the email
         * @param body Optional body of the email
         * @param attachments List of [Attachment] to add to the email
         */
        data class EmailSettings(
            val type: Type = Type.Plain,
            val to: List<String> = emptyList(),
            val cc: List<String> = emptyList(),
            val bcc: List<String> = emptyList(),
            val subject: String? = null,
            val body: String? = null,
            val attachments: List<Attachment> = emptyList()
        )
    }

    /**
     * Presents a [UIDocumentBrowserViewController]
     * @param documentSelectorSettings The [DocumentSelectorSettings] for selecting the document
     * @param documentSelectorAppearance The [DocumentSelectorAppearance] for configuring the appearance of the selector
     * @param delegate The [UIDocumentBrowserViewControllerDelegateProtocol] added to the [UIDocumentBrowserViewController]
     * @param animated Specifies whether transition is animated
     * @param completion Optional function called when presentation is completed
     */
    data class DocumentSelector(
        val documentSelectorSettings: DocumentSelectorSettings,
        val documentSelectorAppearance: DocumentSelectorAppearance,
        val delegate: UIDocumentBrowserViewControllerDelegateProtocol,
        val animated: Boolean = false,
        val completion: (() -> Unit)? = null
    ) : NavigationSpec() {

        /**
         * Configures the settings for a [UIDocumentBrowserViewController]
         * @param types List of file types that can be opened
         * @param allowMultiple Indicates whether the user can select multiple files
         * @param allowCreation Indicates whether the user can create new files
         */
        data class DocumentSelectorSettings(val types: Set<String>, val allowMultiple: Boolean = false, val allowCreation: Boolean = false)
        data class DocumentSelectorAppearance(
            val interfaceStyle: UIDocumentBrowserUserInterfaceStyle = UIDocumentBrowserUserInterfaceStyleLight,
            val leadingNavigationBarButtonItems: List<UIBarButtonItem> = emptyList(),
            val trailingNavigationBarButtonItems: List<UIBarButtonItem> = emptyList(),
            val customActions: List<UIDocumentBrowserAction> = emptyList(),
            val createTitle: String,
            val documentAspectRatio: Double = 2.0 / 3.0,
            val showFileExtensions: Boolean = false
        )
    }

    /**
     * Opens the phone dialer
     * @param phoneNumber The phone number to dial
     */
    data class Phone(val phoneNumber: String) : NavigationSpec()

    /**
     * Opens the Phone settings
     */
    object Settings : NavigationSpec()

    /**
     * Presents a [MFMessageComposeViewController]
     * @param messageSettings The [MessageSettings] for configuring the message
     * @param delegate The [MFMessageComposeViewControllerDelegateProtocol] to add to the [MFMessageComposeViewController]
     * @param animated Specifies whether transition is animated
     * @param completion Optional function called when presentation is completed
     */
    data class Message(
        val messageSettings: MessageSettings,
        val delegate: MFMessageComposeViewControllerDelegateProtocol,
        val animated: Boolean = false,
        val completion: (() -> Unit)? = null
    ) : NavigationSpec() {

        /**
         * An attachement added to the message
         * @param data [NSData] to add to the email
         * @param mimeType Mime type of the file
         * @param fileName File name of the file
         */
        data class Attachment(val data: NSData, val mimeType: String, val fileName: String)

        /**
         * Settings for configuring the message
         * @param recipients list of phone numbers to send the message to
         * @param subject Optional subject of the message
         * @param body Optional body of the message
         * @param disableAttachments Disables the user from adding attachements
         * @param attachments The list of [Attachment] added to the message
         */
        data class MessageSettings(
            val recipients: List<String> = emptyList(),
            val subject: String? = null,
            val body: String? = null,
            val message: MSMessage? = null,
            val disableAttachments: Boolean = false,
            val attachments: List<Attachment> = emptyList()
        )
    }

    /**
     * Opens the browser
     * @param url The [NSURL] to open in the browser
     */
    data class Browser(val url: NSURL) : NavigationSpec()
}
