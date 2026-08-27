package com.joshuatorre.moviesapp.presentation.di.core

import com.joshuatorre.moviesapp.domain.repository.MovieRepository
import com.joshuatorre.moviesapp.domain.repository.PeopleRepository
import com.joshuatorre.moviesapp.domain.repository.TvShowRepository
import com.joshuatorre.moviesapp.domain.usecases.GetMoviesUseCase
import com.joshuatorre.moviesapp.domain.usecases.GetPeopleUseCase
import com.joshuatorre.moviesapp.domain.usecases.GetTvShowsUseCase
import com.joshuatorre.moviesapp.domain.usecases.UpdateMoviesUseCase
import com.joshuatorre.moviesapp.domain.usecases.UpdatePeopleUseCase
import com.joshuatorre.moviesapp.domain.usecases.UpdateTvShowsUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetMoviesUseCase(movieRepository: MovieRepository): GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideUpdateMoviesUseCase(movieRepository: MovieRepository): UpdateMoviesUseCase {
        return UpdateMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideGetPeopleUseCase(peopleRepository: PeopleRepository): GetPeopleUseCase {
        return GetPeopleUseCase(peopleRepository)
    }

    @Provides
    fun provideUpdatePeopleUseCase(peopleRepository: PeopleRepository): UpdatePeopleUseCase {
        return UpdatePeopleUseCase(peopleRepository)
    }

    @Provides
    fun provideGetTvShowsUseCase(tvShowRepository: TvShowRepository): GetTvShowsUseCase {
        return GetTvShowsUseCase(tvShowRepository)
    }

    @Provides
    fun provideUpdateTvShowsUseCase(tvShowRepository: TvShowRepository): UpdateTvShowsUseCase {
        return UpdateTvShowsUseCase(tvShowRepository)
    }

}