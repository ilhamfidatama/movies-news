package com.ilham.detikcom_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.ilham.detikcom_test.adapter.MovieAdapter
import com.ilham.detikcom_test.databinding.ActivityMainBinding
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

        NetworkXProvider.isInternetConnectedLiveData.observe(this, {isOnline->
            Timber.e("device is online? $isOnline")
            if (isOnline)
                setOnlineAdapterData()
            else
                Timber.e("device is offline")
                setOfflineAdapterData()
        })
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