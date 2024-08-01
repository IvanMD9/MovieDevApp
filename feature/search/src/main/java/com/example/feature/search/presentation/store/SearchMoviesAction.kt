package com.example.feature.search.presentation.store

interface SearchMoviesAction {

    data object Init : SearchMoviesAction

    data class OnValueChanged(val value: String) : SearchMoviesAction
}