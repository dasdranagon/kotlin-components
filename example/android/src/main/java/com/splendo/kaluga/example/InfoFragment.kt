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

package com.splendo.kaluga.example

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.RecyclerView
import com.splendo.kaluga.architecture.navigation.ActivityNavigator
import com.splendo.kaluga.architecture.navigation.NavigationSpec
import com.splendo.kaluga.architecture.viewmodel.KalugaViewModelFragment
import com.splendo.kaluga.example.shared.viewmodel.info.DialogSpecRow
import com.splendo.kaluga.example.shared.viewmodel.info.InfoNavigation
import com.splendo.kaluga.example.shared.viewmodel.info.InfoViewModel
import com.splendo.kaluga.example.shared.viewmodel.info.LinkSpecRow
import com.splendo.kaluga.example.shared.viewmodel.info.MailSpecRow
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import java.net.URL

class InfoFragment : KalugaViewModelFragment<InfoViewModel>(R.layout.fragment_info) {

    override val viewModel: InfoViewModel by viewModel {
        parametersOf(
            ActivityNavigator<InfoNavigation<*>> { action ->
                when (action) {
                    is InfoNavigation.Dialog -> {
                        val title = action.bundle?.get(DialogSpecRow.TitleRow) ?: ""
                        val message = action.bundle?.get(DialogSpecRow.MessageRow) ?: ""
                        NavigationSpec.Dialog(
                            createDialog = {
                                InfoDialog(title, message)
                            }
                        )
                    }
                    is InfoNavigation.Link -> NavigationSpec.Browser(
                        URL(action.bundle!!.get(LinkSpecRow.LinkRow)),
                        NavigationSpec.Browser.Type.Normal
                    )
                    is InfoNavigation.Mail -> NavigationSpec.Email(
                        NavigationSpec.Email.EmailSettings(
                            to = action.bundle?.get(MailSpecRow.ToRow) ?: emptyList(),
                            subject = action.bundle?.get(MailSpecRow.SubjectRow)
                        )
                    )
                }
            }
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        val adapter = InfoAdapter(viewModel).apply {
            view.findViewById<RecyclerView>(R.id.info_buttons)
                .adapter = this
        }
        viewModel.buttons.observeInitialized { adapter.buttons = it }
    }
}

class InfoAdapter(private val viewModel: InfoViewModel) : RecyclerView.Adapter<InfoAdapter.InfoViewHolder>() {

    class InfoViewHolder(val button: AppCompatButton) : RecyclerView.ViewHolder(button)

    var buttons: List<InfoViewModel.Button> = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoViewHolder {
        val button = LayoutInflater.from(parent.context).inflate(R.layout.view_list_button, parent, false) as AppCompatButton
        return InfoViewHolder(button)
    }

    override fun getItemCount(): Int = buttons.size

    override fun onBindViewHolder(holder: InfoViewHolder, position: Int) {
        buttons.getOrNull(position)?.let { button ->
            holder.button.text = button.title
            holder.button.setOnClickListener { viewModel.onButtonPressed(button) }
        } ?: run {
            holder.button.text = null
            holder.button.setOnClickListener(null)
        }
    }
}

class InfoDialog(val title: String, val message: String) : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.dialog_info, container, false)

        v.findViewById<TextView>(R.id.title).text = title
        v.findViewById<TextView>(R.id.message).text = message

        return v
    }
}
