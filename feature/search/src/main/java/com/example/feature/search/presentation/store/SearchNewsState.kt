package com.example.feature.search.presentation.store

import androidx.paging.PagingData
import com.example.feature.search.domain.models.NewsSearchItem
import kotlinx.coroutines.flow.Flow

data class SearchNewsState(
    val searchNews: () -> Flow<PagingData<NewsSearchItem>>,
    val searchQuery: String,
)
