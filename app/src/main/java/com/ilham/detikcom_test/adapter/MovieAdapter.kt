package com.ilham.detikcom_test.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ilham.detikcom_test.databinding.MovieItemBinding
import com.ilham.detikcom_test.model.Movie

class MovieAdapter: RecyclerView.Adapter<MovieAdapter.Holder>() {
    val diffCallback = object : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    val differ = AsyncListDiffer(this, diffCallback)

    fun submitMovies(movies: MutableList<Movie>) = differ.submitList(movies)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder = Holder(
        MovieItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    override fun getItemCount(): Int = differ.currentList.size

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