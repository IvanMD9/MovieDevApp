package com.example.feature.search.di

import com.example.feature.search.presentation.store.SearchNewsStore
import com.example.feature.search.presentation.store.SearchNewsStoreImpl
import com.example.feature.search.data.repository.SearchNewsRepository
import com.example.feature.search.data.repository.SearchNewsRepositoryImpl
import com.example.feature.search.domain.interactor.SearchNewsIntreactor
import com.example.feature.search.domain.interactor.SearchNewsIntreactorImpl
import dagger.Binds
import dagger.Module

@Module
interface SearchNewsModule {

    @SearchNewsScope
    @Binds
    fun bindSearchNewsRepository(impl: SearchNewsRepositoryImpl): SearchNewsRepository

    @SearchNewsScope
    @Binds
    fun bindSearchNewsIntreactor(impl: SearchNewsIntreactorImpl): SearchNewsIntreactor

    @SearchNewsScope
    @Binds
    fun bindSearchNewsStore(impl: SearchNewsStoreImpl): SearchNewsStore
}