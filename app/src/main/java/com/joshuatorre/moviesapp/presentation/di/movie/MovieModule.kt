package com.joshuatorre.moviesapp.presentation.di.movie

import com.joshuatorre.moviesapp.domain.usecases.GetMoviesUseCase
import com.joshuatorre.moviesapp.domain.usecases.UpdateMoviesUseCase
import com.joshuatorre.moviesapp.presentation.screen.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.FragmentScoped

@Module
@InstallIn(FragmentComponent::class)
class MovieModule {

    @FragmentScoped
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ) : MovieViewModelFactory {
        return MovieViewModelFactory(
            getMoviesUseCase,
            updateMoviesUseCase
        )
    }

}