package com.example.feature.search.di

import com.example.core.analytics.di.AnalyticsApi
import com.example.feature.search.presentation.store.SearchNewsStore
import com.example.core.network.di.NetworkApi
import dagger.Component

@SearchNewsScope
@Component(
    modules = [SearchNewsModule::class],
    dependencies = [
        NetworkApi::class,
        AnalyticsApi::class
    ]
)
interface SearchNewsComponent {

    fun getSearchNewsStore(): SearchNewsStore

    @Component.Factory
    interface Factory {

        fun createNetworkApi(
            networkApi: NetworkApi,
            analyticsApi: AnalyticsApi,
        ): SearchNewsComponent
    }
}