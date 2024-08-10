package com.example.network.client.news.models

import com.google.gson.annotations.SerializedName

data class NewsSourceResponse(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
)
