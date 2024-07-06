package com.example.network.client.detailmovie.models

import com.google.gson.annotations.SerializedName

data class DetailMovieGenres(
    @SerializedName ("id") val id: Int,
    @SerializedName ("name") val name: String
)
