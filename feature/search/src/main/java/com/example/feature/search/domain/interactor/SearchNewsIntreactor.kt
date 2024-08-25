package com.example.feature.search.domain.interactor

import com.example.core.news.model.NewsItem

interface SearchNewsIntreactor {

    suspend fun getSearchNews(
        query: String,
        page: Int
    ): List<NewsItem>
}