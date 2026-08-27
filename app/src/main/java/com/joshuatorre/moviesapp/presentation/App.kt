package com.joshuatorre.moviesapp.presentation

import android.app.Application
import com.joshuatorre.moviesapp.BuildConfig
import com.joshuatorre.moviesapp.presentation.di.Injector
import com.joshuatorre.moviesapp.presentation.di.core.AppComponent
import com.joshuatorre.moviesapp.presentation.di.core.AppModule
import com.joshuatorre.moviesapp.presentation.di.core.DaggerAppComponent
import com.joshuatorre.moviesapp.presentation.di.core.NetModule
import com.joshuatorre.moviesapp.presentation.di.core.RemoteDataModule
import com.joshuatorre.moviesapp.presentation.di.movie.MovieSubComponent
import com.joshuatorre.moviesapp.presentation.di.people.PeopleSubComponent
import com.joshuatorre.moviesapp.presentation.di.tvshow.TvShowSubComponent

class App : Application(), Injector {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createPeopleSubComponent(): PeopleSubComponent {
        return appComponent.peopleSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }
}