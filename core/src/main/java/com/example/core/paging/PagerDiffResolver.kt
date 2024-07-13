package com.example.core.paging

internal class PagerDiffResolver<ItemType : Any>(
    private val diffUtil: PagingDiffUtil<ItemType>,
) {
    private val itemsCached = hashSetOf<ItemType>()

    fun checkUniqueness(
        items: List<ItemType>,
    ): List<ItemType> {
        val newItems = items.filter { item ->
            itemsCached.none { cacheItem ->
                diffUtil(cacheItem, item)
            }
        }
        itemsCached.addAll(newItems)
        return newItems
    }
}