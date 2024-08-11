package com.example.feature.news.di

import com.example.feature.news.data.repository.NewsRepository
import com.example.feature.news.data.repository.NewsRepositoryImpl
import com.example.feature.news.domain.interactor.NewsIntreactor
import com.example.feature.news.domain.interactor.NewsIntreactorImpl
import com.example.feature.news.presentation.store.NewsStore
import com.example.feature.news.presentation.store.NewsStoreImpl
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