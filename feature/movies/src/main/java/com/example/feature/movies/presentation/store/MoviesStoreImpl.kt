package com.example.feature.movies.presentation.store

import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.core.mvi.DisposableStoreImpl
import com.example.core.paging.PagingSourceBuilder
import com.example.feature.movies.domain.interactor.MoviesIntreactor
import com.example.feature.movies.domain.models.MovieItem
import com.example.feature.movies.presentation.pager.MoviesDiffUtil
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MoviesStoreImpl @Inject constructor(
    private val moviesIntreactor: MoviesIntreactor,
) : MoviesStore, DisposableStoreImpl<MoviesAction, MoviesState, MoviesEvent>() {

    override val initialState: MoviesState
        get() = MoviesState(
            movies = ::moviesPagingFlow,
            isLoading = false,
            isError = false,
        )

    private val moviesPagingFlow: Flow<PagingData<MovieItem>>
        get() = PagingSourceBuilder(
            requestPage = { page, _ ->
                moviesIntreactor.getMovies(page)
            },
            pagingDiffUtil = MoviesDiffUtil
        )
            .flow
            .cachedIn(storeScope)

    override fun consume(action: MoviesAction) = Unit
}