package com.openwebinars.filmapp.di

import android.app.Application
import androidx.room.Room
import com.openwebinars.filmapp.data.api.FilmApiClient
import com.openwebinars.filmapp.data.api.RetrofitBuilder
import com.openwebinars.filmapp.data.database.FilmDao
import com.openwebinars.filmapp.data.database.FilmDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideApiServiceClient():FilmApiClient =
        RetrofitBuilder.build()
            .create(FilmApiClient::class.java)
    @Singleton
    @Provides
    fun provideRoom(application: Application): FilmDao =
        Room.databaseBuilder(application, FilmDb::class.java,"film").build().filmDao()
}