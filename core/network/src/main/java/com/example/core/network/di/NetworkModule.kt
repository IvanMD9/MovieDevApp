package com.example.core.network.di

import com.example.core.network.BuildConfig
import com.example.core.network.client.news.NewsClient
import com.example.core.network.client.searchnews.SearchNewsClient
import com.example.core.network.interceptor.NewsInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
interface NetworkModule {

    companion object {

        @Provides
        @Singleton
        fun provideRetrofit(): Retrofit {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)

            val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .addInterceptor(NewsInterceptor())
                .build()

            return Retrofit.Builder()
                .baseUrl(BuildConfig.NEWS_API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }

        @Provides
        @Singleton
        fun provideNewsClient(retrofit: Retrofit): NewsClient {
            return retrofit.create(NewsClient::class.java)
        }

        @Provides
        @Singleton
        fun provideSearchNewsClient(retrofit: Retrofit): SearchNewsClient {
            return retrofit.create(SearchNewsClient::class.java)
        }
    }
}