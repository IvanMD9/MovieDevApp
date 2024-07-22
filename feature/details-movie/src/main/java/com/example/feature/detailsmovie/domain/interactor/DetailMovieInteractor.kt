package com.example.feature.detailsmovie.domain.interactor

import com.example.feature.detailsmovie.domain.models.DetailMovie

interface DetailMovieInteractor {

    suspend fun getDetailMovie(movieUuid: Int): DetailMovie
}