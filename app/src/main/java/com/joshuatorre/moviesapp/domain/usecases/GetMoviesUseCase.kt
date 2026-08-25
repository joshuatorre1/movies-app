package com.joshuatorre.moviesapp.domain.usecases

import com.joshuatorre.moviesapp.data.model.movie.Movie
import com.joshuatorre.moviesapp.domain.repository.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute(): List<Movie>? = movieRepository.getMovies()

}