package com.joshuatorre.moviesapp.presentation.di.core

import android.content.Context
import com.joshuatorre.moviesapp.presentation.di.movie.MovieSubComponent
import com.joshuatorre.moviesapp.presentation.di.people.PeopleSubComponent
import com.joshuatorre.moviesapp.presentation.di.tvshow.TvShowSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [
    MovieSubComponent::class,
    PeopleSubComponent::class,
    TvShowSubComponent::class
])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext(): Context {
        return context.applicationContext
    }

}