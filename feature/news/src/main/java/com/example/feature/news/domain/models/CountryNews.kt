package com.example.feature.news.domain.models

import androidx.annotation.StringRes
import com.example.feature.news.R

enum class CountryNews(
    @StringRes val country: Int,
    val value: String
) {
    RUSSIAN(
        country = R.string.app_news_item_menu_russian_country,
        value = "ru"
    ),
    USA(
        country = R.string.app_news_item_menu_usa_country,
        value = "us"
    ),
}