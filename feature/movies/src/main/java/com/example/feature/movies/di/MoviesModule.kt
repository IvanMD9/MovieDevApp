package com.example.feature.movies.di

import com.example.feature.movies.data.repository.MoviesRepository
import com.example.feature.movies.data.repository.MoviesRepositoryImpl
import com.example.feature.movies.domain.interactor.MoviesIntreactor
import com.example.feature.movies.domain.interactor.MoviesIntreactorImpl
import com.example.feature.movies.presentation.store.MoviesStore
import com.example.feature.movies.presentation.store.MoviesStoreImpl
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

    @MoviesScope
    @Binds
    fun bindMoviesStore(impl: MoviesStoreImpl): MoviesStore
}