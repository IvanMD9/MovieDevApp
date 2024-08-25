package com.example.feature.search.data.repository

import com.example.core.news.model.NewsItem

interface SearchNewsRepository {

    suspend fun getSearchNews(
        query: String,
        page: Int
    ): List<NewsItem>
}