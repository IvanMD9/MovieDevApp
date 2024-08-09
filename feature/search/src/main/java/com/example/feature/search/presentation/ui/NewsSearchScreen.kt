package com.example.feature.search.presentation.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.core.extension.rememberLambda1
import com.example.feature.search.presentation.store.SearchNewsAction
import com.example.feature.search.presentation.store.SearchNewsStore

@Composable
fun NewsSearchScreen(
    store: SearchNewsStore,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val moviesSearchStore by remember {
        store.state
    }.collectAsState()

    val lazyPagingItems = remember(moviesSearchStore.searchQuery) {
        moviesSearchStore.searchNews()
    }.collectAsLazyPagingItems()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            SearchToolbar(
                value = moviesSearchStore.searchQuery,
                onValueChange = rememberLambda1 { value ->
                    store.consume(SearchNewsAction.OnValueChanged(value))
                },
                onBackClick = onBackClick
            )
        },
        content = { paddingValues ->
            NewsSearchColumn(
                lazyPagingItems = { lazyPagingItems },
                modifier = Modifier.padding(paddingValues)
            )
        }
    )
}