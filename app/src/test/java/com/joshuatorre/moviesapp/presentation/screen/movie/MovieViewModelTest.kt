package com.joshuatorre.moviesapp.presentation.screen.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.joshuatorre.moviesapp.data.model.movie.Movie
import com.joshuatorre.moviesapp.data.repository.movie.FakeMovieRepository
import com.joshuatorre.moviesapp.domain.usecases.GetMoviesUseCase
import com.joshuatorre.moviesapp.domain.usecases.UpdateMoviesUseCase
import com.joshuatorre.moviesapp.getOrAwaitValue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieViewModelTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MovieViewModel

    @Before
    fun setUp() {
        val fakeMovieRepository = FakeMovieRepository()
        val getMoviesUseCase = GetMoviesUseCase(fakeMovieRepository)
        val updateMoviesUseCase = UpdateMoviesUseCase(fakeMovieRepository)
        viewModel = MovieViewModel(getMoviesUseCase, updateMoviesUseCase)
    }

    @Test
    fun getMovies_executeUseCase_resultSuccess() {
        val movies = mutableListOf<Movie>()
        movies.add(
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
            )
        )
        movies.add(
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
        val currentList = viewModel.getMovies().getOrAwaitValue()
        assertThat(currentList).isEqualTo(movies)
    }

    @Test
    fun updateMovies_executeUseCase_resultSuccess() {
        val movies = mutableListOf<Movie>()
        movies.add(
            Movie(
                adult = false,
                backdropPath = "backdropPath/2",
                id = 2,
                originalLanguage = "English",
                originalTitle = "MovieTest2",
                overview = "MovieTestTwo",
                popularity = 1.0,
                posterPath = "posterPath/2",
                releaseDate = "September 3, 2026",
                title = "MovieTest2",
                video = false,
                voteAverage = 1.0,
                voteCount = 1
            )
        )
        movies.add(
            Movie(
                adult = false,
                backdropPath = "backdropPath/3",
                id = 3,
                originalLanguage = "English",
                originalTitle = "MovieTest3",
                overview = "MovieTestThree",
                popularity = 1.0,
                posterPath = "posterPath/3",
                releaseDate = "September 3, 2026",
                title = "MovieTest3",
                video = false,
                voteAverage = 1.0,
                voteCount = 1
            )
        )

        val updatedList = viewModel.updateMovies().getOrAwaitValue()
        assertThat(updatedList).isEqualTo(movies)
    }

}