package com.example.core.news.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemKey
import com.example.core.news.model.NewsItem
import com.example.core.ui.NewsDimensions
import com.example.core.ui.R as coreUiR

@Composable
fun NewsColumn(
    lazyPagingItems: () -> LazyPagingItems<NewsItem>,
    isLoadingVisible: Boolean,
    modifier: Modifier = Modifier,
) {
    val items = lazyPagingItems()
    if (isLoadingVisible) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = colorResource(id = coreUiR.color.colorBgpPrimary)
                ),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                color = colorResource(id = coreUiR.color.colorContentPrimary)
            )
        }
    } else {
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .background(
                    color = colorResource(id = coreUiR.color.colorBgpPrimary)
                ),
            contentPadding = PaddingValues(NewsDimensions.Spacing.space_12),
            verticalArrangement = Arrangement.spacedBy(NewsDimensions.Spacing.space_16),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(
                count = items.itemCount,
                key = items.itemKey { item -> item.title.orEmpty() }
            ) { index ->
                items[index]?.let { newsItem ->
                    NewsElement(
                        newsItem = newsItem,
                    )
                }
            }
        }
    }
}