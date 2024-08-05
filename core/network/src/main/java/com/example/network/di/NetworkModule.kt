package com.example.network.di

import com.example.core.network.BuildConfig
import com.example.network.client.movies.MoviesClient
import com.example.network.client.searchmovie.SearchMovieClient
import com.example.network.interceptor.NewsInterceptor
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
        fun provideMoviesClient(retrofit: Retrofit): MoviesClient {
            return retrofit.create(MoviesClient::class.java)
        }

        @Provides
        @Singleton
        fun provideSearchMovieClient(retrofit: Retrofit): SearchMovieClient {
            return retrofit.create(SearchMovieClient::class.java)
        }
    }
}