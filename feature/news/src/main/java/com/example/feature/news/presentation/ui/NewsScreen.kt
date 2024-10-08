package com.example.feature.news.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.core.extension.rememberLambda
import com.example.core.extension.rememberLambda1
import com.example.feature.news.R
import com.example.core.ui.R as coreUiR
import com.example.feature.news.presentation.store.NewsAction
import com.example.feature.news.presentation.store.NewsStore
import com.example.core.news.ui.NewsColumn
import com.example.core.ui.NewsDimensions

@Composable
fun NewsScreen(
    store: NewsStore,
    onSearchClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val newsState by remember(store) {
        store.state
    }.collectAsState()

    val lazyPagingItems = remember(newsState.selectCountry) {
        newsState.news()
    }.collectAsLazyPagingItems()

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = colorResource(id = coreUiR.color.colorBgpPrimary)
                    )
                    .height(44.dp)
                    .padding(horizontal = NewsDimensions.Spacing.space_8)
            ) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .size(32.dp)
                        .padding(end = NewsDimensions.Spacing.space_8)
                        .clickable(
                            onClick = rememberLambda {
                                store.consume(NewsAction.OnClickMenu(showMenu = true))
                            }
                        ),
                    tint = colorResource(id = coreUiR.color.colorContentPrimary)
                )

                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = stringResource(id = R.string.app_news_title),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = coreUiR.color.colorContentPrimary),
                )
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .size(32.dp)
                        .padding(end = NewsDimensions.Spacing.space_8)
                        .clickable(
                            onClick = {
                                onSearchClick()
                                store.consume(NewsAction.OnClickSearch)
                            }
                        ),
                    tint = colorResource(id = coreUiR.color.colorContentPrimary)
                )
            }
        },
        content = { paddingValues ->
            NewsColumn(
                modifier = modifier.padding(paddingValues),
                lazyPagingItems = { lazyPagingItems },
                isLoadingVisible = (lazyPagingItems.itemCount > 0).not()
            )

            NewsShowMenu(
                expanded = newsState.isShowMenu,
                onClickCountry = rememberLambda1 { country ->
                    store.consume(NewsAction.OnClickItemMenu(country = country))
                },
                onCloseMenu = rememberLambda {
                    store.consume(NewsAction.OnClickMenu(showMenu = false))
                },
            )
        }
    )
}