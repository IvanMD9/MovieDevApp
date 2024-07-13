package com.example.feature.movies.domain.interactor

import com.example.feature.movies.data.repository.MoviesRepository
import com.example.feature.movies.domain.models.MovieItem
import javax.inject.Inject

class MoviesIntreactorImpl @Inject constructor(
    private val repository: MoviesRepository
) : MoviesIntreactor {

    override suspend fun getMovies(page: Int): List<MovieItem> {
        return repository.getMovies(page)
    }
}