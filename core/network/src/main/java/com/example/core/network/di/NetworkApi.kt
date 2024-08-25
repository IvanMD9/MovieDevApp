package com.example.core.network.di

import com.example.core.network.client.news.NewsClient
import com.example.core.network.client.searchnews.SearchNewsClient

interface NetworkApi {

    fun provideNewsClient(): NewsClient

    fun provideSearchNewsClient(): SearchNewsClient
}