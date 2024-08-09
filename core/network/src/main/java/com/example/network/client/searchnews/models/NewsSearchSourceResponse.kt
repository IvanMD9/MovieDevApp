package com.example.network.client.searchnews.models

import com.google.gson.annotations.SerializedName

data class NewsSearchSourceResponse(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
)
