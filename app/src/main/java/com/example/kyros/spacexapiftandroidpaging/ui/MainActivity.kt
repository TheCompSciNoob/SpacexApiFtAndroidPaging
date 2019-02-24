package com.example.kyros.spacexapiftandroidpaging.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kyros.spacexapiftandroidpaging.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) supportFragmentManager.beginTransaction()
                .replace(R.id.mainContainer, SpacexLaunchFragment())
                .commit()
    }
}
