package com.example.pranksounds.viewModels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pranksounds.data.models.SoundItem
import com.example.pranksounds.data.repositories.SoundsListRepo

class HeaderViewModel : ViewModel() {

    private val _headerText = MutableLiveData<String>()
    val headerText: LiveData<String>
        get() = _headerText

    fun updateText(newText: String) {
        _headerText.value = newText
    }
}