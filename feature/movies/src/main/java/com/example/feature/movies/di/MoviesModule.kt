package com.example.feature.movies.di

import com.example.feature.movies.data.repository.MoviesRepository
import com.example.feature.movies.data.repository.MoviesRepositoryImpl
import com.example.feature.movies.domain.interactor.MoviesIntreactor
import com.example.feature.movies.domain.interactor.MoviesIntreactorImpl
import dagger.Binds
import dagger.Module

@Module
interface MoviesModule {

    @MoviesScope
    @Binds
    fun bindMoviesRepository(impl: MoviesRepositoryImpl): MoviesRepository

    @MoviesScope
    @Binds
    fun bindMoviesIntreactor(impl: MoviesIntreactorImpl): MoviesIntreactor
}