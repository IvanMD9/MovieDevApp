package com.example.feature.news.presentation.store

import androidx.paging.PagingData
import com.example.core.news.model.NewsItem
import kotlinx.coroutines.flow.Flow

data class NewsState(
    val news: () -> Flow<PagingData<NewsItem>>,
    val selectCountry: String,
    val isShowMenu: Boolean,
)
