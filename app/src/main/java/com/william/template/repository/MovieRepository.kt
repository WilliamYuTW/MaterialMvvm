package com.william.template.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.william.template.database.AppDatabase
import com.william.template.model.database.DatabaseGenre
import com.william.template.model.database.DatabaseMovie
import com.william.template.model.domain.Movie
import com.william.template.model.network.asDatabaseModel
import com.william.template.network.TmdbApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

/**
 * @author WeiYi Yu
 * @date 2020-07-11
 */

class MovieRepository(private val appDatabase: AppDatabase, val tmdbApi: TmdbApi) {
    private val _movies: LiveData<List<DatabaseMovie>> = appDatabase.movieDao.getMovies()
    private val _genres: LiveData<List<DatabaseGenre>> = appDatabase.genreDao.getGenres()
    private val _domainMovies: MediatorLiveData<List<Movie>> = MediatorLiveData()
    val domainMovie: LiveData<List<Movie>> = _domainMovies

    private var fetchedMovies = false
    private var fetchedGenres = false

    init {
        _domainMovies.addSource(_movies) {
            fetchedMovies = true
            mapResult()
        }
        _domainMovies.addSource(_genres) {
            fetchedGenres = true
            mapResult()
        }
    }

    private fun mapResult() {
        // TODO: Better way to do this?
        if (fetchedMovies && fetchedGenres) {
            _domainMovies.postValue(_movies.value?.map { it ->
                Movie(id = it.id,
                    adult = it.adult,
                    backdropPath = it.backdropPath,
                    overview = it.overview,
                    posterPath = it.posterPath,
                    title = it.title,
                    voteAverage = it.voteAverage,
                    genres = it.genreIds.map { genreId ->
                        _genres.value?.find { it.id == genreId }?.name ?: ""
                    })
            })
        }
    }

    suspend fun getPopularMovies() = withContext(Dispatchers.IO) {
        try {
            val popularMovies = tmdbApi.getPopularMovies()
            appDatabase.movieDao.insertAll(*popularMovies.asDatabaseModel())
        } catch (e: Exception) {
            Timber.e("Updated popular movies not available")
        }
    }

    suspend fun getGenres() = withContext(Dispatchers.IO) {
        try {
            val genres = tmdbApi.getGenres()
            appDatabase.genreDao.insertAll(*genres.asDatabaseModel())
        } catch (e: Exception) {
            Timber.e("Updated genres not available")
        }
    }
}