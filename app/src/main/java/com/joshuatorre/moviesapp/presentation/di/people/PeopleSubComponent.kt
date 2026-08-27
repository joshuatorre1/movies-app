package com.joshuatorre.moviesapp.presentation.di.people

import com.joshuatorre.moviesapp.presentation.screen.people.PeopleFragment
import dagger.Subcomponent

@PeopleScope
@Subcomponent(modules = [PeopleModule::class])
interface PeopleSubComponent {

    fun inject(peopleFragment: PeopleFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): PeopleSubComponent
    }

}