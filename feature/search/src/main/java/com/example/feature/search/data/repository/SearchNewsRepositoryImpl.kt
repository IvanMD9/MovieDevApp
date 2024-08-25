package com.example.feature.search.data.repository

import com.example.feature.search.data.mapper.toDomain
import com.example.core.network.client.searchnews.SearchNewsClient
import com.example.core.news.model.NewsItem
import javax.inject.Inject

class SearchNewsRepositoryImpl @Inject constructor(
    private val searchNewsClient: SearchNewsClient
) : SearchNewsRepository {

    override suspend fun getSearchNews(query: String, page: Int): List<NewsItem> {
        return searchNewsClient
            .getSearchNews(
                query = query,
                page = page
            )
            .articles.map { item ->
                item.toDomain()
            }
    }
}