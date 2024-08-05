package com.example.feature.movies.presentation.store

import androidx.paging.PagingData
import com.example.feature.movies.domain.models.NewsItem
import kotlinx.coroutines.flow.Flow

data class NewsState(
    val news: () -> Flow<PagingData<NewsItem>>,
    val isLoading: Boolean,
    val isError: Boolean
)
