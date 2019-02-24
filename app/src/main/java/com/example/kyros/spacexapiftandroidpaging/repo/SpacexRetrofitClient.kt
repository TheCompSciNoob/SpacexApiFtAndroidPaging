package com.example.kyros.spacexapiftandroidpaging.repo

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object SpacexRetrofitClient {
    val BASE_URL: String = "https://api.spacexdata.com/v3/"
    val service: SpacexService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(SpacexService::class.java)
}