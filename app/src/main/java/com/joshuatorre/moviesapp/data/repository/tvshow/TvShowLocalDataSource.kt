package com.joshuatorre.moviesapp.data.repository.tvshow

import com.joshuatorre.moviesapp.data.model.tvshow.TvShow

interface TvShowLocalDataSource {
    suspend fun getTvShowsFromDb(): List<TvShow>
    suspend fun saveTvShowsToDb(tvShows: List<TvShow>)
    suspend fun clearAll()
}