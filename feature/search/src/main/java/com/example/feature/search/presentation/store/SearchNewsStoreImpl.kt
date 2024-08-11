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

    companion object {
        private const val EMPTY_SEARCH = ""
        private const val DELAY_SEARCH = 1000L
    }

    override val initialState: SearchNewsState
        get() = SearchNewsState(
            searchNews = ::searchNewsPagingFlow,
            searchQuery = EMPTY_SEARCH,
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
            is SearchNewsAction.OnClickClearText -> onClickClearText()
        }
    }

    private fun onValueSearchChange(value: String) {
        val queryChange = value.trimStart()
        state.update { currentState ->
            currentState.copy(
                searchQuery = queryChange,
                searchScreenState = if (queryChange.isNotEmpty()) {
                    SearchScreenState.Content
                } else {
                    SearchScreenState.EmptySearch
                }
            )
        }
        searchJob?.cancel()
        searchJob = storeScope.launch {
            delay(DELAY_SEARCH)
            state.update { currentState ->
                currentState.copy(
                    searchQuery = queryChange,
                    searchScreenState = if (queryChange.isNotEmpty()) {
                        SearchScreenState.Content
                    } else {
                        SearchScreenState.EmptySearch
                    }
                )
            }
        }
    }

    private fun onClickClearText() {
        state.update { currentsState ->
            currentsState.copy(
                searchQuery = EMPTY_SEARCH,
                searchScreenState = SearchScreenState.EmptySearch,
            )
        }
    }
}