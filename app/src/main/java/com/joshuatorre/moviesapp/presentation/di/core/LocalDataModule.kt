package com.joshuatorre.moviesapp.presentation.di.core

import com.joshuatorre.moviesapp.data.local.dao.movie.MovieDao
import com.joshuatorre.moviesapp.data.local.dao.people.PeopleDao
import com.joshuatorre.moviesapp.data.local.dao.tvshow.TvShowDao
import com.joshuatorre.moviesapp.data.repository.movie.MovieLocalDataSource
import com.joshuatorre.moviesapp.data.repository.movie.MovieLocalDataSourceImpl
import com.joshuatorre.moviesapp.data.repository.people.PeopleLocalDataSource
import com.joshuatorre.moviesapp.data.repository.people.PeopleLocalDataSourceImpl
import com.joshuatorre.moviesapp.data.repository.tvshow.TvShowLocalDataSource
import com.joshuatorre.moviesapp.data.repository.tvshow.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun providePeopleLocalDataSource(peopleDao: PeopleDao): PeopleLocalDataSource {
        return PeopleLocalDataSourceImpl(peopleDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDao)
    }

}