package com.example.core.news.paging

import com.example.core.paging.PagingDiffUtil
import com.example.core.news.model.NewsItem

object NewsDiffUtil : PagingDiffUtil<NewsItem>() {

    override fun invoke(
        oldItem: NewsItem,
        newItem: NewsItem
    ): Boolean {
        return oldItem.title == newItem.title
    }
}