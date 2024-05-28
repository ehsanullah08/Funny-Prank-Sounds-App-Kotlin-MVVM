package com.example.pranksounds.data.repositories

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.pranksounds.data.models.SoundItem
import com.example.pranksounds.data.source.local.SoundDAO
import com.example.pranksounds.data.source.local.SoundDatabase
import javax.inject.Inject

class FavSoundsRepo @Inject constructor(private val soundDAO: SoundDAO) {

    fun getFavSounds(): LiveData<List<SoundItem>> {
        return soundDAO.getAllSounds()
    }

    suspend fun deleteAllFavSounds() {
        soundDAO.deleteAllSounds()
    }
}