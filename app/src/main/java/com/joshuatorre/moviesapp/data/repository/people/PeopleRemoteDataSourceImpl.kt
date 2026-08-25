package com.joshuatorre.moviesapp.data.repository.people

import com.joshuatorre.moviesapp.data.model.people.PeopleList
import com.joshuatorre.moviesapp.data.remote.TmdbService
import retrofit2.Response

class PeopleRemoteDataSourceImpl(
    private val apiKey: String,
    private val tmdbService: TmdbService
) : PeopleRemoteDataSource {
    override suspend fun getPeople(): Response<PeopleList> =
        tmdbService.getPopularPeople(apiKey)
}