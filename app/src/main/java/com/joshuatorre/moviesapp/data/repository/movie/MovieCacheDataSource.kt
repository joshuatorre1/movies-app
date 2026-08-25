package com.joshuatorre.moviesapp.data.repository.movie

import com.joshuatorre.moviesapp.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache(): List<Movie>
    suspend fun saveMoviesToCache(movies: List<Movie>)
}