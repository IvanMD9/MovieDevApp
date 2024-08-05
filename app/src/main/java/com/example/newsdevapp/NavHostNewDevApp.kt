package com.example.newsdevapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.feature.movies.navigation.NEWS_ROUTE
import com.example.feature.movies.navigation.navToNews
import com.example.feature.movies.presentation.store.NewsStore
import com.example.feature.movies.presentation.ui.NewsScreen
import com.example.feature.search.navigation.SEARCH_MOVIES_ROUTE
import com.example.feature.search.navigation.navToSearchMovies
import com.example.feature.search.presentation.store.SearchMoviesStore
import com.example.feature.search.presentation.ui.MoviesSearchScreen

@Composable
fun NavHostNewDevApp(
    navController: NavHostController,
    moviesStore: NewsStore,
    searchMoviesStore: SearchMoviesStore,
) {
    NavHost(
        navController = navController,
        startDestination = NEWS_ROUTE
    ) {
        composable(NEWS_ROUTE) {
            NewsScreen(
                store = moviesStore,
                onSearchClick = {
                    navController.navToSearchMovies()
                }
            )
        }
        composable(SEARCH_MOVIES_ROUTE) {
            MoviesSearchScreen(
                store = searchMoviesStore,
                onClickItemMovie = { movieItem ->

                },
                onBackClick = {
                    navController.navToNews()
                }
            )
        }
    }
}