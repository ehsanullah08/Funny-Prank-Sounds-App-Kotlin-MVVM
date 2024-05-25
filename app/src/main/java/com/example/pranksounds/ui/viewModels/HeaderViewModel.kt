package com.example.pranksounds.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HeaderViewModel : ViewModel() {

    private val _headerText = MutableLiveData<String>()
    val headerText: LiveData<String>
        get() = _headerText

    fun updateText(newText: String) {
        _headerText.value = newText
    }
}