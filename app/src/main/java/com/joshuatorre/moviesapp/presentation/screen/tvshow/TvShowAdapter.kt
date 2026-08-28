package com.joshuatorre.moviesapp.presentation.screen.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import coil3.load
import coil3.request.transformations
import coil3.transform.RoundedCornersTransformation
import com.joshuatorre.moviesapp.R
import com.joshuatorre.moviesapp.data.model.tvshow.TvShow
import com.joshuatorre.moviesapp.databinding.ItemListBinding
import java.util.Locale

class TvShowAdapter : RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {

    private var list = ArrayList<TvShow>()

    fun setData(tvShows: List<TvShow>) {
        list.clear()
        list.addAll(tvShows)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TvShowViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemListBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.item_list,
            parent,
            false
        )
        return TvShowViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: TvShowViewHolder,
        position: Int
    ) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    class TvShowViewHolder(
        private val binding: ItemListBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TvShow) {
            binding.ivPoster.load("https://image.tmdb.org/t/p/w500" + tvShow.posterPath) {
                transformations(RoundedCornersTransformation(radius = 12f))
            }
            binding.tvTitle.text = tvShow.name
            binding.tvRating.text = String.format(Locale.US, "%.1f", tvShow.voteAverage)
            binding.tvOverview.text = tvShow.overview
        }
    }
}