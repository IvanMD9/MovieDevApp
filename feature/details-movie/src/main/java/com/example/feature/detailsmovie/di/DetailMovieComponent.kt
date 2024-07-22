package com.example.feature.detailsmovie.di

import com.example.feature.detailsmovie.presentation.store.DetailMovieStore
import com.example.network.di.NetworkApi
import dagger.Component

@DetailMovieScope
@Component(
    modules = [DetailMovieModule::class],
    dependencies = [NetworkApi::class]
)
interface DetailMovieComponent {

    fun getDetailMovieStore(): DetailMovieStore

    @Component.Factory
    interface Factory {

        fun createNetworkApi(networkApi: NetworkApi): DetailMovieComponent
    }
}