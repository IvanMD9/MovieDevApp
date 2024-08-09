package com.example.feature.search.presentation.store

import com.example.core.mvi.DisposableStore

interface SearchNewsStore: DisposableStore<SearchNewsAction, SearchNewsState, SearchNewsEvent>