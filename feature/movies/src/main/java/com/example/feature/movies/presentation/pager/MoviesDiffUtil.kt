package com.example.feature.movies.presentation.pager

import com.example.core.paging.PagingDiffUtil
import com.example.feature.movies.domain.models.MovieItem

object MoviesDiffUtil : PagingDiffUtil<MovieItem>() {

    override fun invoke(
        oldItem: MovieItem,
        newItem: MovieItem
    ): Boolean {
        return oldItem.id == newItem.id
    }
}