package com.joshuatorre.moviesapp.presentation.di.people

import com.joshuatorre.moviesapp.domain.usecases.GetPeopleUseCase
import com.joshuatorre.moviesapp.domain.usecases.UpdatePeopleUseCase
import com.joshuatorre.moviesapp.presentation.screen.people.PeopleViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.FragmentScoped

@Module
@InstallIn(FragmentComponent::class)
class PeopleModule {

    @FragmentScoped
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