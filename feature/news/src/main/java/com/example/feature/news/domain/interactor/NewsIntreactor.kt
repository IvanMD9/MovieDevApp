package com.example.feature.news.domain.interactor

import com.example.core.news.model.NewsItem

interface NewsIntreactor {

    suspend fun getNews(
        page: Int,
        country: String
    ): List<NewsItem>
}