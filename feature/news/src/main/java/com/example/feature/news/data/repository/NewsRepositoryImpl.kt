package com.example.feature.news.data.repository

import com.example.feature.news.data.mapper.toDomain
import com.example.core.network.client.news.NewsClient
import com.example.core.news.model.NewsItem
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsClient: NewsClient
) : NewsRepository {

    override suspend fun getNews(page: Int, country: String): List<NewsItem> {
        return newsClient
            .getNews(
                page = page,
                country = country
            )
            .articles.map { item ->
                item.toDomain()
            }
    }
}