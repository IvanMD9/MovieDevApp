package com.example.feature.movies.presentation.store

import com.example.core.mvi.DisposableStore

interface NewsStore: DisposableStore<NewsAction, NewsState, NewsEvent>