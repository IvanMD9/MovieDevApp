package com.example.feature.search.di

import com.example.feature.search.presentation.store.SearchMoviesStore
import com.example.network.di.NetworkApi
import dagger.Component

@SearchMoviesScope
@Component(
    modules = [SearchMoviesModule::class],
    dependencies = [NetworkApi::class]
)
interface SearchMoviesComponent {

    fun getSearchMoviesStore(): SearchMoviesStore

    @Component.Factory
    interface Factory {

        fun createNetworkApi(networkApi: NetworkApi): SearchMoviesComponent
    }
}