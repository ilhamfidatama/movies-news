package com.ilham.detikcom_test.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ilham.detikcom_test.model.Movie

@Dao
interface MovieDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    fun insertMovies(movies: MutableList<Movie>)

    @Query("SELECT * FROM movie_table")
    fun getMovies(): MutableList<Movie>
}