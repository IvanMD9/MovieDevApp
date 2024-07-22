package com.example.feature.detailsmovie.data.mapper

import com.example.feature.detailsmovie.domain.models.DetailMovie
import com.example.network.client.detailmovie.models.DetailMovieContainerResponse

fun DetailMovieContainerResponse.toDomain(): DetailMovie = DetailMovie(
    id = id,
    originalTitle = originalTitle,
    overview = overview,
    posterPath = posterPath,
    releaseDate = releaseDate,
)