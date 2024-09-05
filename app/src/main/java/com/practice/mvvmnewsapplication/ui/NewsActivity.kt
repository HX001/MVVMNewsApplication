package com.practice.mvvmnewsapplication.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.practice.mvvmnewsapplication.R
import com.practice.mvvmnewsapplication.databinding.ActivityNewsBinding

class NewsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.bottomNavigationView.setupWithNavController(binding.)
//        bottomNavigationView.setupWithNavController(newsNavHostFragment.findNavController())
    }
}