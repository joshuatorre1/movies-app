package com.joshuatorre.moviesapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil3.load
import com.joshuatorre.moviesapp.R
import com.joshuatorre.moviesapp.data.model.movie.Movie
import com.joshuatorre.moviesapp.databinding.ItemListBinding

/*
class ListAdapter : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    private var list: List<Movie>? = ArrayList()

    fun setData(movies: List<Movie>?) {
        list = movies
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return ListViewHolder()
    }

    override fun onBindViewHolder(
        holder: ListViewHolder,
        position: Int
    ) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    class ListViewHolder(
        private val binding: ItemListBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            binding.ivPoster.load(movie.posterPath)
            binding.tvTitle.text = movie.title
        }
    }
}

 */