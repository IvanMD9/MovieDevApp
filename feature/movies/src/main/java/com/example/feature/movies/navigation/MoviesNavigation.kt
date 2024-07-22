package com.example.feature.movies.navigation

import androidx.navigation.NavController

const val MOVIES_ROUTE = "MOVIES_ROUTE"

fun NavController.navToMovies() = navigate(MOVIES_ROUTE)