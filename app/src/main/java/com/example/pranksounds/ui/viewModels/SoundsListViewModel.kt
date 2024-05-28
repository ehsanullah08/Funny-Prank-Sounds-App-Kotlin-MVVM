package com.example.pranksounds.ui.viewModels

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.pranksounds.data.models.SoundItem
import com.example.pranksounds.data.repositories.SoundsListRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SoundsListViewModel @Inject constructor(private val soundsListRepo: SoundsListRepo) : ViewModel() {

    fun getSoundsList(context: Context, categoryId: Int): List<SoundItem> {
        return soundsListRepo.getSoundsList(context, categoryId)
    }
}