package com.example.network.di

import com.example.network.client.news.NewsClient
import com.example.network.client.searchnews.SearchNewsClient

interface NetworkApi {

    fun provideNewsClient(): NewsClient

    fun provideSearchNewsClient(): SearchNewsClient
}