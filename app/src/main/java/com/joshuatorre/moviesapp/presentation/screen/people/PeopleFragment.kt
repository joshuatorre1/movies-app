package com.joshuatorre.moviesapp.presentation.screen.people

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.joshuatorre.moviesapp.R
import com.joshuatorre.moviesapp.databinding.FragmentPeopleBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PeopleFragment : Fragment() {

    private lateinit var binding: FragmentPeopleBinding
    @Inject
    lateinit var factory: PeopleViewModelFactory
    private lateinit var viewModel: PeopleViewModel
    private lateinit var adapter: PeopleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, factory)[PeopleViewModel::class]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_people, container, false)
        ViewCompat.setOnApplyWindowInsetsListener(binding.rvPeople) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.updatePadding(top = systemBars.top)
            insets
        }
        ViewCompat.setOnApplyWindowInsetsListener(binding.swipeRefresh) { _, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            val displayCutout = insets.getInsets(WindowInsetsCompat.Type.displayCutout())
            val topInset = maxOf(systemBars.top, displayCutout.top)

            binding.swipeRefresh.setProgressViewOffset(
                false,
                0,
                topInset + resources.getDimensionPixelSize(R.dimen.swipe_refresh_spinner_size)
            )
            insets
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        binding.loadingAnimation.visibility = View.VISIBLE
        viewModel.getPeople().observe(requireActivity(), Observer {
            if (it.isNullOrEmpty().not()) {
                adapter.setData(people = it)
            }
            binding.loadingAnimation.visibility = View.GONE
        })

        // Swipe-to-refresh
        binding.swipeRefresh.setOnRefreshListener {
            viewModel.updatePeople().observe(requireActivity(), Observer {
                if (it.isNullOrEmpty().not()) {
                    adapter.setData(people = it)
                }
                binding.swipeRefresh.isRefreshing = false
            })
        }
    }

    private fun initRecyclerView() {
        adapter = PeopleAdapter()
        binding.rvPeople.layoutManager = LinearLayoutManager(requireActivity())
        binding.rvPeople.adapter = adapter
    }
}