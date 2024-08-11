package com.example.newsdevapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.feature.news.navigation.NEWS_ROUTE
import com.example.feature.news.navigation.navToNews
import com.example.feature.news.presentation.store.NewsStore
import com.example.feature.news.presentation.ui.NewsScreen
import com.example.feature.search.navigation.SEARCH_NEWS_ROUTE
import com.example.feature.search.navigation.navToSearchNews
import com.example.feature.search.presentation.store.SearchNewsStore
import com.example.feature.search.presentation.ui.NewsSearchScreen

@Composable
fun NavHostNewDevApp(
    navController: NavHostController,
    newsStore: NewsStore,
    searchNewsStore: SearchNewsStore,
) {
    NavHost(
        navController = navController,
        startDestination = NEWS_ROUTE
    ) {
        composable(NEWS_ROUTE) {
            NewsScreen(
                store = newsStore,
                onSearchClick = {
                    navController.navToSearchNews()
                }
            )
        }
        composable(SEARCH_NEWS_ROUTE) {
            NewsSearchScreen(
                store = searchNewsStore,
                onBackClick = {
                    navController.navToNews()
                }
            )
        }
    }
}