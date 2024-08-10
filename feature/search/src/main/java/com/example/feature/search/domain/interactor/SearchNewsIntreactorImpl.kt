package com.example.feature.search.domain.interactor

import com.example.feature.search.data.repository.SearchNewsRepository
import com.example.feature.search.domain.models.NewsSearchItem
import javax.inject.Inject

class SearchNewsIntreactorImpl @Inject constructor(
    private val repository: SearchNewsRepository
) : SearchNewsIntreactor {

    override suspend fun getSearchNews(query: String, page: Int): List<NewsSearchItem> {
        return repository.getSearchNews(
            query = query,
            page = page
        )
    }
}