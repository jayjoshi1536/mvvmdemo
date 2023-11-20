package com.example.mvvm.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.mvvm.R
import com.example.mvvm.adapter.MainAdapter
import com.example.mvvm.databinding.ActivityMainBinding
import com.example.mvvm.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var movieAdapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        movieAdapter = MainAdapter()

        binding.recyclerview.apply {
            adapter = movieAdapter
        }

        viewModel.movieList.observe(this) {
            movieAdapter.setMovieList(it)
        }
        viewModel.setMovies()

        /*viewModel.fullName.observe(this, Observer { name ->
            binding.fullName.text = name
        })

        binding.search.setOnClickListener {
            viewModel.searchUser(binding.username.text.toString())
        }*/
    }
}