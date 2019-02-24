package com.example.kyros.spacexapiftandroidpaging.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kyros.spacexapiftandroidpaging.R
import com.example.kyros.spacexapiftandroidpaging.viewmodel.SpacexLaunchViewModel
import kotlinx.android.synthetic.main.fragment_launches.*
import java.lang.IllegalStateException

class SpacexLaunchFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_launches, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //set up RecyclerView
        val launchViewModel : SpacexLaunchViewModel = activity?.let {
            ViewModelProviders.of(it).get(SpacexLaunchViewModel::class.java)
        } ?: throw IllegalStateException("Invalid (null) Activity, cannot create ViewModel.")
        val launchAdapter = SpacexLaunchAdapter()
        launchViewModel.launchesLiveData.observe(this, Observer {
            launchAdapter.submitList(it)
        })
        recyclerviewMainLaunches.apply {
            adapter = launchAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }
}
