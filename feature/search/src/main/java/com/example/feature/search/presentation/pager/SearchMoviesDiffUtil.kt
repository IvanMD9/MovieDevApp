package com.example.feature.search.presentation.pager

import com.example.core.paging.PagingDiffUtil
import com.example.feature.search.domain.models.MovieItem

object SearchMoviesDiffUtil : PagingDiffUtil<MovieItem>() {

    override fun invoke(
        oldItem: MovieItem,
        newItem: MovieItem
    ): Boolean {
        return oldItem.id == newItem.id
    }
}