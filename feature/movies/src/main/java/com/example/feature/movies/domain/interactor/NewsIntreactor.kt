package com.example.feature.movies.domain.interactor

import com.example.feature.movies.domain.models.NewsItem

interface NewsIntreactor {

    suspend fun getNews(
        page: Int,
        country: String
    ): List<NewsItem>
}