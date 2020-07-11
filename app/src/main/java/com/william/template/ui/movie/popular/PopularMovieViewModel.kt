package com.william.template.ui.movie.popular

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.william.template.model.database.DatabaseMovie
import com.william.template.repository.MovieRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class PopularMovieViewModel @ViewModelInject constructor(
    private val movieRepository: MovieRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val viewModelJob = Job()
    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    val popularMovieList: LiveData<List<DatabaseMovie>> = movieRepository.movies

    init {
        viewModelScope.launch {
            movieRepository.getPopularMovies()
        }
    }

    override fun onCleared() {
        viewModelJob.cancel()
    }
}