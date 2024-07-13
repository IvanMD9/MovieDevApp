package com.example.feature.movies.di

import com.example.feature.movies.presentation.store.MoviesStore
import com.example.network.di.NetworkApi
import dagger.Component

@MoviesScope
@Component(
    modules = [MoviesModule::class],
    dependencies = [NetworkApi::class]
)
interface MoviesComponent {

    fun getMoviesStore(): MoviesStore

    @Component.Factory
    interface Factory {

        fun createNetworkApi(networkApi: NetworkApi): MoviesComponent
    }
}