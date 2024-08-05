package com.example.feature.movies.presentation.pager

import com.example.core.paging.PagingDiffUtil
import com.example.feature.movies.domain.models.NewsItem

object NewsDiffUtil : PagingDiffUtil<NewsItem>() {

    override fun invoke(
        oldItem: NewsItem,
        newItem: NewsItem
    ): Boolean {
        return oldItem.title == newItem.title
    }
}