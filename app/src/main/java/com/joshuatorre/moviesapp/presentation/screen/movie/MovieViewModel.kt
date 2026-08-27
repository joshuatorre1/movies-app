package com.joshuatorre.moviesapp.presentation.screen.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.joshuatorre.moviesapp.domain.usecases.GetMoviesUseCase
import com.joshuatorre.moviesapp.domain.usecases.UpdateMoviesUseCase

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModel() {

    fun getMovies() = liveData {
        val result = getMoviesUseCase.execute()
        emit(result)
    }

    fun updateMovies() = liveData {
        val result = updateMoviesUseCase.execute()
        emit(result)
    }

}

class MovieViewModelFactory(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieViewModel(getMoviesUseCase, updateMoviesUseCase) as T
    }
}