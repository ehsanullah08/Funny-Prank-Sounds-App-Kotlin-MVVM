package com.example.pranksounds.viewModels

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.pranksounds.data.models.LanguageItem
import com.example.pranksounds.data.repositories.LanguagesListRepo

class LanguagesListViewModel : ViewModel() {

    fun getLanguagesList(context: Context): List<LanguageItem> {
        return LanguagesListRepo.getLanguagesList(context)
    }
}