package com.example.network.client.movies.models

import com.google.gson.annotations.SerializedName

data class MoviesContainerResponse(
    @SerializedName("page") val page: Int,
    @SerializedName("results") val results : List<MovieResponse>,
)
