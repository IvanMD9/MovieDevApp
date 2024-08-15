package com.example.feature.search.presentation.store

interface SearchNewsAction {

    data class OnValueChanged(val value: String) : SearchNewsAction

    data object OnClickClearText : SearchNewsAction

    data object OnClickBack : SearchNewsAction
}