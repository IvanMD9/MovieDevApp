package com.example.feature.news.navigation

import androidx.navigation.NavController

const val NEWS_ROUTE = "NEWS_ROUTE"

fun NavController.navToNews() = navigate(NEWS_ROUTE)