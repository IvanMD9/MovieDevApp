package com.example.network.client.searchmovie

import com.example.network.client.movies.models.MoviesContainerResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchMovieClient {

    @GET("/3/search/movie")
    suspend fun getSearchMovie(
        @Query("query") query: String,
        @Query("page") page: Int,
    ): MoviesContainerResponse
}