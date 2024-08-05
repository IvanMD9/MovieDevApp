package com.example.feature.movies.di

import com.example.feature.movies.data.repository.NewsRepository
import com.example.feature.movies.data.repository.NewsRepositoryImpl
import com.example.feature.movies.domain.interactor.NewsIntreactor
import com.example.feature.movies.domain.interactor.NewsIntreactorImpl
import com.example.feature.movies.presentation.store.NewsStore
import com.example.feature.movies.presentation.store.NewsStoreImpl
import dagger.Binds
import dagger.Module

@Module
interface NewsModule {

    @NewsScope
    @Binds
    fun bindNewsRepository(impl: NewsRepositoryImpl): NewsRepository

    @NewsScope
    @Binds
    fun bindNewsIntreactor(impl: NewsIntreactorImpl): NewsIntreactor

    @NewsScope
    @Binds
    fun bindNewsStore(impl: NewsStoreImpl): NewsStore
}