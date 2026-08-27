package com.joshuatorre.moviesapp.presentation.di.people

import com.joshuatorre.moviesapp.domain.usecases.GetPeopleUseCase
import com.joshuatorre.moviesapp.domain.usecases.UpdatePeopleUseCase
import com.joshuatorre.moviesapp.presentation.screen.people.PeopleViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PeopleModule {

    @PeopleScope
    @Provides
    fun providePeopleViewModelFactory(
        getPeopleUseCase: GetPeopleUseCase,
        updatePeopleUseCase: UpdatePeopleUseCase
    ) : PeopleViewModelFactory {
        return PeopleViewModelFactory(
            getPeopleUseCase,
            updatePeopleUseCase
        )
    }

}