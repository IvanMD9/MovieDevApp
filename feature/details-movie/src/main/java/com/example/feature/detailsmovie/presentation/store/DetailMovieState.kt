package com.example.feature.detailsmovie.presentation.store

import com.example.feature.detailsmovie.domain.models.DetailMovie

data class DetailMovieState(
    val detailMovie: DetailMovie,
    val isLoading: Boolean,
    val isError: Boolean
)
