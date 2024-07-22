package com.example.feature.detailsmovie.presentation.store

sealed interface DetailMovieAction {

    data class LoadDetail(val movieUuid: Int): DetailMovieAction
}