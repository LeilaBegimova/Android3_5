package com.example.android3_5.data.remole.apicervies

import com.example.android3_5.data.models.HarryModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


private const val CHARACTER = "https://api.potterdb.com/v1/characters?"

interface HarryApi {
    @GET(CHARACTER)
    fun getCharacter(
        @Query("filter[name_cont]")query: String
    ): Call<HarryModel>
}
