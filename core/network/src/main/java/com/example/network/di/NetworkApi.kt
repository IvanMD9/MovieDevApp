package com.example.network.di

import com.example.network.client.movies.MoviesClient
import com.example.network.client.searchmovie.SearchMovieClient

interface NetworkApi {

    fun provideMoviesClient(): MoviesClient

    fun provideSearchMovieClient(): SearchMovieClient
}