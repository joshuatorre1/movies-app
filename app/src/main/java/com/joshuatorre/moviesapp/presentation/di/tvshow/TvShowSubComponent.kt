package com.joshuatorre.moviesapp.presentation.di.tvshow

import com.joshuatorre.moviesapp.presentation.screen.tvshow.TvShowFragment
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {

    fun inject(tvShowFragment: TvShowFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): TvShowSubComponent
    }

}