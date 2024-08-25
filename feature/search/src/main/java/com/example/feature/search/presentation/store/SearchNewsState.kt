package com.example.feature.search.presentation.store

import androidx.paging.PagingData
import com.example.core.news.model.NewsItem
import kotlinx.coroutines.flow.Flow

data class SearchNewsState(
    val searchNews: () -> Flow<PagingData<NewsItem>>,
    val searchQuery: String,
    val searchScreenState: SearchScreenState,
)

sealed interface SearchScreenState {

    data class Error(val message: String) : SearchScreenState

    data object EmptySearch : SearchScreenState

    data object Content : SearchScreenState
}
