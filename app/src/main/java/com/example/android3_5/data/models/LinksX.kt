package com.example.android3_5.data.models


import com.google.gson.annotations.SerializedName

data class LinksX(
    @SerializedName("current")
    val current: String,
    @SerializedName("last")
    val last: String,
    @SerializedName("next")
    val next: String,
    @SerializedName("self")
    val self: String
)