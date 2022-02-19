package com.ilham.movies_news.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ilham.movies_news.databinding.MovieItemBinding
import com.ilham.movies_news.model.Movie

class MovieAdapter: RecyclerView.Adapter<MovieAdapter.Holder>() {
    private val movies = mutableListOf<Movie>()

    fun submitMovies(movies: MutableList<Movie>) {
        this.movies.clear()
        this.movies.addAll(movies)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder = Holder(
        MovieItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int = movies.size

    inner class Holder(private val binding: MovieItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(movie: Movie){
            movie.apply {
                binding.tittleTv.text = title
                binding.dateTv.text = release_date
                binding.overviewTv.text = overview
            }
        }
    }
}