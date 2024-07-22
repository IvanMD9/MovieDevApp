package com.example.feature.detailsmovie.data.repository

import com.example.feature.detailsmovie.domain.models.DetailMovie

interface DetailMovieRepository {

    suspend fun getDetailMovie(movieUuid: Int): DetailMovie
}