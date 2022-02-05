package com.ilham.detikcom_test.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_table")
data class Movie(
    val title: String = "",
    val overview: String = "",
    val release_date: String = "",
    val poster_path: String = ""
) {
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0
}