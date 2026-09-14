package com.joshuatorre.moviesapp.presentation.di.core

import android.app.Application
import androidx.room.Room
import com.joshuatorre.moviesapp.data.local.LocalDatabase
import com.joshuatorre.moviesapp.data.local.dao.movie.MovieDao
import com.joshuatorre.moviesapp.data.local.dao.people.PeopleDao
import com.joshuatorre.moviesapp.data.local.dao.tvshow.TvShowDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    fun provideMovieDatabase(app: Application): LocalDatabase {
        return Room.databaseBuilder(
            app,
            LocalDatabase::class.java,
            "MoviesAppDb")
            .fallbackToDestructiveMigration(dropAllTables = true)
            .build()
    }

    @Provides
    fun provideMovieDao(localDatabase: LocalDatabase): MovieDao {
        return localDatabase.movieDao()
    }

    @Provides
    fun providePeopleDao(localDatabase: LocalDatabase): PeopleDao {
        return localDatabase.peopleDao()
    }

    @Provides
    fun provideTvShowDao(localDatabase: LocalDatabase): TvShowDao {
        return localDatabase.tvShowDao()
    }

}