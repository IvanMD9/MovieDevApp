package com.example.feature.movies.domain.interactor

import com.example.feature.movies.data.repository.MoviesRepository
import com.example.feature.movies.domain.models.Movies
import javax.inject.Inject

class MoviesIntreactorImpl @Inject constructor(
    private val repository: MoviesRepository
) : MoviesIntreactor {

    override suspend fun getMovies(page: Int): Movies {
        return repository.getMovies(page)
    }
}