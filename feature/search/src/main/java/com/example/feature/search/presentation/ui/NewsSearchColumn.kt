package com.example.feature.search.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemKey
import com.example.feature.search.domain.models.NewsSearchItem

@Composable
fun NewsSearchColumn(
    lazyPagingItems: () -> LazyPagingItems<NewsSearchItem>,
    isLoadingVisible: Boolean,
    modifier: Modifier = Modifier,
) {
    val items = lazyPagingItems()
    if (isLoadingVisible) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
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
                items[index]?.let { searchItem ->
                    NewsSearchElement(
                        searchItem = searchItem,
                    )
                }
            }
        }
    }
}