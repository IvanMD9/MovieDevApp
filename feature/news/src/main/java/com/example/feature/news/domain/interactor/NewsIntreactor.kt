package com.example.feature.news.domain.interactor

import com.example.feature.news.domain.models.NewsItem

interface NewsIntreactor {

    suspend fun getNews(
        page: Int,
        country: String
    ): List<NewsItem>
}