package com.example.feature.search.domain.interactor

import com.example.feature.search.data.repository.SearchNewsRepository
import com.example.core.news.model.NewsItem
import javax.inject.Inject

class SearchNewsIntreactorImpl @Inject constructor(
    private val repository: SearchNewsRepository
) : SearchNewsIntreactor {

    override suspend fun getSearchNews(query: String, page: Int): List<NewsItem> {
        return repository.getSearchNews(
            query = query,
            page = page
        )
    }
}