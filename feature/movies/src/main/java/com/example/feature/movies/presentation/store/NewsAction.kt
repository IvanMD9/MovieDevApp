package com.example.feature.movies.presentation.store

interface NewsAction {

    data class OnClickMenu(val showMenu: Boolean) : NewsAction

    data class OnClickItemMenu(val country: String) : NewsAction
}