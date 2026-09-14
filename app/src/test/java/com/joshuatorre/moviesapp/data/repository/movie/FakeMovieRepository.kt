package com.joshuatorre.moviesapp.data.repository.movie

import com.joshuatorre.moviesapp.data.model.movie.Movie
import com.joshuatorre.moviesapp.domain.repository.MovieRepository

class FakeMovieRepository : MovieRepository {
    private val movies = mutableListOf<Movie>()

    init {
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
    }

    override suspend fun getMovies(): List<Movie> {
        return movies
    }

    override suspend fun updateMovies(): List<Movie> {
        movies.clear()
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
        return movies
    }

}