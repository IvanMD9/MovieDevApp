package com.example.feature.movies.domain.interactor

import com.example.feature.movies.domain.models.MovieItem

interface MoviesIntreactor {

    suspend fun getMovies(page: Int): List<MovieItem>
}