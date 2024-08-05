package com.example.feature.search.di

import com.example.feature.search.presentation.store.SearchMoviesStore
import com.example.feature.search.presentation.store.SearchMoviesStoreImpl
import com.example.feature.search.data.repository.SearchMoviesRepository
import com.example.feature.search.data.repository.SearchMoviesRepositoryImpl
import com.example.feature.search.domain.interactor.SearchMoviesIntreactor
import com.example.feature.search.domain.interactor.SearchMoviesIntreactorImpl
import dagger.Binds
import dagger.Module

@Module
interface SearchMoviesModule {

    @SearchMoviesScope
    @Binds
    fun bindSearchMoviesRepository(impl: SearchMoviesRepositoryImpl): SearchMoviesRepository

    @SearchMoviesScope
    @Binds
    fun bindSearchMoviesIntreactor(impl: SearchMoviesIntreactorImpl): SearchMoviesIntreactor

    @SearchMoviesScope
    @Binds
    fun bindSearchMoviesStore(impl: SearchMoviesStoreImpl): SearchMoviesStore
}