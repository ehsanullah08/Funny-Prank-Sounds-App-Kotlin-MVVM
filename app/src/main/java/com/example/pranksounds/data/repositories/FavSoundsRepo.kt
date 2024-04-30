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

class FavSoundsRepo {

    companion object {

        private lateinit var soundDatabase: SoundDatabase
        private var favSoundsList: LiveData<List<SoundItem>>? = null


        private fun initializeDB(context: Context): SoundDatabase {
            return SoundDatabase.getDatabaseClient(context)
        }

        fun getFavSounds(context: Context): LiveData<List<Sound>> {
            soundDatabase = initializeDB(context)
            return soundDatabase.soundDao().getAllSounds()
        }

        suspend fun deleteAllFavSounds(context: Context) {
            soundDatabase = initializeDB(context)
            soundDatabase.soundDao().deleteAllSounds()
        }

    }
}