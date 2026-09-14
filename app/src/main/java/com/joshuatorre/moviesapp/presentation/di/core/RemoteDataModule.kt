package com.joshuatorre.moviesapp.presentation.di.core

import com.joshuatorre.moviesapp.BuildConfig
import com.joshuatorre.moviesapp.data.remote.TmdbService
import com.joshuatorre.moviesapp.data.repository.movie.MovieRemoteDataSource
import com.joshuatorre.moviesapp.data.repository.movie.MovieRemoteDataSourceImpl
import com.joshuatorre.moviesapp.data.repository.people.PeopleRemoteDataSource
import com.joshuatorre.moviesapp.data.repository.people.PeopleRemoteDataSourceImpl
import com.joshuatorre.moviesapp.data.repository.tvshow.TvShowRemoteDataSource
import com.joshuatorre.moviesapp.data.repository.tvshow.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule {

    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TmdbService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(BuildConfig.API_KEY, tmdbService)
    }

    @Provides
    fun providePeopleRemoteDataSource(tmdbService: TmdbService): PeopleRemoteDataSource {
        return PeopleRemoteDataSourceImpl(BuildConfig.API_KEY, tmdbService)
    }

    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TmdbService): TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImpl(BuildConfig.API_KEY, tmdbService)
    }

}