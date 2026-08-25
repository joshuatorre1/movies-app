package com.joshuatorre.moviesapp.data.repository.people

import android.util.Log
import com.joshuatorre.moviesapp.data.model.people.People
import com.joshuatorre.moviesapp.domain.repository.PeopleRepository

class PeopleRepositoryImpl(
    private val peopleRemoteDataSource: PeopleRemoteDataSource,
    private val peopleLocalDataSource: PeopleLocalDataSource,
    private val peopleCacheDataSource: PeopleCacheDataSource
) : PeopleRepository {

    companion object {
        private val TAG = PeopleRepositoryImpl::class.simpleName
    }

    override suspend fun getPeople(): List<People>? =
        getPeopleFromCache()

    override suspend fun updatePeople(): List<People>? {
        val newListOfPeople = getPeopleFromApi()
        peopleLocalDataSource.clearAll()
        peopleLocalDataSource.savePeopleToDb(newListOfPeople)
        peopleCacheDataSource.savePeopleToCache(newListOfPeople)
        return newListOfPeople
    }

    private suspend fun getPeopleFromApi(): List<People> {
        lateinit var peopleList: List<People>
        try {
            val response = peopleRemoteDataSource.getPeople()
            val body = response.body()
            if (body != null) {
                peopleList = body.people
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error getting people list from server. ${e.message}")
        }
        return peopleList
    }

    private suspend fun getPeopleFromDb(): List<People> {
        lateinit var peopleList: List<People>
        try {
            peopleList = peopleLocalDataSource.getPeopleFromDb()
        } catch (e: Exception) {
            Log.e(TAG, "Error getting people list from database. ${e.message}")
        }

        if (peopleList.isEmpty()) {
            peopleList = getPeopleFromApi()
            peopleLocalDataSource.savePeopleToDb(peopleList)
        }

        return peopleList
    }

    private suspend fun getPeopleFromCache(): List<People> {
        lateinit var peopleList: List<People>
        try {
            peopleList = peopleCacheDataSource.getPeopleFromCache()
        } catch (e: Exception) {
            Log.e(TAG, "Error getting people list from cache. ${e.message}")
        }

        if (peopleList.isEmpty()) {
            peopleList = getPeopleFromDb()
            peopleCacheDataSource.savePeopleToCache(peopleList)
        }

        return peopleList
    }
}