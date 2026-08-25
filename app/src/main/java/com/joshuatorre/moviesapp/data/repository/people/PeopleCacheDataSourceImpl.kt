package com.joshuatorre.moviesapp.data.repository.people

import com.joshuatorre.moviesapp.data.model.people.People

class PeopleCacheDataSourceImpl : PeopleCacheDataSource {
    private var peopleList = ArrayList<People>()

    override suspend fun getPeopleFromCache(): List<People> =
        peopleList

    override suspend fun savePeopleToCache(people: List<People>) {
        peopleList.clear()
        peopleList = ArrayList(people)
    }
}