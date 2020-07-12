package com.william.template.model.database

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author WeiYi Yu
 * @date 2020-07-11
 */

@Entity(tableName = "movie_table")
data class DatabaseMovie(
    @PrimaryKey val id: Int,
    val voteAverage: Double,
    val title: String,
    val overview: String,
    val adult: Boolean,
    val posterPath: String,
    val backdropPath: String,
    val genreIds: List<Int>
)