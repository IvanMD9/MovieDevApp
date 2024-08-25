package com.example.core.network.client.news

import com.example.core.network.client.news.models.NewsContainerResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsClient {

    @GET("v2/top-headlines")
    suspend fun getNews(
        @Query("page") page : Int,
        @Query("country") country : String,
    ) : NewsContainerResponse
}