package com.william.template.network

/**
 * @author WeiYi Yu
 * @date 2020-07-10
 */
object TmdbUrl {
    const val API_PATH = "https://api.themoviedb.org/3/"
    private const val BASE_POSTER_PATH = "https://image.tmdb.org/t/p/original"
    private const val BASE_BACKDROP_PATH = "https://image.tmdb.org/t/p/original"

    fun getPosterPath(posterPath: String): String {
        return BASE_POSTER_PATH + posterPath
    }

    fun getBackdropPath(backdropPath: String): String {
        return BASE_BACKDROP_PATH + backdropPath
    }
}