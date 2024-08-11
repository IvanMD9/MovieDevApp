package com.example.feature.news.di

import com.example.feature.news.presentation.store.NewsStore
import com.example.network.di.NetworkApi
import dagger.Component

@NewsScope
@Component(
    modules = [NewsModule::class],
    dependencies = [NetworkApi::class]
)
interface NewsComponent {

    fun getNewsStore(): NewsStore

    @Component.Factory
    interface Factory {

        fun createNetworkApi(networkApi: NetworkApi): NewsComponent
    }
}