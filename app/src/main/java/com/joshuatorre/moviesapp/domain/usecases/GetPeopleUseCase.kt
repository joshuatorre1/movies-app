package com.joshuatorre.moviesapp.domain.usecases

import com.joshuatorre.moviesapp.data.model.people.People
import com.joshuatorre.moviesapp.domain.repository.PeopleRepository

class GetPeopleUseCase(private val peopleRepository: PeopleRepository) {

    suspend fun execute(): List<People>? = peopleRepository.getPeople()

}