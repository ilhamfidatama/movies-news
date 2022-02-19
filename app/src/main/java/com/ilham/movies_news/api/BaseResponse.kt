package com.ilham.movies_news.api

import com.ilham.movies_news.model.Movie

data class BaseResponse(
    val page: Int,
    val results: MutableList<Movie>
)
