package com.joshuatorre.moviesapp.presentation.di.core

import com.joshuatorre.moviesapp.data.repository.movie.MovieCacheDataSource
import com.joshuatorre.moviesapp.data.repository.movie.MovieCacheDataSourceImpl
import com.joshuatorre.moviesapp.data.repository.people.PeopleCacheDataSource
import com.joshuatorre.moviesapp.data.repository.people.PeopleCacheDataSourceImpl
import com.joshuatorre.moviesapp.data.repository.tvshow.TvShowCacheDataSource
import com.joshuatorre.moviesapp.data.repository.tvshow.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun providePeopleCacheDataSource(): PeopleCacheDataSource {
        return PeopleCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }

}