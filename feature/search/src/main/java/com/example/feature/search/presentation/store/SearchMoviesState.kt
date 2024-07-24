package com.example.feature.search.presentation.store

import androidx.paging.PagingData
import com.example.feature.search.domain.models.MovieItem
import kotlinx.coroutines.flow.Flow

data class SearchMoviesState(
    val movies: () -> Flow<PagingData<MovieItem>>,
    val query: String,
    val isLoading: Boolean,
    val isError: Boolean
)
