package com.example.feature.news.presentation.pager

import com.example.core.paging.PagingDiffUtil
import com.example.feature.news.domain.models.NewsItem

object NewsDiffUtil : PagingDiffUtil<NewsItem>() {

    override fun invoke(
        oldItem: NewsItem,
        newItem: NewsItem
    ): Boolean {
        return oldItem.title == newItem.title
    }
}