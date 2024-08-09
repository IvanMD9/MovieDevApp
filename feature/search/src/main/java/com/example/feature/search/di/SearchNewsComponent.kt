package com.example.feature.search.di

import com.example.feature.search.presentation.store.SearchNewsStore
import com.example.network.di.NetworkApi
import dagger.Component

@SearchNewsScope
@Component(
    modules = [SearchNewsModule::class],
    dependencies = [NetworkApi::class]
)
interface SearchNewsComponent {

    fun getSearchNewsStore(): SearchNewsStore

    @Component.Factory
    interface Factory {

        fun createNetworkApi(networkApi: NetworkApi): SearchNewsComponent
    }
}