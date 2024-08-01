package com.example.feature.search.data.repository

import com.example.feature.search.data.mapper.toDomain
import com.example.feature.search.domain.models.MovieItem
import com.example.network.client.searchmovie.SearchMovieClient
import javax.inject.Inject

class SearchMoviesRepositoryImpl @Inject constructor(
    private val searchMoviesClient: SearchMovieClient
) : SearchMoviesRepository {

    override suspend fun getSearchMovies(query: String, page: Int): List<MovieItem> {
        return searchMoviesClient
            .getSearchMovie(
                query = query,
                page = page
            )
            .results.map { item ->
                item.toDomain()
            }
    }
}