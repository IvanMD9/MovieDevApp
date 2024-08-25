package com.example.feature.news.data.repository

import com.example.core.news.model.NewsItem

interface NewsRepository {

    suspend fun getNews(
        page: Int,
        country: String
    ): List<NewsItem>
}