package com.joshuatorre.moviesapp.domain.repository

import com.joshuatorre.moviesapp.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?

}