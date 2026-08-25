package com.joshuatorre.moviesapp.data.repository.movie

import com.joshuatorre.moviesapp.data.model.movie.MovieList
import com.joshuatorre.moviesapp.data.remote.TmdbService
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val apiKey: String,
    private val tmdbService: TmdbService
) : MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> =
        tmdbService.getPopularMovies(apiKey)
}