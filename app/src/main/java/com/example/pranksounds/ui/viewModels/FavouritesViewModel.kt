package com.example.pranksounds.ui.viewModels

import android.content.Context
import android.health.connect.datatypes.DataOrigin
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pranksounds.data.source.local.SoundItem
import com.example.pranksounds.data.repositories.FavSoundsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavouritesViewModel @Inject constructor(private val favSoundsRepo: FavSoundsRepo) : ViewModel() {

    var soundItem: LiveData<SoundItem>? = null
    var soundItemsList: LiveData<List<SoundItem>>? = null

    fun getFavSoundsList(context: Context): LiveData<List<SoundItem>> {
        soundItemsList = favSoundsRepo.getFavSounds(context)
        return soundItemsList as LiveData<List<SoundItem>>
    }

    fun clearDatabase(context: Context) {
        viewModelScope.launch {
            favSoundsRepo.deleteAllFavSounds(context)
        }
    }
}