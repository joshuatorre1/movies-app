package com.joshuatorre.moviesapp.presentation.di.movie

import com.joshuatorre.moviesapp.presentation.screen.movie.MovieFragment
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {

    fun inject(movieFragment: MovieFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): MovieSubComponent
    }

}