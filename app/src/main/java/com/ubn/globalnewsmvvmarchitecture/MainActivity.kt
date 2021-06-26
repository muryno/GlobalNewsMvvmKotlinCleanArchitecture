package com.ubn.globalnewsmvvmarchitecture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.ubn.globalnewsmvvmarchitecture.databinding.ActivityMainBinding
import com.ubn.globalnewsmvvmarchitecture.presentation.viewmodel.NewsViewModel
import com.ubn.globalnewsmvvmarchitecture.presentation.viewmodel.NewsViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: NewsViewModelFactory

     lateinit var viewModel: NewsViewModel
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this,factory)
                .get(NewsViewModel::class.java)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bnvNews.setupWithNavController(
                fragment.findNavController()
        )

    }
}