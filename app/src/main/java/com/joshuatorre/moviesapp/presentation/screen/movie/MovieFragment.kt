package com.joshuatorre.moviesapp.presentation.screen.movie

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.joshuatorre.moviesapp.R
import com.joshuatorre.moviesapp.databinding.FragmentMovieBinding
import com.joshuatorre.moviesapp.presentation.di.Injector
import javax.inject.Inject

class MovieFragment : Fragment() {

    private lateinit var binding: FragmentMovieBinding
//    private lateinit var adapter: ListAdapter
//    private val viewModel: MovieViewModel by viewModels()

    @Inject
    lateinit var factory: MovieViewModelFactory
    private lateinit var viewModel: MovieViewModel

    companion object {
        private val TAG = MovieFragment::class.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireActivity().application as Injector).createMovieSubComponent().inject(this)
        viewModel = ViewModelProvider(this, factory)[MovieViewModel::class]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        adapter = ListAdapter()
        viewModel.getMovies().observe(requireActivity(), Observer {
//            adapter.setData(movies = it)
            Log.i(TAG, it.toString())
        })
    }
}