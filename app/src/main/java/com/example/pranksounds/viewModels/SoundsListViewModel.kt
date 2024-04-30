package com.example.pranksounds.viewModels

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.pranksounds.data.models.SoundItem
import com.example.pranksounds.data.repositories.SoundsListRepo

class SoundsListViewModel : ViewModel() {

    fun getSoundsList(context: Context, categoryId: Int): List<SoundItem> {
        return SoundsListRepo.getSoundsList(context, categoryId)
    }
}