package com.example.feature.search.presentation.store

import androidx.paging.PagingData
import com.example.core.mvi.DisposableStoreImpl
import com.example.core.paging.PagingSourceBuilder
import com.example.feature.search.domain.interactor.SearchMoviesIntreactor
import com.example.feature.search.domain.models.MovieItem
import com.example.feature.search.presentation.pager.SearchMoviesDiffUtil
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

// TODO: Реализовать логику поиска

class SearchMoviesStoreImpl @Inject constructor(
    private val searchMoviesIntreactor: SearchMoviesIntreactor,
) : SearchMoviesStore,
    DisposableStoreImpl<SearchMoviesAction, SearchMoviesState, SearchMoviesEvent>() {

    override val initialState: SearchMoviesState
        get() = SearchMoviesState(
            movies = ::moviesPagingFlow,
            query = "",
            isLoading = false,
            isError = false,
        )

    private val moviesPagingFlow: Flow<PagingData<MovieItem>>
        get() = PagingSourceBuilder(
            requestPage = { page, _ ->
                searchMoviesIntreactor.getSearchMovies(
                    query = state.value.query,
                    page = page
                )
            },
            pagingDiffUtil = SearchMoviesDiffUtil
        ).flow

    override fun consume(action: SearchMoviesAction) = Unit
}