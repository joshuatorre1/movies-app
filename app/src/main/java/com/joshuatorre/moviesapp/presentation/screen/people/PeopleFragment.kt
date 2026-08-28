package com.joshuatorre.moviesapp.presentation.screen.people

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.joshuatorre.moviesapp.R
import com.joshuatorre.moviesapp.databinding.FragmentPeopleBinding
import com.joshuatorre.moviesapp.presentation.di.Injector
import javax.inject.Inject

class PeopleFragment : Fragment() {

    private lateinit var binding: FragmentPeopleBinding
    @Inject
    lateinit var factory: PeopleViewModelFactory
    private lateinit var viewModel: PeopleViewModel
    private lateinit var adapter: PeopleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireActivity().application as Injector).createPeopleSubComponent().inject(this)
        viewModel = ViewModelProvider(this, factory)[PeopleViewModel::class]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_people, container, false)
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