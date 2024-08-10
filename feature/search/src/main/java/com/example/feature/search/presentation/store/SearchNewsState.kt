package com.example.feature.search.presentation.store

import androidx.paging.PagingData
import com.example.feature.search.domain.models.NewsSearchItem
import kotlinx.coroutines.flow.Flow

data class SearchNewsState(
    val searchNews: () -> Flow<PagingData<NewsSearchItem>>,
    val searchQuery: String,
    val searchScreenState: SearchScreenState,
)

sealed interface SearchScreenState {

    data class Error(val message: String) : SearchScreenState

    data object EmptySearch : SearchScreenState

    sealed interface SearchResultState : SearchScreenState {

        data object Loading : SearchResultState
    }
}
