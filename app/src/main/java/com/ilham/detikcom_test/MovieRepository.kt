package com.ilham.detikcom_test

import com.ilham.detikcom_test.api.BaseResponse
import com.ilham.detikcom_test.api.RetrofitInstance
import com.ilham.detikcom_test.database.MovieDAO
import com.ilham.detikcom_test.model.Movie
import retrofit2.Response
import javax.inject.Inject

class MovieRepository @Inject constructor(private val db: MovieDAO) {
    private val apiKey = BuildConfig.apiKey
    private val language = BuildConfig.language

    suspend fun insertMovies(movies: MutableList<Movie>) = db.insertMovies(movies)

    suspend fun getMoviesOnline(): Response<BaseResponse> = RetrofitInstance.api.getMovies(apiKey, language)

    fun getMoviesOffline() = db.getMovies()
}