package com.joshuatorre.moviesapp.data.local.dao.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import com.joshuatorre.moviesapp.data.local.LocalDatabase
import com.joshuatorre.moviesapp.data.model.movie.Movie
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieDaoTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var dao: MovieDao
    private lateinit var database: LocalDatabase

    @Before
    fun setUp() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            LocalDatabase::class.java
        ).build()
        dao = database.movieDao()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun saveMovies_insertToDb_resultSuccess() = runBlocking {
        val movies = listOf(
            Movie(
                adult = false,
                backdropPath = "backdropPath/0",
                id = 0,
                originalLanguage = "English",
                originalTitle = "MovieTest0",
                overview = "MovieTestZero",
                popularity = 1.0,
                posterPath = "posterPath/0",
                releaseDate = "September 3, 2026",
                title = "MovieTest0",
                video = false,
                voteAverage = 1.0,
                voteCount = 1
            ),
            Movie(
                adult = false,
                backdropPath = "backdropPath/1",
                id = 1,
                originalLanguage = "English",
                originalTitle = "MovieTest1",
                overview = "MovieTestOne",
                popularity = 1.0,
                posterPath = "posterPath/1",
                releaseDate = "September 3, 2026",
                title = "MovieTest1",
                video = false,
                voteAverage = 1.0,
                voteCount = 1
            )
        )
        dao.saveMovies(movies)
        val moviesFromDb = dao.getMovies()
        Truth.assertThat(moviesFromDb).isEqualTo(movies)
    }

    @Test
    fun deleteMovies_insertToDb_resultSuccess() = runBlocking {
        val movies = listOf(
            Movie(
                adult = false,
                backdropPath = "backdropPath/0",
                id = 0,
                originalLanguage = "English",
                originalTitle = "MovieTest0",
                overview = "MovieTestZero",
                popularity = 1.0,
                posterPath = "posterPath/0",
                releaseDate = "September 3, 2026",
                title = "MovieTest0",
                video = false,
                voteAverage = 1.0,
                voteCount = 1
            ),
            Movie(
                adult = false,
                backdropPath = "backdropPath/1",
                id = 1,
                originalLanguage = "English",
                originalTitle = "MovieTest1",
                overview = "MovieTestOne",
                popularity = 1.0,
                posterPath = "posterPath/1",
                releaseDate = "September 3, 2026",
                title = "MovieTest1",
                video = false,
                voteAverage = 1.0,
                voteCount = 1
            )
        )
        dao.saveMovies(movies)
        dao.deleteAllMovies()
        val moviesFromDb = dao.getMovies()
        Truth.assertThat(moviesFromDb).isEmpty()
    }
}