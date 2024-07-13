package com.example.network.client.movies

import com.example.network.client.movies.models.MoviesContainerResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesClient {

    @GET("/3/movie/popular")
    suspend fun getMovies(
        @Query("page") page : Int
    ) : MoviesContainerResponse
}