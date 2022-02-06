package com.ilham.detikcom_test

import androidx.lifecycle.*
import com.ilham.detikcom_test.api.BaseResponse
import com.ilham.detikcom_test.model.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    val movieRepository: MovieRepository
): ViewModel() {
    val movies = MutableLiveData<List<Movie>>()

    fun getOffline(): LiveData<List<Movie>> = movieRepository.getMoviesOffline()

    fun getOnline() = viewModelScope.launch {
        val response = movieRepository.getMoviesOnline()
        movies.postValue(handleResponse(response))
    }

    private fun handleResponse(response: Response<BaseResponse>): List<Movie>{
        val list = mutableListOf<Movie>()
        if (response.isSuccessful){
            response.body()?.let {
                if (it.results.isNotEmpty()){
                    list.addAll(it.results)
                    insertMovies(it.results)
                }
            }
        }
        return list
    }

    private fun insertMovies(movies: MutableList<Movie>) = viewModelScope.launch {
        movieRepository.insertMovies(movies)
    }
}