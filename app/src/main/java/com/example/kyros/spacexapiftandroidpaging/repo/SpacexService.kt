package com.example.kyros.spacexapiftandroidpaging.repo

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SpacexService {

    @GET("launches")
    fun getAllLaunches(): Call<List<Launch>>

    @GET("launches")
    fun getLaunches(
            @Query("limit") pageSize: Int,
            @Query("offset") fromIndex: Int
    ): Call<List<Launch>>
}

