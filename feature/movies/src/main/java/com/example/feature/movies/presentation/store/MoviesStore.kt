package com.example.feature.movies.presentation.store

import com.example.core.mvi.DisposableStore

interface MoviesStore: DisposableStore<MoviesAction, MoviesState, MoviesEvent>