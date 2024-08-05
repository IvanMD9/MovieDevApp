package com.example.feature.search.presentation.ui

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemKey
import com.example.core.extension.rememberLambda
import com.example.feature.search.domain.models.MovieItem

@Composable
fun MoviesSearchColumn(
    lazyPagingItems: () -> LazyPagingItems<MovieItem>,
    onClickItem: (MovieItem) -> Unit,
    modifier: Modifier = Modifier,
) {
    val items = lazyPagingItems()
    LazyVerticalGrid(
        modifier = modifier.fillMaxSize(),
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(
            count = items.itemCount,
            key = items.itemKey { item -> item.id }
        ) { index ->
            items[index]?.let { movieItem ->
                MovieSearchElement(
                    movieItem = movieItem,
                    onClickItem = rememberLambda(key1 = movieItem.id) {
                        onClickItem(movieItem)
                    },
                )
            }
        }
    }
}