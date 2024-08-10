package com.example.feature.search.domain.interactor

import com.example.feature.search.domain.models.NewsSearchItem

interface SearchNewsIntreactor {

    suspend fun getSearchNews(
        query: String,
        page: Int
    ): List<NewsSearchItem>
}