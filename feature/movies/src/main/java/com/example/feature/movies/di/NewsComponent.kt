package com.example.feature.movies.di

import com.example.feature.movies.presentation.store.NewsStore
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