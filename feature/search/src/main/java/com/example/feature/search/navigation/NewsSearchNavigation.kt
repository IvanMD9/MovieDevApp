package com.example.feature.search.navigation

import androidx.navigation.NavController

const val SEARCH_NEWS_ROUTE = "SEARCH_NEWS_ROUTE"

fun NavController.navToSearchNews() = navigate(SEARCH_NEWS_ROUTE)