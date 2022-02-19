package com.ilham.movies_news.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_table")
data class Movie(
    val title: String = "",
    val overview: String = "",
    val release_date: String = "",
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0
)