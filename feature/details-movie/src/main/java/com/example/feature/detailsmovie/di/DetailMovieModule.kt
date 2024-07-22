package com.example.feature.detailsmovie.di

import com.example.feature.detailsmovie.data.repository.DetailMovieRepository
import com.example.feature.detailsmovie.data.repository.DetailMovieRepositoryImpl
import com.example.feature.detailsmovie.domain.interactor.DetailMovieInteractor
import com.example.feature.detailsmovie.domain.interactor.DetailMovieInteractorImpl
import com.example.feature.detailsmovie.presentation.store.DetailMovieStore
import com.example.feature.detailsmovie.presentation.store.DetailMovieStoreImpl
import dagger.Binds
import dagger.Module

@Module
interface DetailMovieModule {

    @DetailMovieScope
    @Binds
    fun bindDetailMovieRepository(impl: DetailMovieRepositoryImpl): DetailMovieRepository

    @DetailMovieScope
    @Binds
    fun bindDetailMovieInteractor(impl: DetailMovieInteractorImpl): DetailMovieInteractor

    @DetailMovieScope
    @Binds
    fun bindDetailMovieStore(impl: DetailMovieStoreImpl): DetailMovieStore
}