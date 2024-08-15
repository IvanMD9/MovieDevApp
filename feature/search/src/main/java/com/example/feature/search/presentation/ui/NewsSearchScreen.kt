package com.example.feature.search.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.core.extension.rememberLambda
import com.example.core.extension.rememberLambda1
import com.example.feature.search.R
import com.example.feature.search.presentation.store.SearchNewsAction
import com.example.feature.search.presentation.store.SearchNewsStore
import com.example.feature.search.presentation.store.SearchScreenState

@Composable
fun NewsSearchScreen(
    store: SearchNewsStore,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val newsSearchStore by remember {
        store.state
    }.collectAsState()

    val lazyPagingItems = remember(newsSearchStore.searchQuery) {
        newsSearchStore.searchNews()
    }.collectAsLazyPagingItems()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            SearchToolbar(
                value = newsSearchStore.searchQuery,
                onValueChange = rememberLambda1 { value ->
                    store.consume(SearchNewsAction.OnValueChanged(value))
                },
                onBackClick = rememberLambda {
                    onBackClick()
                    store.consume(SearchNewsAction.OnClickBack)
                },
                onClearText = rememberLambda {
                    store.consume(SearchNewsAction.OnClickClearText)
                },
            )
        },
        content = { paddingValues ->
            when (newsSearchStore.searchScreenState) {
                is SearchScreenState.Content -> {
                    NewsSearchColumn(
                        lazyPagingItems = { lazyPagingItems },
                        modifier = Modifier.padding(paddingValues),
                        isLoadingVisible = (lazyPagingItems.itemCount > 0).not()
                    )
                }

                is SearchScreenState.EmptySearch -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = stringResource(id = R.string.app_search_empty_screen),
                            fontSize = 22.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            maxLines = 2
                        )
                    }
                }

                is SearchScreenState.Error -> {}
            }
        }
    )
}