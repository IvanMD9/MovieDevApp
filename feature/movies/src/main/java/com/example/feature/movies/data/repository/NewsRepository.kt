package com.example.feature.movies.data.repository

import com.example.feature.movies.domain.models.NewsItem

interface NewsRepository {

    suspend fun getNews(
        page: Int,
        country: String
    ): List<NewsItem>
}