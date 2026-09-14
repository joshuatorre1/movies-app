package com.joshuatorre.moviesapp.presentation.di.tvshow

import com.joshuatorre.moviesapp.domain.usecases.GetTvShowsUseCase
import com.joshuatorre.moviesapp.domain.usecases.UpdateTvShowsUseCase
import com.joshuatorre.moviesapp.presentation.screen.tvshow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.FragmentScoped

@Module
@InstallIn(FragmentComponent::class)
class TvShowModule {

    @FragmentScoped
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