package com.example.feature.detailsmovie.navigation

import androidx.navigation.NavController

const val MOVIE_DETAIL_ROUTE = "MOVIE_DETAIL_ROUTE"
const val MOVIE_DETAIL_ID_ARGS = "MOVIE_DETAIL_ID"

fun NavController.navToDetailMovie(movieUuid: Int? = null) {
    val route = if (movieUuid != null) {
        "${MOVIE_DETAIL_ROUTE}?${MOVIE_DETAIL_ID_ARGS}=$movieUuid"
    } else {
        MOVIE_DETAIL_ROUTE
    }
    navigate(route)
}