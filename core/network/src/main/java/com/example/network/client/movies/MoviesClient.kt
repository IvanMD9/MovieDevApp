package com.example.network.client.movies

import com.example.network.client.movies.models.NewsContainerResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesClient {

    @GET("v2/top-headlines?country=us")
    suspend fun getNews(
        @Query("page") page : Int
    ) : NewsContainerResponse
}