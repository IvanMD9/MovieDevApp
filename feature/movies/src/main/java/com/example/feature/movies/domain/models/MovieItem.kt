package com.example.feature.movies.domain.models

data class MovieItem(
    val id: Int,
    val originalTitle: String,
    val overview: String,
    val posterPath: String,
    val releaseDate: String,
    val voteAverage: Double,
    val voteCount: Int,
)