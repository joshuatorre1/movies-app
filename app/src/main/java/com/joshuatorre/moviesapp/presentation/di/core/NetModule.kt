package com.joshuatorre.moviesapp.presentation.di.core

import com.joshuatorre.moviesapp.BuildConfig
import com.joshuatorre.moviesapp.data.remote.TmdbService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetModule {

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .build()
    }

    @Provides
    fun provideTmdbService(retrofit: Retrofit): TmdbService {
        return retrofit.create(TmdbService::class.java)
    }

}