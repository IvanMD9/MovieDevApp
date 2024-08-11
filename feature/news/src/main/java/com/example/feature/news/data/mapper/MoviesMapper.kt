package com.example.feature.news.data.mapper

import com.example.feature.news.domain.models.NewsItem
import com.example.network.client.news.models.NewsResponse

fun NewsResponse.toDomain(): NewsItem = NewsItem(
    author = author,
    title = title,
    image = image,
    content = content,
)