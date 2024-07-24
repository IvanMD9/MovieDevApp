package com.example.feature.search.domain.interactor

import com.example.feature.search.data.repository.SearchMoviesRepository
import com.example.feature.search.domain.models.MovieItem
import javax.inject.Inject

class SearchMoviesIntreactorImpl @Inject constructor(
    private val repository: SearchMoviesRepository
) : SearchMoviesIntreactor {

    override suspend fun getSearchMovies(query: String, page: Int): List<MovieItem> {
        return repository.getSearchMovies(
            query = query,
            page = page
        )
    }
}