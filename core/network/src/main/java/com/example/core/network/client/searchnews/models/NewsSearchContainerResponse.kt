package com.example.core.network.client.searchnews.models

import com.google.gson.annotations.SerializedName

data class NewsSearchContainerResponse(
    @SerializedName("status") val status: String,
    @SerializedName("totalResults") val totalResults: Int,
    @SerializedName("articles") val articles: List<NewsSearchResponse>,
)
