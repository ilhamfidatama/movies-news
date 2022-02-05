package com.ilham.detikcom_test.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ilham.detikcom_test.model.Movie

@Database(
    entities = [Movie::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class MovieDatabase: RoomDatabase() {
    abstract fun getMovieDao(): MovieDAO
}