package com.example.network.di

import com.example.core.network.BuildConfig
import com.example.network.client.detailmovie.DetailMovieClient
import com.example.network.client.movies.MoviesClient
import com.example.network.client.searchmovie.SearchMovieClient
import com.example.network.interceptor.MovieApiInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
interface NetworkModule {

    companion object {

        @Provides
        @Singleton
        fun provideRetrofit(): Retrofit {
            val builderInterceptor = OkHttpClient.Builder()
                .addInterceptor(MovieApiInterceptor())
                .build()

            return Retrofit.Builder()
                .baseUrl(BuildConfig.MOVIES_API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(builderInterceptor)
                .build()
        }

        @Provides
        @Singleton
        fun provideMoviesClient(retrofit: Retrofit): MoviesClient {
            return retrofit.create(MoviesClient::class.java)
        }

        @Provides
        @Singleton
        fun provideDetailMovieClient(retrofit: Retrofit): DetailMovieClient {
            return retrofit.create(DetailMovieClient::class.java)
        }

        @Provides
        @Singleton
        fun provideSearchMovieClient(retrofit: Retrofit): SearchMovieClient {
            return retrofit.create(SearchMovieClient::class.java)
        }
    }
}