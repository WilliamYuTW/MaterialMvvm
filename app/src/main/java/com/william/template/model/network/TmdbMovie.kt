package com.william.template.model.network

import com.squareup.moshi.Json
import com.william.template.model.database.DatabaseMovie

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
    @Json(name = "poster_path") val posterPath: String,
    @Json(name = "backdrop_path") val backdropPath: String
)

fun PopularMovie.asDatabaseModel(): Array<DatabaseMovie> {
    return movieList.map {
        DatabaseMovie(
            id = it.id,
            adult = it.adult,
            backdropPath = it.backdropPath,
            overview = it.overview,
            posterPath = it.posterPath,
            title = it.title,
            voteAverage = it.voteAverage
        )
    }.toTypedArray()
}