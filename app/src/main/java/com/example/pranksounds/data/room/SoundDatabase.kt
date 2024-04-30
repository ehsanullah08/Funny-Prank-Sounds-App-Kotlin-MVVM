package com.example.pranksounds.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.pranksounds.utils.Constants

@Database(entities = [Sound::class], version = 1)
abstract class SoundDatabase : RoomDatabase() {

    abstract fun soundDao(): SoundDAO

    companion object {

        @Volatile
        private var INSTANCE: SoundDatabase? = null

        fun getDatabaseClient(context: Context): SoundDatabase {

            if (INSTANCE != null) return INSTANCE!!

            synchronized(this) {

                INSTANCE = Room
                    .databaseBuilder(context, SoundDatabase::class.java, Constants.DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .build()

                return INSTANCE!!

            }
        }
    }
}