package com.joshuatorre.moviesapp.data.repository.people

import com.joshuatorre.moviesapp.data.model.people.PeopleList
import retrofit2.Response

interface PeopleRemoteDataSource {
    suspend fun getPeople(): Response<PeopleList>
}