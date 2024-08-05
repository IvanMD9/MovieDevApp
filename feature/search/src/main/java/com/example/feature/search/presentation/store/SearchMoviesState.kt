package com.example.feature.search.presentation.store

import androidx.paging.PagingData
import com.example.feature.search.domain.models.MovieItem
import kotlinx.coroutines.flow.Flow

data class SearchMoviesState(
    val searchMovies: () -> Flow<PagingData<MovieItem>>,
    val searchQuery: String,
    val searchState: SearchState,
)

sealed interface SearchState {

    data object EmptySearch : SearchState

    data object Loading : SearchState
}
