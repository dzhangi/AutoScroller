package com.sandbox.autoscroller.view.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.sandbox.autoscroller.databinding.FragmentDetailBinding
import com.sandbox.autoscroller.di.module.viewmodel.ViewModelProviderFactory
import com.sandbox.autoscroller.view.LoadingState
import com.sandbox.autoscroller.viewmodel.detail.AllInfo
import com.sandbox.autoscroller.viewmodel.detail.DetailViewModel
import dagger.android.support.DaggerFragment
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailFragment : DaggerFragment() {
    private lateinit var binding: FragmentDetailBinding

    @Inject
    lateinit var factory: ViewModelProviderFactory
    private lateinit var viewModel: DetailViewModel

    private val args: DetailFragmentArgs by lazy {
        DetailFragmentArgs.fromBundle(requireArguments())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.loadingState.collect { state ->
                when (state) {
                    is LoadingState.Success -> {
                        binding.detailProgressPb.visibility = View.GONE

                        val carDetails = (state.data as AllInfo).carDetails
                        val posts = (state.data as AllInfo).posts.posts

                        val adapter = DetailAdapter(carDetails, posts)
                        binding.detailRv.adapter = adapter
                        binding.detailRv.layoutManager = LinearLayoutManager(requireContext())
                    }

                    is LoadingState.Loading -> binding.detailProgressPb.visibility = View.VISIBLE
                    is LoadingState.Error -> {
                        binding.detailProgressPb.visibility = View.GONE
                        Toast.makeText(requireContext(), state.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.getInfo(args.carId)
    }
}