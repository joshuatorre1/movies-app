package com.joshuatorre.moviesapp.domain.usecases

import com.joshuatorre.moviesapp.data.model.tvshow.TvShow
import com.joshuatorre.moviesapp.domain.repository.TvShowRepository

class GetTvShowsUseCase(private val tvShowRepository: TvShowRepository) {

    suspend fun execute(): List<TvShow>? = tvShowRepository.getTvShows()

}