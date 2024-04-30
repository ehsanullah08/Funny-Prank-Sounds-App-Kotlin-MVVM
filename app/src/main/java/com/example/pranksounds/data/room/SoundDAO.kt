package com.example.pranksounds.data.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*

@Dao
interface SoundDAO {

    @Insert
    suspend fun markFav(sound: Sound)

    @Update
    suspend fun update(sound: Sound)

    @Query("SELECT * FROM sounds_table WHERE soundId = :soundId")
    fun getFavoriteSoundById(soundId: Int): Sound

    @Query("SELECT COUNT(*) FROM sounds_table WHERE soundId = :soundId")
    suspend fun isSoundExists(soundId: Int): Int

    @Query("DELETE FROM sounds_table WHERE soundId = :soundId")
    suspend fun removeFav(soundId: Int)

    @Delete
    suspend fun delete(sound: Sound)

    @Query("delete from sounds_table")
    suspend fun deleteAllSounds()

    @Query("select * from sounds_table")
    fun getAllSounds(): LiveData<List<Sound>>
}