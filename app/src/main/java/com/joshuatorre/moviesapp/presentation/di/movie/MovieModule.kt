package com.joshuatorre.moviesapp.presentation.di.movie

import com.joshuatorre.moviesapp.domain.usecases.GetMoviesUseCase
import com.joshuatorre.moviesapp.domain.usecases.UpdateMoviesUseCase
import com.joshuatorre.moviesapp.presentation.screen.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
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