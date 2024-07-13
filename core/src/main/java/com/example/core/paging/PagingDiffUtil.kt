package com.example.core.paging

open class PagingDiffUtil<in ItemType : Any> {

    open operator fun invoke(
        oldItem: ItemType,
        newItem: ItemType,
    ): Boolean = false
}