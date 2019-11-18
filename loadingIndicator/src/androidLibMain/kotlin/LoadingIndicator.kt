package com.splendo.kaluga.loadingIndicator

import android.content.Context
import android.content.res.ColorStateList
import android.content.res.Resources.ID_NULL
import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ProgressBar
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt
import androidx.annotation.IdRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity
import java.lang.Exception

/*

Copyright 2019 Splendo Consulting B.V. The Netherlands

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

class AndroidLoadingIndicator private constructor(viewResId: Int, style: LoadingIndicator.Style, private val activity: FragmentActivity) : LoadingIndicator {

    class Builder(private val activity: FragmentActivity) : LoadingIndicator.Builder {
        override var style = LoadingIndicator.Style.SYSTEM
        override fun create() = AndroidLoadingIndicator(R.layout.loading_indicator_view, style, activity)
    }

    class LoadingDialog : DialogFragment() {

        private val viewResId get() = arguments?.getInt(RESOURCE_ID_KEY) ?: ID_NULL
        private val style get() = LoadingIndicator.Style.valueOf(arguments?.getInt(STYLE_KEY) ?: LoadingIndicator.Style.SYSTEM.value)

        @ColorInt
        private fun backgroundColor(context: Context): Int = when (style) {
            LoadingIndicator.Style.SYSTEM -> resolveAttrColor(context, android.R.attr.windowBackground)
            LoadingIndicator.Style.CUSTOM -> ContextCompat.getColor(context, R.color.li_colorBackground)
        }

        @ColorInt
        private fun foregroundColor(context: Context): Int = when (style) {
            LoadingIndicator.Style.SYSTEM -> resolveAttrColor(context, android.R.attr.colorAccent)
            LoadingIndicator.Style.CUSTOM -> ContextCompat.getColor(context, R.color.li_colorAccent)
        }

        @ColorInt
        private fun resolveAttrColor(context: Context, @AttrRes colorAttrRes: Int): Int {
            val typedValue = TypedValue()
            context.theme.resolveAttribute(colorAttrRes, typedValue, true)
            return typedValue.data
        }

        companion object {

            private const val RESOURCE_ID_KEY = "resId"
            private const val STYLE_KEY = "style"

            fun newInstance(@IdRes viewResId: Int, style: LoadingIndicator.Style) = LoadingDialog().apply {
                arguments = Bundle().apply {
                    putInt(RESOURCE_ID_KEY, viewResId)
                    putInt(STYLE_KEY, style.ordinal)
                }
                isCancelable = false
                retainInstance = true
            }
        }

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): android.view.View? {
            return inflater.inflate(viewResId, container).apply {
                findViewById<LinearLayout>(R.id.content_view).setBackgroundColor(backgroundColor(inflater.context))
                findViewById<ProgressBar>(R.id.progress_bar).indeterminateTintList = ColorStateList.valueOf(foregroundColor(inflater.context))
            }
        }
    }

    private val loadingDialog = LoadingDialog.newInstance(viewResId, style)

    override val isVisible get() = loadingDialog.isVisible

    override fun present(animated: Boolean, completion: () -> Unit): LoadingIndicator = apply {
        loadingDialog.show(activity.supportFragmentManager, "LoadingIndicator")
        completion()
    }

    override fun dismiss(animated: Boolean, completion: () -> Unit) {
        loadingDialog.dismiss()
        completion()
    }
}
