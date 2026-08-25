package com.joshuatorre.moviesapp.data.repository.tvshow

import com.joshuatorre.moviesapp.data.model.tvshow.TvShowList
import com.joshuatorre.moviesapp.data.remote.TmdbService
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val apiKey: String,
    private val tmdbService: TmdbService
) : TvShowRemoteDataSource {
    override suspend fun getTvShows(): Response<TvShowList> =
        tmdbService.getPopularTvShows(apiKey)
}