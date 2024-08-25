package com.example.feature.news.di

import com.example.core.analytics.di.AnalyticsApi
import com.example.feature.news.presentation.store.NewsStore
import com.example.core.network.di.NetworkApi
import dagger.Component

@NewsScope
@Component(
    modules = [NewsModule::class],
    dependencies = [
        NetworkApi::class,
        AnalyticsApi::class
    ]
)
interface NewsComponent {

    fun getNewsStore(): NewsStore

    @Component.Factory
    interface Factory {

        fun createNetworkApi(
            networkApi: NetworkApi,
            analyticsApi: AnalyticsApi,
        ): NewsComponent
    }
}