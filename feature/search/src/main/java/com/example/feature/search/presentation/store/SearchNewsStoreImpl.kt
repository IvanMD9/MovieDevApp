package com.example.feature.search.presentation.store

import androidx.paging.PagingData
import com.example.core.mvi.DisposableStoreImpl
import com.example.core.paging.PagingSourceBuilder
import com.example.feature.search.domain.interactor.SearchNewsIntreactor
import com.example.feature.search.domain.models.NewsSearchItem
import com.example.feature.search.presentation.pager.SearchMoviesDiffUtil
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchNewsStoreImpl @Inject constructor(
    private val searchMoviesIntreactor: SearchNewsIntreactor,
) : SearchNewsStore,
    DisposableStoreImpl<SearchNewsAction, SearchNewsState, SearchNewsEvent>() {

    override val initialState: SearchNewsState
        get() = SearchNewsState(
            searchNews = ::searchNewsPagingFlow,
            searchQuery = "",
            searchScreenState = SearchScreenState.EmptySearch,
        )

    private var searchJob: Job? = null

    private val searchNewsPagingFlow: Flow<PagingData<NewsSearchItem>>
        get() = PagingSourceBuilder(
            requestPage = { page, _ ->
                searchMoviesIntreactor.getSearchNews(
                    query = state.value.searchQuery.trim(),
                    page = page
                )
            },
            pagingDiffUtil = SearchMoviesDiffUtil
        ).flow

    override fun consume(action: SearchNewsAction) {
        when (action) {
            is SearchNewsAction.OnValueChanged -> onValueSearchChange(action.value)
        }
    }

    private fun onValueSearchChange(value: String) {
        val queryChange = value.trimStart()
        state.update { currentState ->
            currentState.copy(
                searchQuery = queryChange,
                searchScreenState = if (queryChange.isNotEmpty()) {
                    currentState.searchScreenState
                } else {
                    SearchScreenState.EmptySearch
                }
            )
        }
        searchJob?.cancel()
        searchJob = storeScope.launch {
            delay(1000)
            state.update { currentState ->
                currentState.copy(
                    searchQuery = queryChange,
                    searchScreenState = if (queryChange.isNotEmpty()) {
                        SearchScreenState.SearchResultState.Loading
                    } else {
                        SearchScreenState.EmptySearch
                    }
                )
            }
        }
    }
}