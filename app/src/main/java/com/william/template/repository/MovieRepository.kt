package com.william.template.repository

import androidx.lifecycle.LiveData
import com.william.template.database.MovieDao
import com.william.template.model.database.DatabaseMovie
import com.william.template.model.network.asDatabaseModel
import com.william.template.network.TmdbApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

/**
 * @author WeiYi Yu
 * @date 2020-07-11
 */

class MovieRepository(private val movieDao: MovieDao, val tmdbApi: TmdbApi) {
    val movies: LiveData<List<DatabaseMovie>> = movieDao.getMovies()

    suspend fun getPopularMovies() = withContext(Dispatchers.IO) {
        try {
            val popularMovies = tmdbApi.getPopularMovies()
            movieDao.insertAll(*popularMovies.asDatabaseModel())
        } catch (e: Exception) {
            Timber.e("Updated popular movies not available")
        }

    }
}