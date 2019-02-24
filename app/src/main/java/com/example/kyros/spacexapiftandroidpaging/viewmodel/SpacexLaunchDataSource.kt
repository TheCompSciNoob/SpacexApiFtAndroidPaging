package com.example.kyros.spacexapiftandroidpaging.viewmodel

import androidx.paging.PositionalDataSource
import com.example.kyros.spacexapiftandroidpaging.repo.Launch
import com.example.kyros.spacexapiftandroidpaging.repo.SpacexRetrofitClient
import kotlinx.coroutines.runBlocking
import retrofit2.await

@Suppress("RemoveExplicitTypeArguments")
class SpacexLaunchDataSource : PositionalDataSource<Launch>() {

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Launch>) = runBlocking<Unit> {
        val launches = SpacexRetrofitClient.service.getLaunches(params.requestedLoadSize, params.requestedStartPosition).await()
        callback.onResult(launches, params.requestedStartPosition)
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Launch>) = runBlocking<Unit> {
        val launches = SpacexRetrofitClient.service.getLaunches(params.loadSize, params.startPosition).await()
        callback.onResult(launches)
    }
}