package com.joshuatorre.moviesapp.presentation.screen.people

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import coil3.load
import coil3.request.transformations
import coil3.transform.RoundedCornersTransformation
import com.joshuatorre.moviesapp.R
import com.joshuatorre.moviesapp.data.model.people.People
import com.joshuatorre.moviesapp.databinding.ItemListBinding
import java.util.Locale

class PeopleAdapter : RecyclerView.Adapter<PeopleViewHolder>() {

    private var list = ArrayList<People>()

    fun setData(people: List<People>) {
        list.clear()
        list.addAll(people)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PeopleViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemListBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.item_list,
            parent,
            false
        )
        return PeopleViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: PeopleViewHolder,
        position: Int
    ) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
    }

    class PeopleViewHolder(
        private val binding: ItemListBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(people: People) {
            binding.ivPoster.load("https://image.tmdb.org/t/p/w500" + people.profilePath) {
                transformations(RoundedCornersTransformation(radius = 12f))
            }
            binding.tvTitle.text = people.name
            binding.tvRating.text = String.format(Locale.US, "%.1f", people.popularity)
            binding.tvOverview.text = people.knownForDepartment
    }
}