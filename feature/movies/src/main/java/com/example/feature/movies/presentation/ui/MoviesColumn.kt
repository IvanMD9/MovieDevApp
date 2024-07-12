package com.example.feature.movies.presentation.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemKey
import com.example.feature.movies.domain.models.MovieItem

@Composable
fun MoviesColumn(
    lazyPagingItems: () -> LazyPagingItems<MovieItem>,
    modifier: Modifier = Modifier,
) {
    val items = lazyPagingItems()
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(
            horizontal = 12.dp,
            vertical = 10.dp
        )
    ) {
        items(
            count = items.itemCount,
            key = items.itemKey { item -> item.id }
        ) { index ->
            items[index]?.let { movieItem ->
                MovieElement(
                    movieItem = movieItem
                )
            }
        }
    }
}