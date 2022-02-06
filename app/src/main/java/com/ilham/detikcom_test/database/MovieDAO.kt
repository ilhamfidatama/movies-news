package com.ilham.detikcom_test.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ilham.detikcom_test.model.Movie

@Dao
interface MovieDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    suspend fun insertMovies(movies: MutableList<Movie>)

    @Query("SELECT * FROM movie_table ORDER BY release_date DESC")
    fun getMovies(): LiveData<List<Movie>>
}