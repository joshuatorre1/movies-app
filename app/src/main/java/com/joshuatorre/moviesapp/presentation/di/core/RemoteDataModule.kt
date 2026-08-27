package com.joshuatorre.moviesapp.presentation.di.core

import com.joshuatorre.moviesapp.data.remote.TmdbService
import com.joshuatorre.moviesapp.data.repository.movie.MovieRemoteDataSource
import com.joshuatorre.moviesapp.data.repository.movie.MovieRemoteDataSourceImpl
import com.joshuatorre.moviesapp.data.repository.people.PeopleRemoteDataSource
import com.joshuatorre.moviesapp.data.repository.people.PeopleRemoteDataSourceImpl
import com.joshuatorre.moviesapp.data.repository.tvshow.TvShowRemoteDataSource
import com.joshuatorre.moviesapp.data.repository.tvshow.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TmdbService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(apiKey, tmdbService)
    }

    @Singleton
    @Provides
    fun providePeopleRemoteDataSource(tmdbService: TmdbService): PeopleRemoteDataSource {
        return PeopleRemoteDataSourceImpl(apiKey, tmdbService)
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TmdbService): TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImpl(apiKey, tmdbService)
    }

}