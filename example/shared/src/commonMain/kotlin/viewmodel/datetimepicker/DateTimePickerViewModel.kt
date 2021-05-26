package com.splendo.kaluga.example.shared.viewmodel.datetimepicker

import com.splendo.kaluga.architecture.observable.toUninitializedObservable
import com.splendo.kaluga.architecture.viewmodel.BaseViewModel
import com.splendo.kaluga.base.text.DateFormatStyle
import com.splendo.kaluga.base.text.DateFormatter
import com.splendo.kaluga.base.utils.Date
import com.splendo.kaluga.datetimepicker.DateTimePickerPresenter
import com.splendo.kaluga.datetimepicker.buildDatePicker
import com.splendo.kaluga.datetimepicker.buildTimePicker
import com.splendo.kaluga.resources.localized
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class DateTimePickerViewModel(val dateTimePickerPresenterBuilder: DateTimePickerPresenter.Builder) : BaseViewModel() {

    companion object {
        private val formatter = DateFormatter.dateTimeFormat(DateFormatStyle.Long, DateFormatStyle.Long)
    }

    private val selectedDate = MutableStateFlow(Date.now().apply {
        second = 0
        millisecond = 0
    })
    val dateLabel = selectedDate.map { formatter.format(it) }.toUninitializedObservable(coroutineScope)

    fun onSelectDatePressed() {
        coroutineScope.launch {
            dateTimePickerPresenterBuilder.buildDatePicker(this, Date.epoch(), Date.now()) {
                setSelectedDate(this@DateTimePickerViewModel.selectedDate.value)
                setCancelButtonTitle("cancel_selection".localized())
                setConfirmButtonTitle("confirm_selection".localized())
            }.show()?.let {
                selectedDate.value = it
            }
        }
    }

    fun onSelectTimePressed() {
        coroutineScope.launch {
            dateTimePickerPresenterBuilder.buildTimePicker(this) {
                setSelectedDate(this@DateTimePickerViewModel.selectedDate.value)
                setCancelButtonTitle("cancel_selection".localized())
                setConfirmButtonTitle("confirm_selection".localized())
            }.show()?.let {
                selectedDate.value = it
            }
        }
    }
}
