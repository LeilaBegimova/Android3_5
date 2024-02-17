package com.example.android3_5.data.models


import com.google.gson.annotations.SerializedName

data class HarryModel(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("links")
    val links: LinksX,
    @SerializedName("meta")
    val meta: Meta
)