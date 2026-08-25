package com.joshuatorre.moviesapp.domain.repository

import com.joshuatorre.moviesapp.data.model.tvshow.TvShow

interface TvShowRepository {

    suspend fun getTvShows(): List<TvShow>?
    suspend fun updateTvShows(): List<TvShow>?

}