package com.example.kyros.spacexapiftandroidpaging.viewmodel

import androidx.paging.PositionalDataSource
import com.example.kyros.spacexapiftandroidpaging.repo.Launch
import com.example.kyros.spacexapiftandroidpaging.repo.SpacexRetrofitClient

class SpacexLaunchDataSource : PositionalDataSource<Launch>() {

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Launch>) {
        val response = SpacexRetrofitClient.service.getLaunches(params.requestedLoadSize, params.requestedStartPosition).execute()
        callback.onResult(response.body() ?: listOf(), params.requestedStartPosition)
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Launch>) {
        val response = SpacexRetrofitClient.service.getLaunches(params.loadSize, params.startPosition).execute()
        callback.onResult(response.body() ?: listOf())
    }
}