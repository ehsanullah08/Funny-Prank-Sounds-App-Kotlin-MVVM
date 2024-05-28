package com.example.pranksounds.di

import com.example.pranksounds.data.repositories.FavSoundsRepo
import com.example.pranksounds.data.repositories.HomeRepo
import com.example.pranksounds.data.repositories.LanguagesListRepo
import com.example.pranksounds.data.repositories.PlaySoundsRepo
import com.example.pranksounds.data.repositories.SoundsListRepo
import com.example.pranksounds.data.source.local.SoundDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataRepositoryModule {

    @Singleton
    @Provides
    fun provideLanguagesListRepo(): LanguagesListRepo {
        return LanguagesListRepo()
    }

    @Singleton
    @Provides
    fun provideFavSoundsRepo(soundDAO: SoundDAO): FavSoundsRepo {
        return FavSoundsRepo(soundDAO)
    }

    @Singleton
    @Provides
    fun provideHomeRepo(): HomeRepo {
        return HomeRepo()
    }

    @Singleton
    @Provides
    fun providePlaySoundsRepo(soundDAO: SoundDAO): PlaySoundsRepo {
        return PlaySoundsRepo(soundDAO)
    }

    @Singleton
    @Provides
    fun provideSoundsListRepo(): SoundsListRepo {
        return SoundsListRepo()
    }
}
