package com.joshuatorre.moviesapp.presentation.screen.people

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.joshuatorre.moviesapp.domain.usecases.GetPeopleUseCase

class PeopleViewModel(
    private val getPeopleUseCase: GetPeopleUseCase,
    private val updatePeopleUseCase: GetPeopleUseCase
) : ViewModel() {

    fun getPeople() = liveData {
        val result = getPeopleUseCase.execute()
        emit(result)
    }

    fun updatePeople() = liveData {
        val result = updatePeopleUseCase.execute()
        emit(result)
    }

}

class PeopleViewModelFactory(
    private val getPeopleUseCase: GetPeopleUseCase,
    private val updatePeopleUseCase: GetPeopleUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PeopleViewModel(getPeopleUseCase, updatePeopleUseCase) as T
    }
}