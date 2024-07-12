package com.example.core.paging

import androidx.paging.PagingConfig
import androidx.paging.PagingSource
import androidx.paging.PagingState

open class PagerPagingSource<ItemType : Any>(
    private val requestPage: suspend (page: Int, pageSize: Int) -> List<ItemType>,
    private val initialPageNumber: Int,
    private val config: PagingConfig,
    pagingDiffUtil: PagingDiffUtil<ItemType> = PagingDiffUtil(),
    private val onGetRefreshKey: (state: PagingState<Int, ItemType>) -> Int?,
) : PagingSource<Int, ItemType>() {

    private val diffResolver = PagerDiffResolver(pagingDiffUtil)

    override fun getRefreshKey(state: PagingState<Int, ItemType>): Int? {
        return onGetRefreshKey(state)
    }

    fun calculateRefreshKey(state: PagingState<Int, ItemType>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val anchorPage = state.closestPageToPosition(anchorPosition) ?: return null
        return anchorPage.prevKey?.inc() ?: anchorPage.nextKey?.dec()
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ItemType> {
        val page: Int = params.key ?: initialPageNumber
        val pageSize: Int = params.loadSize.coerceAtMost(config.pageSize)
        return try {
            val pagingItem = requestPage(page, pageSize)
            val items = diffResolver.checkUniqueness(pagingItem)
            LoadResult.Page(
                data = items,
                prevKey = previousPage(page),
                nextKey = pagingItem.nextPage(page = page, pageSize = pageSize),
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    private fun List<ItemType>.nextPage(
        page: Int,
        pageSize: Int,
    ): Int? = if (size == pageSize) {
        page.inc()
    } else {
        null
    }

    private fun previousPage(
        page: Int,
    ): Int? = if (page > initialPageNumber) {
        page.dec()
    } else {
        null
    }
}