package com.example.feature.search.data.repository

import com.example.feature.search.data.mapper.toDomain
import com.example.feature.search.domain.models.NewsSearchItem
import com.example.network.client.searchnews.SearchNewsClient
import javax.inject.Inject

class SearchNewsRepositoryImpl @Inject constructor(
    private val searchNewsClient: SearchNewsClient
) : SearchNewsRepository {

    override suspend fun getSearchNews(query: String, page: Int): List<NewsSearchItem> {
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