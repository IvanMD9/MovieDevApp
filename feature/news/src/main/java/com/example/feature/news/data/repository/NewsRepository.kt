package com.example.feature.news.data.repository

import com.example.feature.news.domain.models.NewsItem

interface NewsRepository {

    suspend fun getNews(
        page: Int,
        country: String
    ): List<NewsItem>
}