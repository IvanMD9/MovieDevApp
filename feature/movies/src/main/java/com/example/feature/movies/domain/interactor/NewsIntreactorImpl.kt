package com.example.feature.movies.domain.interactor

import com.example.feature.movies.data.repository.NewsRepository
import com.example.feature.movies.domain.models.NewsItem
import javax.inject.Inject

class NewsIntreactorImpl @Inject constructor(
    private val repository: NewsRepository
) : NewsIntreactor {

    override suspend fun getNews(page: Int): List<NewsItem> {
        return repository.getNews(page)
    }
}