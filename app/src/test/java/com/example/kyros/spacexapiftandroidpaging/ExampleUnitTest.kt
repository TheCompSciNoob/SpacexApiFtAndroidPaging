@file:Suppress("RemoveExplicitTypeArguments")

package com.example.kyros.spacexapiftandroidpaging

import com.example.kyros.spacexapiftandroidpaging.repo.SpacexRetrofitClient
import kotlinx.coroutines.runBlocking
import org.junit.Test
import retrofit2.await

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun getLaunches() = runBlocking<Unit> {
        val launches = SpacexRetrofitClient.service.getLaunches(5, 0).await()
        println("Launches: $launches")
    }

    @Test
    fun getAllLaunches() = runBlocking<Unit> {
        val allLaunches = SpacexRetrofitClient.service.getAllLaunches().await()
        println("All launches: $allLaunches")
        println("Number of launches: ${allLaunches.size}")
    }
}
