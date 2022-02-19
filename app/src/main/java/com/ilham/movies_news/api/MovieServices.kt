package com.ilham.movies_news.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieServices {
    @GET("discover/movie")
    suspend fun getMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): Response<BaseResponse>
}