package com.joshuatorre.moviesapp.data.remote

import com.joshuatorre.moviesapp.data.model.movie.MovieList
import com.joshuatorre.moviesapp.data.model.people.PeopleList
import com.joshuatorre.moviesapp.data.model.tvshow.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TmdbService {

    @GET("/person/popular")
    suspend fun getPopularPeople(
        @Query(
            "api_key"
        ) apiKey: String
    ): Response<PeopleList>

    @GET("/movie/popular")
    suspend fun getPopularMovies(
        @Query(
            "api_key"
        ) apiKey: String
    ): Response<MovieList>

    @GET("/tv/popular")
    suspend fun getPopularTvShows(
        @Query(
            "api_key"
        ) apiKey: String
    ): Response<TvShowList>

}