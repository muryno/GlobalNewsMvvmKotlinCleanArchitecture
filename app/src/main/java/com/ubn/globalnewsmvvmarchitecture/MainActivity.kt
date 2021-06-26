package com.ubn.globalnewsmvvmarchitecture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.ubn.globalnewsmvvmarchitecture.databinding.ActivityMainBinding
import com.ubn.globalnewsmvvmarchitecture.presentation.adapter.NewsAdapter
import com.ubn.globalnewsmvvmarchitecture.presentation.viewmodel.NewsViewModel
import com.ubn.globalnewsmvvmarchitecture.presentation.viewmodel.NewsViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: NewsViewModelFactory


    @Inject
    lateinit var newsAdapter: NewsAdapter


     lateinit var viewModel: NewsViewModel
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this,factory)
                .get(NewsViewModel::class.java)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment

        binding.bnvNews.setupWithNavController(
        navHostFragment.navController
        )

    }
}