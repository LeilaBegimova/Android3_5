package com.example.android3_5.data.models


import com.google.gson.annotations.SerializedName

data class Pagination(
    @SerializedName("current")
    val current: Int,
    @SerializedName("last")
    val last: Int,
    @SerializedName("next")
    val next: Int,
    @SerializedName("records")
    val records: Int
)