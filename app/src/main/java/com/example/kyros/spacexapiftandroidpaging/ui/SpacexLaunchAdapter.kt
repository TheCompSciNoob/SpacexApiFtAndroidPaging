package com.example.kyros.spacexapiftandroidpaging.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kyros.spacexapiftandroidpaging.repo.Launch

class SpacexLaunchAdapter : PagedListAdapter<Launch, RecyclerView.ViewHolder>(DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false)
        return object : RecyclerView.ViewHolder(itemView) {}
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val launch: Launch = getItem(position) ?: throw IllegalStateException("Launch at position $position is null. May have enabled placeholders?")
        with(holder.itemView) {
            val launchNameTextView: TextView = findViewById(android.R.id.text1)
            launchNameTextView.text = launch.mission_name
        }
    }
}

private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Launch>() {
    override fun areItemsTheSame(oldItem: Launch, newItem: Launch): Boolean {
        return oldItem.flight_number == newItem.flight_number
    }

    override fun areContentsTheSame(oldItem: Launch, newItem: Launch): Boolean {
        return oldItem == newItem
    }
}