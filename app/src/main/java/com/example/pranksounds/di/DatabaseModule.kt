package com.example.pranksounds.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.pranksounds.data.source.local.SoundDAO
import com.example.pranksounds.data.source.local.SoundDatabase
import com.example.pranksounds.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        SoundDatabase::class.java,
        Constants.DATABASE_NAME
    ).build()

    @Provides
    @Singleton
    fun provideSoundDao(db: SoundDatabase) = db.soundDao()
}
