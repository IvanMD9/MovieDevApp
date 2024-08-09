package com.example.feature.search.presentation.pager

import com.example.core.paging.PagingDiffUtil
import com.example.feature.search.domain.models.NewsSearchItem

object SearchMoviesDiffUtil : PagingDiffUtil<NewsSearchItem>() {

    override fun invoke(
        oldItem: NewsSearchItem,
        newItem: NewsSearchItem
    ): Boolean {
        return oldItem.title == newItem.title
    }
}