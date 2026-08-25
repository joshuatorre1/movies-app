package com.joshuatorre.moviesapp.domain.repository

import com.joshuatorre.moviesapp.data.model.people.People

interface PeopleRepository {

    suspend fun getPeople(): List<People>?
    suspend fun updatePeople(): List<People>?

}