package com.example.feature.movies.presentation.store

import androidx.paging.PagingData
import com.example.core.mvi.DisposableStoreImpl
import com.example.core.paging.PagingSourceBuilder
import com.example.feature.movies.domain.interactor.NewsIntreactor
import com.example.feature.movies.domain.models.NewsItem
import com.example.feature.movies.presentation.pager.NewsDiffUtil
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsStoreImpl @Inject constructor(
    private val newsIntreactor: NewsIntreactor,
) : NewsStore, DisposableStoreImpl<NewsAction, NewsState, NewsEvent>() {

    override val initialState: NewsState
        get() = NewsState(
            news = ::newsPagingFlow,
            isLoading = false,
            isError = false,
        )

    private val newsPagingFlow: Flow<PagingData<NewsItem>>
        get() = PagingSourceBuilder(
            requestPage = { page, _ ->
                newsIntreactor.getNews(page)
            },
            pagingDiffUtil = NewsDiffUtil
        ).flow

    override fun consume(action: NewsAction) = Unit
}