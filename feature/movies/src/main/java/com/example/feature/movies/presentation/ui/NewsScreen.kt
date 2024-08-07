package com.example.feature.movies.presentation.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.feature.movies.presentation.store.NewsStore

@Composable
fun NewsScreen(
    store: NewsStore,
    onSearchClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val newsStore by remember(store) {
        store.state
    }.collectAsState()

    val lazyPagingItems = remember {
        newsStore.news()
    }.collectAsLazyPagingItems()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(44.dp)
                    .padding(horizontal = 8.dp)
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = "NewsApp",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                )
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .size(32.dp)
                        .padding(end = 8.dp)
                        .clickable(onClick = onSearchClick),
                    tint = Color.Black
                )
            }
        },
        content = { paddingValues ->
            NewsColumn(
                modifier = modifier.padding(paddingValues),
                lazyPagingItems = { lazyPagingItems },
            )
        }
    )
}