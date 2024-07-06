package com.example.network.client.detailmovie.models

import com.google.gson.annotations.SerializedName

data class DetailMovieContainerResponse(
    @SerializedName("genres") val genres: List<DetailMovieGenres>,
    @SerializedName("id") val id: Int,
    @SerializedName("original_title") val originalTitle: String,
    @SerializedName("overview") val overview: String,
    @SerializedName("poster_path") val posterPath: String,
    @SerializedName("production_companies") val productionCompanies: List<DetailMovieCompanies>,
    @SerializedName("release_date") val releaseDate: String,
    @SerializedName("vote_average") val voteAverage: Double,
    @SerializedName("vote_count") val voteCount: Int,
)
