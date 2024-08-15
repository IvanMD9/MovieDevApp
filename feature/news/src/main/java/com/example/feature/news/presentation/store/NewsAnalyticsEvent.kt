package com.example.feature.news.presentation.store

import android.os.Bundle
import androidx.core.os.bundleOf
import com.example.analytics.event.AnalyticsEvent

sealed class NewsAnalyticsEvent(
    override val name: String = "",
    override val bundle: Bundle = Bundle()
) : AnalyticsEvent(name = name, bundle = bundle) {

    data object ClickMenuButton : NewsAnalyticsEvent() {

        override val name: String
            get() = "news_screen_click_menu_button"
    }

    data class ClickItemCountryMenu(
        val country: String
    ): NewsAnalyticsEvent() {

        override val name: String
            get() = "news_screen_click_item_country"

        override val bundle: Bundle
            get() = bundleOf("country" to country)
    }

    data object ClickSearchButton : NewsAnalyticsEvent() {

        override val name: String
            get() = "news_screen_click_search_button"
    }
}