package com.example.feature.search.domain.interactor

import com.example.feature.search.domain.models.MovieItem

interface SearchMoviesIntreactor {

    suspend fun getSearchMovies(
        query: String,
        page: Int
    ): List<MovieItem>
}