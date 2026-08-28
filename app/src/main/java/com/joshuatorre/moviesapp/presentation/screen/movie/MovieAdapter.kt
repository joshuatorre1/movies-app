package com.joshuatorre.moviesapp.presentation.screen.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import coil3.load
import coil3.request.transformations
import coil3.transform.RoundedCornersTransformation
import com.joshuatorre.moviesapp.R
import com.joshuatorre.moviesapp.data.model.movie.Movie
import com.joshuatorre.moviesapp.databinding.ItemListBinding
import java.util.Locale

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.ListViewHolder>() {

    private var list = ArrayList<Movie>()

    fun setData(movies: List<Movie>) {
        list.clear()
        list.addAll(movies)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemListBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.item_list,
            parent,
            false
        )
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ListViewHolder,
        position: Int
    ) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    class ListViewHolder(
        private val binding: ItemListBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            binding.ivPoster.load("https://image.tmdb.org/t/p/w500" + movie.posterPath) {
                transformations(RoundedCornersTransformation(radius = 12f))
            }
            binding.tvTitle.text = movie.title
            binding.tvRating.text = String.format(Locale.US, "%.1f", movie.voteAverage)
            binding.tvOverview.text = movie.overview
        }
    }
}