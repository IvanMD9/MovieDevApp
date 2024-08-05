package com.example.network.client.movies.models

import com.google.gson.annotations.SerializedName

data class NewsContainerResponse(
    @SerializedName("status") val status: String,
    @SerializedName("totalResults") val totalResults: Int,
    @SerializedName("articles") val articles: List<NewsResponse>,
)
