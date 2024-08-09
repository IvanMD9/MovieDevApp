package com.example.feature.search.data.mapper

import com.example.feature.search.domain.models.NewsSearchItem
import com.example.network.client.searchnews.models.NewsSearchResponse

fun NewsSearchResponse.toDomain(): NewsSearchItem = NewsSearchItem(
    author = author,
    title = title,
    image = image,
    content = content,
)