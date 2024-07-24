package com.example.feature.search.data.repository

import com.example.feature.search.domain.models.MovieItem

interface SearchMoviesRepository {

    suspend fun getSearchMovies(
        query: String,
        page: Int
    ): List<MovieItem>
}