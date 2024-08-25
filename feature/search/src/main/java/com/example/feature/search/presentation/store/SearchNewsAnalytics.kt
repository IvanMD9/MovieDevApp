package com.example.feature.search.presentation.store

import android.os.Bundle
import com.example.core.analytics.event.AnalyticsEvent

sealed class SearchNewsAnalytics(
    override val name: String = "",
    override val bundle: Bundle = Bundle()
) : AnalyticsEvent(name = name, bundle = bundle) {

    data object SearchNewsBackButton : SearchNewsAnalytics() {

        override val name: String
            get() = "search_screen_click_back_button"
    }

    data object SearchNewsClearTextButton : SearchNewsAnalytics() {

        override val name: String
            get() = "search_screen_click_clear_text_button"
    }
}