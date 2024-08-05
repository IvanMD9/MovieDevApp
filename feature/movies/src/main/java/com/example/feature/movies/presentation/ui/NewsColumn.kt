package com.example.feature.movies.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemKey
import com.example.feature.movies.domain.models.NewsItem

@Composable
fun NewsColumn(
    lazyPagingItems: () -> LazyPagingItems<NewsItem>,
    modifier: Modifier = Modifier,
) {
    val items = lazyPagingItems()
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(
            count = items.itemCount,
            key = items.itemKey { item -> item.title.orEmpty() }
        ) { index ->
            items[index]?.let { movieItem ->
                NewsElement(
                    newsItem = movieItem,
                )
            }
        }
    }
}