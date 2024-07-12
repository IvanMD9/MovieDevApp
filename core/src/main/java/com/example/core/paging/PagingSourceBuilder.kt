package com.example.core.paging

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingState
import java.util.concurrent.atomic.AtomicBoolean
import kotlinx.coroutines.flow.Flow

class PagingSourceBuilder<ItemType : Any>(
    private val requestPage: suspend (page: Int, pageSize: Int) -> List<ItemType>,
    private val initialPageNumber: Int = DEFAULT_INITIAL_PAGE_NUMBER,
    private val config: PagingConfig = DEFAULT_CONFIG,
    private val pagingDiffUtil: PagingDiffUtil<ItemType> = PagingDiffUtil(),
    private val onGetRefreshKey: ((Int?) -> Int?)? = null,
) {

    companion object {
        private const val DEFAULT_INITIAL_PAGE_NUMBER = 1
        private const val DEFAULT_PAGE_SIZE = 15

        private val DEFAULT_CONFIG = PagingConfig(
            pageSize = DEFAULT_PAGE_SIZE,
            enablePlaceholders = false,
        )
    }

    private var pagingSource: PagerPagingSource<ItemType>? = null
    private val isForceInvalidate = AtomicBoolean(false)

    val flow: Flow<PagingData<ItemType>>
        get() = Pager(
            config = config,
            pagingSourceFactory = ::createPagingSource,
        ).flow

    fun invalidate(force: Boolean) {
        isForceInvalidate.set(force)
        pagingSource?.invalidate()
    }

    private fun createPagingSource():  PagerPagingSource<ItemType> {
        pagingSource = PagerPagingSource(
            requestPage = requestPage,
            initialPageNumber = initialPageNumber,
            config = config,
            pagingDiffUtil = pagingDiffUtil,
            onGetRefreshKey = { state ->
                return@PagerPagingSource if (isForceInvalidate.get()) {
                    isForceInvalidate.set(false)
                    null
                } else {
                    calculateRefreshKey(state)
                }
            },
        )
        return requireNotNull(pagingSource)
    }

    private fun calculateRefreshKey(state: PagingState<Int, ItemType>): Int? {
        val key = pagingSource?.calculateRefreshKey(state)
        return onGetRefreshKey?.invoke(key) ?: key
    }
}
