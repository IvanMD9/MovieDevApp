package com.example.feature.movies.data.mapper

import com.example.feature.movies.domain.models.NewsItem
import com.example.network.client.movies.models.NewsResponse

fun NewsResponse.toDomain(): NewsItem = NewsItem(
    author = author,
    title = title,
    image = image,
    content = content,
)