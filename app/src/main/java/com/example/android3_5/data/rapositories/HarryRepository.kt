package com.example.android3_5.data.rapositories

import com.example.android3_5.data.models.Data
import com.example.android3_5.data.models.HarryModel
import com.example.android3_5.data.remole.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HarryRepository {
    private val hrCharacterApi = RetrofitClient.harryCharacterApi

    fun searchHarryPotter(
        query: String,
        onResponse: (harry: List<Data>) -> Unit,
        onFailure: (t: Throwable) -> Unit,
    ) {

        hrCharacterApi.getCharacter(query = query).enqueue(object : Callback<HarryModel> {
            override fun onResponse(
                call: Call<HarryModel>,
                response: Response<HarryModel>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    response.body()!!.data?.let { onResponse(it) }
                }
            }

            override fun onFailure(call: Call<HarryModel>, t: Throwable) {
                onFailure(t)
            }

        })
    }
}
