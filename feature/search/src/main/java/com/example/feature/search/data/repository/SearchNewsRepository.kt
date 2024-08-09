package com.example.feature.search.data.repository

import com.example.feature.search.domain.models.NewsSearchItem

interface SearchNewsRepository {

    suspend fun getSearchNews(
        query: String,
        page: Int
    ): List<NewsSearchItem>
}