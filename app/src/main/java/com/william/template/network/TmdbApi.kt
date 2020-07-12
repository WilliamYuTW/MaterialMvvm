package com.william.template.network

import com.william.template.model.network.GenreResponse
import com.william.template.model.network.PopularMovieResponse
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author WeiYi Yu
 * @date 2020-07-08
 */
interface TmdbApi {
    @GET("movie/popular")
    suspend fun getPopularMovies(): PopularMovieResponse

    @GET("movie/{movie_id}/credits")
    suspend fun getMovieCredits(@Path("movie_id") movieId: Int): PopularMovieResponse

    @GET("genre/movie/list")
    suspend fun getGenres(): GenreResponse
}