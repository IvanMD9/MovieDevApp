package com.example.feature.detailsmovie.presentation.store

import com.example.core.mvi.DisposableStoreImpl
import com.example.feature.detailsmovie.domain.interactor.DetailMovieInteractor
import com.example.feature.detailsmovie.domain.models.DetailMovie
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailMovieStoreImpl @Inject constructor(
    private val moviesIntreactor: DetailMovieInteractor,
) : DetailMovieStore,
    DisposableStoreImpl<DetailMovieAction, DetailMovieState, DetailMovieEvent>() {

    override val initialState: DetailMovieState
        get() = DetailMovieState(
            detailMovie = DetailMovie(
                id = 0,
                originalTitle = "",
                overview = "",
                posterPath = "",
                releaseDate = "",
            ),
            isLoading = false,
            isError = false,
        )

    override val state: MutableStateFlow<DetailMovieState> = MutableStateFlow(initialState)

    override fun consume(action: DetailMovieAction) {
        when (action) {
            is DetailMovieAction.LoadDetail -> getDetailMovie(action.movieUuid)
        }
    }

    private fun getDetailMovie(movieUuid: Int) {
        storeScope.launch {
            updateLoadingState(isLoading = true)

            runCatching {
                val detailMovie = moviesIntreactor
                    .getDetailMovie(movieUuid = movieUuid)
                state.update { currentState ->
                    currentState.copy(
                        detailMovie = detailMovie,
                        isError = false,
                        isLoading = false
                    )
                }
            }
                .onSuccess {
                    updateLoadingState(isLoading = false)
                }
                .onFailure {
                    state.update { currentState ->
                        currentState.copy(
                            isError = true,
                            isLoading = false
                        )
                    }
                }
        }
    }

    private fun updateLoadingState(isLoading: Boolean) {
        state.update { currentState ->
            currentState.copy(
                isLoading = isLoading
            )
        }
    }
}

