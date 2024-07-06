package com.example.feature.movies.domain.interactor

import com.example.feature.movies.domain.models.Movies

interface MoviesIntreactor {

    suspend fun getMovies(page: Int): Movies
}