package com.ilham.movies_news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.ilham.movies_news.adapter.MovieAdapter
import com.ilham.movies_news.databinding.ActivityMainBinding
import com.rommansabbir.networkx.NetworkXProvider
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MovieAdapter
    private val viewModel: MovieViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRv()

        val isOnline = NetworkXProvider.isInternetConnected
        if (isOnline)
            setOnlineAdapterData()
        else{
            Timber.e("device is offline")
            setOfflineAdapterData()
        }
        setOfflineAdapterData()
    }

    private fun setupRv(){
        adapter = MovieAdapter()
        binding.movieRv.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
            adapter = this@MainActivity.adapter
        }
    }

    private fun setOnlineAdapterData(){
        viewModel.getOnline()
        viewModel.movies.observe(this, {
            adapter.submitMovies(it.toMutableList())
        })
    }

    private fun setOfflineAdapterData(){
        Timber.e("going fetching data")
        viewModel.getOffline().observe(this, {
            adapter.submitMovies(it.toMutableList())
        })
    }
}