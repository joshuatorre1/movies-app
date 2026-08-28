package com.joshuatorre.moviesapp.presentation.screen.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.joshuatorre.moviesapp.domain.usecases.GetTvShowsUseCase
import com.joshuatorre.moviesapp.domain.usecases.UpdateTvShowsUseCase

class TvShowViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
) : ViewModel() {

    fun getTvShows() = liveData {
        val result = getTvShowsUseCase.execute()
        emit(result)
    }

    fun updateTvShows() = liveData {
        val result = updateTvShowsUseCase.execute()
        emit(result)
    }

}

class TvShowViewModelFactory(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvShowViewModel(getTvShowsUseCase, updateTvShowsUseCase) as T
    }
}