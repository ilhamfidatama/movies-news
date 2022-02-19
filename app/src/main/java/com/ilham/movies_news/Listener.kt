package com.ilham.movies_news

import com.ilham.movies_news.model.Movie

interface Listener {
    fun onSuccess(movies: MutableList<Movie>)
    fun onFailure()
}