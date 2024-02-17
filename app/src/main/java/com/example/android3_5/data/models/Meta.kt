package com.example.android3_5.data.models


import com.google.gson.annotations.SerializedName

data class Meta(
    @SerializedName("copyright")
    val copyright: String,
    @SerializedName("generated_at")
    val generatedAt: String,
    @SerializedName("pagination")
    val pagination: Pagination
)