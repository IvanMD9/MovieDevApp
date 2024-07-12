package com.example.feature.movies.data.mapper

import com.example.feature.movies.domain.models.MovieItem
import com.example.network.client.movies.models.MovieResponse

fun MovieResponse.toDomain(): MovieItem = MovieItem(
    id = id,
    originalTitle = originalTitle,
    overview = overview,
    posterPath = posterPath,
    releaseDate = releaseDate,
    voteAverage = voteAverage,
    voteCount = voteCount,
)