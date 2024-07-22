package com.example.feature.detailsmovie.data.repository

import com.example.feature.detailsmovie.data.mapper.toDomain
import com.example.feature.detailsmovie.domain.models.DetailMovie
import com.example.network.client.detailmovie.DetailMovieClient
import javax.inject.Inject

class DetailMovieRepositoryImpl @Inject constructor(
    private val detailMovieClient: DetailMovieClient
) : DetailMovieRepository {

    override suspend fun getDetailMovie(movieUuid: Int): DetailMovie {
        return detailMovieClient
            .getDetailMovie(movieUuid)
            .toDomain()
    }
}