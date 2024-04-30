package com.example.pranksounds.viewModels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pranksounds.data.models.SoundItem
import com.example.pranksounds.data.repositories.PlaySoundsRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PlaySoundViewModel : ViewModel() {

    fun markFav(context: Context, soundItem: SoundItem) {
        PlaySoundsRepo.markFav(context, soundItem)
    }

    fun removeFav(context: Context, soundId: Int) {
        PlaySoundsRepo.removeFav(context, soundId)
    }

    fun isSoundExists(context: Context, soundId: Int): LiveData<Int> {
        return PlaySoundsRepo.isSoundExists(context, soundId)
    }
}