package com.example.feature.movies.data.repository

import com.example.feature.movies.data.mapper.toDomain
import com.example.feature.movies.domain.models.MovieItem
import com.example.network.client.movies.MoviesClient
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val moviesClient: MoviesClient
) : MoviesRepository {

    override suspend fun getMovies(page: Int): List<MovieItem> {
        return moviesClient
            .getMovies(page)
            .results.map { item ->
                item.toDomain()
            }
    }
}