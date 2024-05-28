package com.example.pranksounds.ui.viewModels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pranksounds.data.models.SoundItem
import com.example.pranksounds.data.repositories.FavSoundsRepo
import com.example.pranksounds.data.source.local.SoundDAO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavouritesViewModel @Inject constructor(private val favSoundsRepo: FavSoundsRepo) : ViewModel() {

    var soundItem: LiveData<SoundItem>? = null
    var soundItemsList: LiveData<List<SoundItem>>? = null

    fun getFavSoundsList(): LiveData<List<SoundItem>> {
        soundItemsList = favSoundsRepo.getFavSounds()
        return soundItemsList as LiveData<List<SoundItem>>
    }

    fun clearDatabase() {
        viewModelScope.launch {
            favSoundsRepo.deleteAllFavSounds()
        }
    }
}