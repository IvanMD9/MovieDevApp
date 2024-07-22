package com.example.feature.detailsmovie.domain.interactor

import com.example.feature.detailsmovie.data.repository.DetailMovieRepository
import com.example.feature.detailsmovie.domain.models.DetailMovie
import javax.inject.Inject

class DetailMovieInteractorImpl @Inject constructor(
    private val repository: DetailMovieRepository
) : DetailMovieInteractor {

    override suspend fun getDetailMovie(movieUuid: Int): DetailMovie {
        return repository.getDetailMovie(movieUuid)
    }
}