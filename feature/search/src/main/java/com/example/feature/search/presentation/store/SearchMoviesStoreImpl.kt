package com.example.feature.search.presentation.store

import androidx.paging.PagingData
import com.example.core.mvi.DisposableStoreImpl
import com.example.core.paging.PagingSourceBuilder
import com.example.feature.search.domain.interactor.SearchMoviesIntreactor
import com.example.feature.search.domain.models.MovieItem
import com.example.feature.search.presentation.pager.SearchMoviesDiffUtil
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchMoviesStoreImpl @Inject constructor(
    private val searchMoviesIntreactor: SearchMoviesIntreactor,
) : SearchMoviesStore,
    DisposableStoreImpl<SearchMoviesAction, SearchMoviesState, SearchMoviesEvent>() {

    override val initialState: SearchMoviesState
        get() = SearchMoviesState(
            searchMovies = ::searchMoviesPagingFlow,
            searchQuery = "",
            searchState = SearchState.Loading,
        )

    private var searchJob: Job? = null

    private val searchMoviesPagingFlow: Flow<PagingData<MovieItem>>
        get() = PagingSourceBuilder(
            requestPage = { page, _ ->
                searchMoviesIntreactor.getSearchMovies(
                    query = state.value.searchQuery,
                    page = page
                )
            },
            pagingDiffUtil = SearchMoviesDiffUtil
        ).flow

    override fun consume(action: SearchMoviesAction) {
        when (action) {
            is SearchMoviesAction.Init -> init()
            is SearchMoviesAction.OnValueChanged -> onValueSearchChange(action.value)
        }
    }

    private fun init() {
        state.value = initialState
    }

    private fun onValueSearchChange(value: String) {
        val queryChange = value.trimStart()
        state.update { currentState ->
            currentState.copy(
                searchQuery = queryChange
            )
        }
        searchJob?.cancel()
        searchJob = storeScope.launch {
            state.update { currentState ->
                currentState.copy(
                    searchQuery = queryChange,
                    searchState = SearchState.Loading,
                )
            }
            if (queryChange.isEmpty()) {
                updateScreenState(searchState = SearchState.EmptySearch)
            }
        }
    }

    private fun updateScreenState(searchState: SearchState) {
        state.update { currentState ->
            currentState.copy(
                searchState = searchState,
            )
        }
    }
}