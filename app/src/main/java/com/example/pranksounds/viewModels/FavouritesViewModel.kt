package com.example.pranksounds.viewModels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pranksounds.data.models.SoundItem
import com.example.pranksounds.data.repositories.FavSoundsRepo
import com.example.pranksounds.data.room.Sound
import kotlinx.coroutines.launch

class FavouritesViewModel : ViewModel() {

    var soundItem: LiveData<SoundItem>? = null
    var soundItemsList: LiveData<List<Sound>>? = null
    /*var soundItemsList: MutableLiveData<List<SoundItem>>? = MutableLiveData<List<SoundItem>>(*/

    fun getFavSoundsList(context: Context): LiveData<List<Sound>> {
        soundItemsList = FavSoundsRepo.getFavSounds(context)
        return soundItemsList as LiveData<List<Sound>>
    }

    fun clearDatabase(context: Context) {
        viewModelScope.launch {
            FavSoundsRepo.deleteAllFavSounds(context)
        }
    }
}