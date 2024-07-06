package com.example.feature.movies.data.mapper

import com.example.feature.movies.domain.models.MovieItem
import com.example.feature.movies.domain.models.Movies
import com.example.network.client.movies.models.MovieResponse
import com.example.network.client.movies.models.MoviesContainerResponse

fun MoviesContainerResponse.toDomain(): Movies = Movies(
    items = results.map { movie ->
        movie.toDomain()
    }
)

fun MovieResponse.toDomain(): MovieItem = MovieItem(
    id = id,
    originalTitle = originalTitle,
    overview = overview,
    posterPath = posterPath,
    releaseDate = releaseDate,
    voteAverage = voteAverage,
    voteCount = voteCount,
)