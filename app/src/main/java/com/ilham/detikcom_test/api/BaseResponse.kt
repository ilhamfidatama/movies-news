package com.ilham.detikcom_test.api

import com.ilham.detikcom_test.model.Movie

data class BaseResponse(
    val page: Int,
    val results: MutableList<Movie>
)
