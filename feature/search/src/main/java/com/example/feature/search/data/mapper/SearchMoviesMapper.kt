package com.example.feature.search.data.mapper

import com.example.feature.search.domain.models.MovieItem
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