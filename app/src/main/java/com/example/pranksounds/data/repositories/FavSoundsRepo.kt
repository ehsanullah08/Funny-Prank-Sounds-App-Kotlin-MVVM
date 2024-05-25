package com.example.pranksounds.data.repositories

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.pranksounds.data.source.local.SoundItem
import com.example.pranksounds.data.source.local.SoundDatabase

class FavSoundsRepo {

    private lateinit var soundDatabase: SoundDatabase
    private var favSoundsList: LiveData<List<SoundItem>>? = null


    private fun initializeDB(context: Context): SoundDatabase {
        return SoundDatabase.getDatabaseClient(context)
    }

    fun getFavSounds(context: Context): LiveData<List<SoundItem>> {
        soundDatabase = initializeDB(context)
        return soundDatabase.soundDao().getAllSounds()
    }

    suspend fun deleteAllFavSounds(context: Context) {
        soundDatabase = initializeDB(context)
        soundDatabase.soundDao().deleteAllSounds()
    }
}