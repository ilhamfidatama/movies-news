package com.ilham.movies_news

import com.ilham.movies_news.api.BaseResponse
import com.ilham.movies_news.api.RetrofitInstance
import com.ilham.movies_news.database.MovieDAO
import com.ilham.movies_news.model.Movie
import retrofit2.Response
import javax.inject.Inject

class MovieRepository @Inject constructor(private val db: MovieDAO) {
    private val apiKey = BuildConfig.apiKey
    private val language = BuildConfig.language

    suspend fun insertMovies(movies: MutableList<Movie>) = db.insertMovies(movies)

    suspend fun getMoviesOnline(): Response<BaseResponse> = RetrofitInstance.api.getMovies(apiKey, language)

    fun getMoviesOffline() = db.getMovies()
}