package com.example.network.client.news.models

import com.google.gson.annotations.SerializedName

data class NewsContainerResponse(
    @SerializedName("status") val status: String,
    @SerializedName("totalResults") val totalResults: Int,
    @SerializedName("articles") val articles: List<NewsResponse>,
)
