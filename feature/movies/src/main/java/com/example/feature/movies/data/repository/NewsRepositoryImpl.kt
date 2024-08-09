package com.example.feature.movies.data.repository

import com.example.feature.movies.data.mapper.toDomain
import com.example.feature.movies.domain.models.NewsItem
import com.example.network.client.news.NewsClient
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val moviesClient: NewsClient
) : NewsRepository {

    override suspend fun getNews(page: Int): List<NewsItem> {
        return moviesClient
            .getNews(page)
            .articles.map { item ->
                item.toDomain()
            }
    }
}