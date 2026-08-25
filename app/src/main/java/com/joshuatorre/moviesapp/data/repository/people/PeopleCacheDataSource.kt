package com.joshuatorre.moviesapp.data.repository.people

import com.joshuatorre.moviesapp.data.model.people.People

interface PeopleCacheDataSource {
    suspend fun getPeopleFromCache(): List<People>
    suspend fun savePeopleToCache(people: List<People>)
}