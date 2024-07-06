package com.example.feature.movies.data.repository

import com.example.feature.movies.data.mapper.toDomain
import com.example.feature.movies.domain.models.Movies
import com.example.network.client.movies.MoviesClient
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val moviesClient: MoviesClient
) : MoviesRepository {

    override suspend fun getMovies(page: Int): Movies {
        return moviesClient
            .getMovies(page)
            .toDomain()
    }
}