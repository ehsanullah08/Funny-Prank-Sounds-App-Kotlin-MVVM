package com.example.pranksounds.data.repositories

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pranksounds.data.models.SoundItem
import com.example.pranksounds.data.room.Sound
import com.example.pranksounds.data.room.SoundDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PlaySoundsRepo {

    companion object {

        private lateinit var soundDatabase: SoundDatabase
        private var favSoundsList: LiveData<List<SoundItem>>? = null


        private fun initializeDB(context: Context): SoundDatabase {
            return SoundDatabase.getDatabaseClient(context)
        }

        fun markFav(context: Context, soundItem: SoundItem) {

            soundDatabase = initializeDB(context)

            CoroutineScope(Dispatchers.IO).launch {
                val loginDetails = Sound(
                    soundItem.soundId,
                    soundItem.title,
                    soundItem.colorCode!!,
                    soundItem.fileName!!,
                    soundItem.bgImage
                )
                soundDatabase.soundDao().markFav(loginDetails)
            }

        }

        fun removeFav(context: Context, soundId: Int) {
            soundDatabase = initializeDB(context)

            CoroutineScope(Dispatchers.IO).launch {
                soundDatabase.soundDao().removeFav(soundId)
            }
        }

        fun getFavSounds(context: Context): LiveData<List<Sound>> {
            soundDatabase = initializeDB(context)
            return soundDatabase.soundDao().getAllSounds()
        }

        fun getFavoriteSoundById(context: Context, soundId: Int): Sound {
            soundDatabase = initializeDB(context)
            return soundDatabase.soundDao().getFavoriteSoundById(soundId)
        }

        fun isSoundExists(context: Context, soundId: Int): MutableLiveData<Int> {
            soundDatabase = initializeDB(context)

            val foundItemsCountLiveData = MutableLiveData<Int>()
            CoroutineScope(Dispatchers.IO).launch {
                val foundItemsCount = soundDatabase.soundDao().isSoundExists(soundId)
                foundItemsCountLiveData.postValue(foundItemsCount)
            }
            return foundItemsCountLiveData
        }

        suspend fun deleteAllFavSounds(context: Context) {
            soundDatabase = initializeDB(context)
            soundDatabase.soundDao().deleteAllSounds()
        }

    }
}