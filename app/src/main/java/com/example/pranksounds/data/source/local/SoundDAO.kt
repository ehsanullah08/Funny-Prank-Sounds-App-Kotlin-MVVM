package com.example.pranksounds.data.source.local

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface SoundDAO {

    @Insert
    suspend fun markFav(sound: SoundItem)

    @Update
    suspend fun update(sound: SoundItem)

    @Query("SELECT * FROM sounds_table WHERE soundId = :soundId")
    fun getFavoriteSoundById(soundId: Int): SoundItem

    @Query("SELECT COUNT(*) FROM sounds_table WHERE soundId = :soundId")
    suspend fun isSoundExists(soundId: Int): Int

    @Query("DELETE FROM sounds_table WHERE soundId = :soundId")
    suspend fun removeFav(soundId: Int)

    @Delete
    suspend fun delete(sound: SoundItem)

    @Query("delete from sounds_table")
    suspend fun deleteAllSounds()

    @Query("select * from sounds_table")
    fun getAllSounds(): LiveData<List<SoundItem>>
}