package com.sandbox.autoscroller.view.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.sandbox.autoscroller.databinding.FragmentFeedBinding
import com.sandbox.autoscroller.di.module.viewmodel.ViewModelProviderFactory
import com.sandbox.autoscroller.model.models.Car
import com.sandbox.autoscroller.view.LoadingState
import com.sandbox.autoscroller.viewmodel.feed.FeedViewModel
import dagger.android.support.DaggerFragment
import kotlinx.coroutines.launch
import javax.inject.Inject


class FeedFragment : DaggerFragment() {
    private lateinit var binding: FragmentFeedBinding

    @Inject
    lateinit var factory: ViewModelProviderFactory
    private lateinit var viewModel: FeedViewModel

    private lateinit var adapter: FeedAdapter

    private val itemClickListener = object : OnItemClickListener {
        override fun onItemClick(position: Int, item: Any) {
            val carId = (item as Car).id

            // Navigate to detail fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFeedBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this, factory)[FeedViewModel::class.java]

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(requireContext())
        adapter = FeedAdapter()
        binding.mainRv.adapter = adapter
        binding.mainRv.layoutManager = layoutManager

        val scrollListener = PaginationScrollListener(layoutManager) {
            Toast.makeText(requireContext(), "Load more", Toast.LENGTH_SHORT).show()
            viewModel.getCars()
        }

        binding.mainRv.addOnScrollListener(scrollListener)
        adapter.setOnItemClickListener(itemClickListener)


        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.loadingState.collect() { state ->
                when (state) {
                    is LoadingState.Success -> {
                        binding.mainProgressPb.visibility = View.GONE

                        val cars = state.data as List<Car>
                        val currentList = adapter.currentList.toMutableList()
                        val newList = currentList + cars
                        adapter.submitList(newList)

                        scrollListener.setLoaded()
                    }

                    is LoadingState.Loading -> binding.mainProgressPb.visibility = View.VISIBLE
                    is LoadingState.Error -> {
                        binding.mainProgressPb.visibility = View.GONE
                        Toast.makeText(requireContext(), state.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.getCars()
    }
}