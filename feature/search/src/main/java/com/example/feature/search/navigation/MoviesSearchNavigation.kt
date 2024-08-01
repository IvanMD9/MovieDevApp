package com.example.feature.search.navigation

import androidx.navigation.NavController

const val SEARCH_MOVIES_ROUTE = "SEARCH_MOVIES_ROUTE"

fun NavController.navToSearchMovies() = navigate(SEARCH_MOVIES_ROUTE)