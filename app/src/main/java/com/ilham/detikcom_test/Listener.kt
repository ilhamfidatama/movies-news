package com.ilham.detikcom_test

import com.ilham.detikcom_test.model.Movie

interface Listener {
    fun onSuccess(movies: MutableList<Movie>)
    fun onFailure()
}