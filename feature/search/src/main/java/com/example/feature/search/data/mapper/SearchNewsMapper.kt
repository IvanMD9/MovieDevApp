package com.example.feature.search.data.mapper

import com.example.core.network.client.searchnews.models.NewsSearchResponse
import com.example.core.news.model.NewsItem

fun NewsSearchResponse.toDomain(): NewsItem = NewsItem(
    author = author,
    title = title,
    image = image,
    content = content,
)