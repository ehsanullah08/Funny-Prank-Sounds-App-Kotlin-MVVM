package com.example.pranksounds.data.repositories

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pranksounds.data.models.SoundItem
import com.example.pranksounds.data.source.local.SoundDAO
import com.example.pranksounds.data.source.local.SoundDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class PlaySoundsRepo @Inject constructor(private val soundDAO: SoundDAO) {

    fun markFav(context: Context, soundItem: SoundItem) {

        CoroutineScope(Dispatchers.IO).launch {
            val loginDetails = SoundItem(
                soundItem.soundId,
                soundItem.title,
                soundItem.colorCode,
                soundItem.fileName,
                soundItem.bgImage
            )

            soundDAO.markFav(loginDetails)
        }

    }

    fun removeFav(context: Context, soundId: Int) {

        CoroutineScope(Dispatchers.IO).launch {
            soundDAO.removeFav(soundId)
        }
    }

    fun getFavSounds(context: Context): LiveData<List<SoundItem>> {
        return soundDAO.getAllSounds()
    }

    fun getFavoriteSoundById(context: Context, soundId: Int): SoundItem {
        return soundDAO.getFavoriteSoundById(soundId)
    }

    fun isSoundExists(context: Context, soundId: Int): MutableLiveData<Int> {

        val foundItemsCountLiveData = MutableLiveData<Int>()
        CoroutineScope(Dispatchers.IO).launch {
            val foundItemsCount = soundDAO.isSoundExists(soundId)
            foundItemsCountLiveData.postValue(foundItemsCount)
        }
        return foundItemsCountLiveData
    }

    suspend fun deleteAllFavSounds(context: Context) {
        soundDAO.deleteAllSounds()
    }
}