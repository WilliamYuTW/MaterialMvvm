package com.william.template.network

import com.william.template.network.dto.PopularMovie
import retrofit2.http.GET

/**
 * @author WeiYi Yu
 * @date 2020-07-08
 */
interface TmdbApi {
    @GET("movie/popular")
    suspend fun getPopularMovies(): PopularMovie
}