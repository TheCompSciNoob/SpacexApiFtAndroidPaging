package com.example.kyros.spacexapiftandroidpaging.viewmodel

import androidx.paging.DataSource
import com.example.kyros.spacexapiftandroidpaging.repo.Launch

class SpacexLaunchDataSourceFactory: DataSource.Factory<Int, Launch>() {
    override fun create(): DataSource<Int, Launch> {
        return SpacexLaunchDataSource()
    }
}