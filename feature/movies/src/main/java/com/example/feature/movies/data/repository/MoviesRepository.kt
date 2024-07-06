package com.example.feature.movies.data.repository

import com.example.feature.movies.domain.models.Movies

interface MoviesRepository {

    suspend fun getMovies(page: Int): Movies
}