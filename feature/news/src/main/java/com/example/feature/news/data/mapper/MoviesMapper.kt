package com.example.feature.news.data.mapper

import com.example.core.network.client.news.models.NewsResponse
import com.example.core.news.model.NewsItem

fun NewsResponse.toDomain(): NewsItem = NewsItem(
    author = author,
    title = title,
    image = image,
    content = content,
)