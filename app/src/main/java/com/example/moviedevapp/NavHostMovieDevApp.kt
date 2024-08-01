package com.example.moviedevapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.feature.detailsmovie.navigation.MOVIE_DETAIL_ROUTE
import com.example.feature.detailsmovie.navigation.navToDetailMovie
import com.example.feature.detailsmovie.presentation.store.DetailMovieStore
import com.example.feature.detailsmovie.presentation.ui.DetailMovieScreen
import com.example.feature.movies.navigation.MOVIES_ROUTE
import com.example.feature.movies.navigation.navToMovies
import com.example.feature.movies.presentation.store.MoviesStore
import com.example.feature.movies.presentation.ui.MoviesScreen
import com.example.feature.search.navigation.SEARCH_MOVIES_ROUTE
import com.example.feature.search.navigation.navToSearchMovies
import com.example.feature.search.presentation.store.SearchMoviesStore
import com.example.feature.search.presentation.ui.MoviesSearchScreen

@Composable
fun NavHostMovieDevApp(
    navController: NavHostController,
    moviesStore: MoviesStore,
    detailMovieStore: DetailMovieStore,
    searchMoviesStore: SearchMoviesStore,
) {
    NavHost(
        navController = navController,
        startDestination = MOVIES_ROUTE
    ) {
        // TODO: Заменить это решение
        var movieUuid = 0
        composable(MOVIES_ROUTE) {
            MoviesScreen(
                store = moviesStore,
                onClickItemMovie = { movieItem ->
                    movieUuid = movieItem.id
                    navController.navToDetailMovie(movieItem.id)
                },
                onSearchClick = {
                    navController.navToSearchMovies()
                }
            )
        }
        composable(MOVIE_DETAIL_ROUTE) {
            DetailMovieScreen(
                detailMovieStore = detailMovieStore,
                movieUuid = movieUuid,
                onBackClick = {
                    navController.navToMovies()
                }
            )
        }
        composable(SEARCH_MOVIES_ROUTE) {
            MoviesSearchScreen(
                store = searchMoviesStore,
                onClickItemMovie = { movieItem ->
                    movieUuid = movieItem.id
                    navController.navToDetailMovie(movieItem.id)
                },
                onBackClick = {
                    navController.navToMovies()
                }
            )
        }
    }
}