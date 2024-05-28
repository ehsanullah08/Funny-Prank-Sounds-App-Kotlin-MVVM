package com.example.pranksounds.ui.viewModels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.pranksounds.data.models.SoundItem
import com.example.pranksounds.data.repositories.PlaySoundsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PlaySoundViewModel @Inject constructor(
    private val playSoundsRepo: PlaySoundsRepo
) : ViewModel() {

    fun markFav(context: Context, soundItem: SoundItem) {
        playSoundsRepo.markFav(context, soundItem)
    }

    fun removeFav(context: Context, soundId: Int) {
        playSoundsRepo.removeFav(context, soundId)
    }

    fun isSoundExists(context: Context, soundId: Int): LiveData<Int> {
        return playSoundsRepo.isSoundExists(context, soundId)
    }
}