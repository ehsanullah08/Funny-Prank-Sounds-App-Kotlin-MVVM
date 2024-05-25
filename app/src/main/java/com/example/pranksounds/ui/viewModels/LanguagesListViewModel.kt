package com.example.pranksounds.ui.viewModels

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.pranksounds.data.models.LanguageItem
import com.example.pranksounds.data.repositories.LanguagesListRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LanguagesListViewModel @Inject constructor(
    private val languagesListRepo: LanguagesListRepo
) : ViewModel() {

    fun getLanguagesList(context: Context): List<LanguageItem> {
        return languagesListRepo.getLanguagesList(context)
    }
}
