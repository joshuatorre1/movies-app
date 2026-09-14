package com.joshuatorre.moviesapp.presentation.di.core

import com.joshuatorre.moviesapp.data.repository.movie.MovieCacheDataSource
import com.joshuatorre.moviesapp.data.repository.movie.MovieLocalDataSource
import com.joshuatorre.moviesapp.data.repository.movie.MovieRemoteDataSource
import com.joshuatorre.moviesapp.data.repository.movie.MovieRepositoryImpl
import com.joshuatorre.moviesapp.data.repository.people.PeopleCacheDataSource
import com.joshuatorre.moviesapp.data.repository.people.PeopleLocalDataSource
import com.joshuatorre.moviesapp.data.repository.people.PeopleRemoteDataSource
import com.joshuatorre.moviesapp.data.repository.people.PeopleRepositoryImpl
import com.joshuatorre.moviesapp.data.repository.tvshow.TvShowCacheDataSource
import com.joshuatorre.moviesapp.data.repository.tvshow.TvShowLocalDataSource
import com.joshuatorre.moviesapp.data.repository.tvshow.TvShowRemoteDataSource
import com.joshuatorre.moviesapp.data.repository.tvshow.TvShowRepositoryImpl
import com.joshuatorre.moviesapp.domain.repository.MovieRepository
import com.joshuatorre.moviesapp.domain.repository.PeopleRepository
import com.joshuatorre.moviesapp.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ) : MovieRepository {
        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }

    @Provides
    fun providePeopleRepository(
        peopleRemoteDataSource: PeopleRemoteDataSource,
        peopleLocalDataSource: PeopleLocalDataSource,
        peopleCacheDataSource: PeopleCacheDataSource
    ) : PeopleRepository {
        return PeopleRepositoryImpl(
            peopleRemoteDataSource,
            peopleLocalDataSource,
            peopleCacheDataSource
        )
    }

    @Provides
    fun provideTvShowRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ) : TvShowRepository {
        return TvShowRepositoryImpl(
            tvShowRemoteDataSource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )
    }

}