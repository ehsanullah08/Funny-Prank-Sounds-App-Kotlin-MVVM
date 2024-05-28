package com.example.pranksounds.data.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pranksounds.data.models.SoundItem
import com.example.pranksounds.utils.Constants
import kotlinx.coroutines.CoroutineScope
import javax.inject.Provider
import javax.inject.Inject


@Database(entities = [SoundItem::class], version = 1, exportSchema = false)
abstract class SoundDatabase : RoomDatabase() {
    abstract fun soundDao(): SoundDAO
}
