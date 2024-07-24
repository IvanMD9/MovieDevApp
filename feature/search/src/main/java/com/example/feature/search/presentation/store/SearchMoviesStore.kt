package com.example.feature.search.presentation.store

import com.example.core.mvi.DisposableStore

interface SearchMoviesStore: DisposableStore<SearchMoviesAction, SearchMoviesState, SearchMoviesEvent>