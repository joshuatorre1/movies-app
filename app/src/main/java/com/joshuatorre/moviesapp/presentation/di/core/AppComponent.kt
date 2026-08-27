package com.joshuatorre.moviesapp.presentation.di.core

import com.joshuatorre.moviesapp.presentation.di.movie.MovieSubComponent
import com.joshuatorre.moviesapp.presentation.di.people.PeopleSubComponent
import com.joshuatorre.moviesapp.presentation.di.tvshow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    CacheDataModule::class,
    DatabaseModule::class,
    LocalDataModule::class,
    NetModule::class,
    RemoteDataModule::class,
    RepositoryModule::class,
    UseCaseModule::class
])
interface AppComponent {

    fun movieSubComponent(): MovieSubComponent.Factory
    fun peopleSubComponent(): PeopleSubComponent.Factory
    fun tvShowSubComponent(): TvShowSubComponent.Factory

}