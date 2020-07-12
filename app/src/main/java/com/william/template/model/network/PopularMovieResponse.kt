package com.william.template.model.network

import com.squareup.moshi.Json
import com.william.template.model.database.DatabaseMovie

/**
 * @author WeiYi Yu
 * @date 2020-07-08
 */

data class PopularMovieResponse(
    @Json(name = "page") val page: Int,
    @Json(name = "results") val movies: List<TmdbMovie>,
    @Json(name = "total_results") val totalResults: Int,
    @Json(name = "total_pages") val totalPages: Int
)

fun PopularMovieResponse.asDatabaseModel(): Array<DatabaseMovie> {
    return movies.map {
        DatabaseMovie(
            id = it.id,
            adult = it.adult,
            backdropPath = it.backdropPath,
            overview = it.overview,
            posterPath = it.posterPath,
            title = it.title,
            voteAverage = it.voteAverage,
            genreIds = it.genreIds
        )
    }.toTypedArray()
}