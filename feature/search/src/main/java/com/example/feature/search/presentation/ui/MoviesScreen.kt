package com.example.feature.search.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.core.extension.rememberLambda1
import com.example.feature.search.domain.models.MovieItem
import com.example.feature.search.presentation.store.SearchMoviesStore

// TODO: Реализовать логику поиска

@Composable
fun MoviesScreen(
    store: SearchMoviesStore,
    onClickItemMovie: (MovieItem) -> Unit,
    modifier: Modifier = Modifier,
) {
    val moviesStore by remember(store) {
        store.state
    }.collectAsState()

    val lazyPagingItems = remember {
        moviesStore.movies()
    }.collectAsLazyPagingItems()

    MoviesColumn(
        lazyPagingItems = { lazyPagingItems },
        modifier = modifier,
        onClickItem = rememberLambda1 { movieItem ->
            onClickItemMovie(movieItem)
        }
    )
}