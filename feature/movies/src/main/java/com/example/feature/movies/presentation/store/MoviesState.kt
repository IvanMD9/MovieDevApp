package com.example.feature.movies.presentation.store

import androidx.paging.PagingData
import com.example.feature.movies.domain.models.MovieItem
import kotlinx.coroutines.flow.Flow

data class MoviesState(
    val movies: () -> Flow<PagingData<MovieItem>>,
    val isLoading: Boolean,
    val isError: Boolean
)
