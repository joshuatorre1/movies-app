package com.joshuatorre.moviesapp.data.repository.people

import com.joshuatorre.moviesapp.data.local.dao.people.PeopleDao
import com.joshuatorre.moviesapp.data.model.people.People
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PeopleLocalDataSourceImpl(private val peopleDao: PeopleDao) : PeopleLocalDataSource {
    override suspend fun getPeopleFromDb(): List<People> =
        peopleDao.getPeople()

    override suspend fun savePeopleToDb(people: List<People>) {
        CoroutineScope(Dispatchers.IO).launch {
            peopleDao.savePeople(people)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            peopleDao.deleteAllPeople()
        }
    }
}