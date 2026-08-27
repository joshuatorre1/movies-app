package com.joshuatorre.moviesapp.presentation.screen.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.joshuatorre.moviesapp.R
import com.joshuatorre.moviesapp.databinding.FragmentMovieBinding
import com.joshuatorre.moviesapp.presentation.adapter.ListAdapter

class MovieFragment : Fragment() {

    private lateinit var binding: FragmentMovieBinding
    private lateinit var adapter: ListAdapter
    private val viewModel: MovieViewModel by viewModels()

    companion object {
        private val TAG = MovieFragment::class.simpleName
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.setContentView(requireActivity(), R.layout.fragment_movie)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ListAdapter()
        viewModel.getMovies().observe(requireActivity(), Observer {
            adapter.setData(movies = it)
        })
    }
}