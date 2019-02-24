package com.example.kyros.spacexapiftandroidpaging.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.kyros.spacexapiftandroidpaging.repo.Launch

class SpacexLaunchViewModel : ViewModel() {

    companion object {
        private val LAUNCHES_CONFIG = PagedList.Config.Builder()
                .setPageSize(10)
                .setEnablePlaceholders(false)
                .build()
    }

    val launchesLiveData: LiveData<PagedList<Launch>> =
            LivePagedListBuilder(SpacexLaunchDataSourceFactory(), LAUNCHES_CONFIG)
                    .build()
}