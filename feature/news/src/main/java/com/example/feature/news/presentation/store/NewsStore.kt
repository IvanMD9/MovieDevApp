package com.example.feature.news.presentation.store

import com.example.core.mvi.DisposableStore

interface NewsStore: DisposableStore<NewsAction, NewsState, NewsEvent>