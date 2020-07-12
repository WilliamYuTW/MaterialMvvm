package com.william.template.model.domain

import androidx.room.PrimaryKey

/**
 * @author WeiYi Yu
 * @date 2020-07-12
 */
data class Movie(
    @PrimaryKey val id: Int,
    val voteAverage: Double,
    val title: String,
    val overview: String,
    val adult: Boolean,
    val posterPath: String,
    val backdropPath: String,
    val genres: List<String>
)