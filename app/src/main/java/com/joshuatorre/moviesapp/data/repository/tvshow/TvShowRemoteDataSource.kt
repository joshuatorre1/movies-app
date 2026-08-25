package com.joshuatorre.moviesapp.data.repository.tvshow

import com.joshuatorre.moviesapp.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun getTvShows(): Response<TvShowList>
}