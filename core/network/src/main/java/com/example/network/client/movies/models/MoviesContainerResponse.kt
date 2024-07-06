package com.example.network.client.movies.models

import com.google.gson.annotations.SerializedName

data class MoviesContainerResponse(
    @SerializedName("results") val results : List<MovieResponse>,
)
