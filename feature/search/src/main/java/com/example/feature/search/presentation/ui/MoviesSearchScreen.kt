package com.example.feature.search.presentation.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.core.extension.rememberLambda1
import com.example.feature.search.domain.models.MovieItem
import com.example.feature.search.presentation.store.SearchMoviesAction
import com.example.feature.search.presentation.store.SearchMoviesStore

@Composable
fun MoviesSearchScreen(
    store: SearchMoviesStore,
    onClickItemMovie: (MovieItem) -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val moviesSearchStore by remember(store) {
        store.state
    }.collectAsState()

    val lazyPagingItems = remember {
        moviesSearchStore.searchMovies()
    }.collectAsLazyPagingItems()

    LaunchedEffect(Int) {
        store.consume(SearchMoviesAction.Init)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            SearchToolbar(
                value = moviesSearchStore.searchQuery,
                onValueChange = { value ->
                    store.consume(SearchMoviesAction.OnValueChanged(value))
                },
                onBackClick = onBackClick
            )
        },
        content = { _ ->
            MoviesSearchColumn(
                lazyPagingItems = { lazyPagingItems },
                modifier = modifier,
                onClickItem = rememberLambda1 { movieItem ->
                    onClickItemMovie(movieItem)
                }
            )
//            when (moviesStore.searchState) {
//                is SearchState.Loading -> {
//                    Box(
//                        modifier = Modifier.fillMaxSize(),
//                        contentAlignment = Alignment.Center
//                    ) {
//                        CircularProgressIndicator()
//                    }
//                }
//
//                is SearchState.EmptySearch -> {
//                    Box(
//                        modifier = Modifier.fillMaxSize(),
//                        contentAlignment = Alignment.Center
//                    ) {
//                        Text(
//                            text = "Ничего не найдено",
//                            fontSize = 20.sp,
//                            color = Color.Black
//                        )
//                    }
//                }
//                is SearchState.Content -> {
//                    MoviesSearchColumn(
//                        lazyPagingItems = { lazyPagingItems },
//                        modifier = modifier,
//                        onClickItem = rememberLambda1 { movieItem ->
//                            onClickItemMovie(movieItem)
//                        }
//                    )
//                }
//            }
        }
    )
}