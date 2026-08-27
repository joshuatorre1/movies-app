package com.joshuatorre.moviesapp.presentation.di.tvshow

import com.joshuatorre.moviesapp.domain.usecases.GetTvShowsUseCase
import com.joshuatorre.moviesapp.domain.usecases.UpdateTvShowsUseCase
import com.joshuatorre.moviesapp.presentation.screen.tvshow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ) : TvShowViewModelFactory {
        return TvShowViewModelFactory(
            getTvShowsUseCase,
            updateTvShowsUseCase
        )
    }

}