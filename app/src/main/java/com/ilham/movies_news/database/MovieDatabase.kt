package com.ilham.movies_news.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ilham.movies_news.model.Movie

@Database(
    entities = [Movie::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class MovieDatabase: RoomDatabase() {
    abstract fun getMovieDao(): MovieDAO

}