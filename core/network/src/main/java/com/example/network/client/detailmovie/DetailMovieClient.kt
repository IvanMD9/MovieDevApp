package com.example.network.client.detailmovie

import com.example.network.client.detailmovie.models.DetailMovieContainerResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface DetailMovieClient {

    @GET("/3/movie/{movie_id}")
    suspend fun getDetailMovie(
        @Path("movie_id") id: Int
    ): DetailMovieContainerResponse
}