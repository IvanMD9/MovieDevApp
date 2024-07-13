package com.example.feature.movies.data.repository

import com.example.feature.movies.domain.models.MovieItem

interface MoviesRepository {

    suspend fun getMovies(page: Int): List<MovieItem>
}