package com.ilham.detikcom_test

import android.content.Context
import androidx.room.Room
import com.ilham.detikcom_test.database.MovieDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideRunningDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        MovieDatabase::class.java,
        "movie_db"
    ).fallbackToDestructiveMigration().build()

    @Singleton
    @Provides
    fun provideRunDao(db: MovieDatabase) = db.getMovieDao()
}