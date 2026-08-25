package com.joshuatorre.moviesapp.data.repository.people

import com.joshuatorre.moviesapp.data.model.people.People

interface PeopleLocalDataSource {
    suspend fun getPeopleFromDb(): List<People>
    suspend fun savePeopleToDb(people: List<People>)
    suspend fun clearAll()
}