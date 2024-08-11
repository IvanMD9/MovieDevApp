package com.example.feature.news.domain.interactor

import com.example.feature.news.data.repository.NewsRepository
import com.example.feature.news.domain.models.NewsItem
import javax.inject.Inject

class NewsIntreactorImpl @Inject constructor(
    private val repository: NewsRepository
) : NewsIntreactor {

    override suspend fun getNews(page: Int, country: String): List<NewsItem> {
        return repository.getNews(
            page = page,
            country = country
        )
    }
}