package com.joshuatorre.moviesapp.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.joshuatorre.moviesapp.data.local.LocalDatabase
import com.joshuatorre.moviesapp.data.local.dao.movie.MovieDao
import com.joshuatorre.moviesapp.data.local.dao.people.PeopleDao
import com.joshuatorre.moviesapp.data.local.dao.tvshow.TvShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideMovieDatabase(context: Context): LocalDatabase {
        return Room.databaseBuilder(
            context,
            LocalDatabase::class.java,
            "MoviesAppDb").build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(localDatabase: LocalDatabase): MovieDao {
        return localDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun providePeopleDao(localDatabase: LocalDatabase): PeopleDao {
        return localDatabase.peopleDao()
    }

    @Singleton
    @Provides
    fun provideTvShowDao(localDatabase: LocalDatabase): TvShowDao {
        return localDatabase.tvShowDao()
    }

}