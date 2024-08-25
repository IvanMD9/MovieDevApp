package com.example.core.network.client.searchnews

import com.example.core.network.client.searchnews.models.NewsSearchContainerResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchNewsClient {

    @GET("/v2/everything")
    suspend fun getSearchNews(
        @Query("q") query: String,
        @Query("page") page: Int,
    ): NewsSearchContainerResponse
}