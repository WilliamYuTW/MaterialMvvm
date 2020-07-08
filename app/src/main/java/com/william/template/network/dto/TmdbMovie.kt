package com.william.template.network.dto

import com.squareup.moshi.Json

/**
 * @author WeiYi Yu
 * @date 2020-07-08
 */

data class PopularMovie(
    @Json(name = "results") val movieList: List<TmdbMovie>
)

data class TmdbMovie(
    @Json(name = "id") val id: Int,
    @Json(name = "vote_average") val voteAverage: Double,
    @Json(name = "title") val title: String,
    @Json(name = "overview") val overview: String,
    @Json(name = "adult") val adult: Boolean,
    @Json(name = "poster_path") val posterPath: String
)