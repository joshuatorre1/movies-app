package com.joshuatorre.moviesapp.presentation.di

import com.joshuatorre.moviesapp.presentation.di.movie.MovieSubComponent
import com.joshuatorre.moviesapp.presentation.di.people.PeopleSubComponent
import com.joshuatorre.moviesapp.presentation.di.tvshow.TvShowSubComponent

interface Injector {

    fun createMovieSubComponent(): MovieSubComponent
    fun createPeopleSubComponent(): PeopleSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent

}