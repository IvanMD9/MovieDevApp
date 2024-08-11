package com.example.feature.news.presentation.store

import androidx.paging.PagingData
import com.example.core.mvi.DisposableStoreImpl
import com.example.core.paging.PagingSourceBuilder
import com.example.feature.news.domain.interactor.NewsIntreactor
import com.example.feature.news.domain.models.CountryNews
import com.example.feature.news.domain.models.NewsItem
import com.example.feature.news.presentation.pager.NewsDiffUtil
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class NewsStoreImpl @Inject constructor(
    private val newsIntreactor: NewsIntreactor,
) : NewsStore, DisposableStoreImpl<NewsAction, NewsState, NewsEvent>() {

    override val initialState: NewsState
        get() = NewsState(
            news = ::newsPagingFlow,
            isShowMenu = false,
            selectCountry = CountryNews.RUSSIAN.value,
            isLoading = true,
        )

    private val newsPagingFlow: Flow<PagingData<NewsItem>>
        get() = PagingSourceBuilder(
            requestPage = { page, _ ->
                newsIntreactor.getNews(
                    page = page,
                    country = CountryNews.RUSSIAN.value
                )
            },
            pagingDiffUtil = NewsDiffUtil
        ).flow

    override fun consume(action: NewsAction) {
        when (action) {
            is NewsAction.OnClickMenu -> onClickMenu(action.showMenu)
            is NewsAction.OnClickItemMenu -> onClickItemMenu(action.country)
        }
    }

    private fun onClickMenu(isShowMenu: Boolean) {
        state.update { currentState ->
            currentState.copy(
                isShowMenu = isShowMenu
            )
        }
    }

    private fun onClickItemMenu(country: String) {
        val newsPagingFlow: Flow<PagingData<NewsItem>> = PagingSourceBuilder(
            requestPage = { page, _ ->
                newsIntreactor.getNews(
                    page = page,
                    country = country
                )
            },
            pagingDiffUtil = NewsDiffUtil
        ).flow

        state.update { currentState ->
            currentState.copy(
                news = { newsPagingFlow },
                isShowMenu = false,
                selectCountry = country
            )
        }
    }
}