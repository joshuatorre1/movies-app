package com.joshuatorre.moviesapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.joshuatorre.moviesapp.data.local.dao.movie.MovieDao
import com.joshuatorre.moviesapp.data.local.dao.people.PeopleDao
import com.joshuatorre.moviesapp.data.local.dao.tvshow.TvShowDao
import com.joshuatorre.moviesapp.data.model.movie.Movie
import com.joshuatorre.moviesapp.data.model.people.People
import com.joshuatorre.moviesapp.data.model.tvshow.TvShow

@Database(
    entities = [Movie::class, People::class, TvShow::class],
    version = 1,
    exportSchema = false)
abstract class LocalDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao
    abstract fun peopleDao(): PeopleDao
    abstract fun tvShowDao(): TvShowDao

}