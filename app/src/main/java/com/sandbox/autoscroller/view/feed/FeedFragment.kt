package com.sandbox.autoscroller.view.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.sandbox.autoscroller.databinding.FragmentFeedBinding
import com.sandbox.autoscroller.di.module.viewmodel.ViewModelProviderFactory
import com.sandbox.autoscroller.viewmodel.feed.FeedViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject


class FeedFragment : DaggerFragment() {
    private lateinit var binding: FragmentFeedBinding

    @Inject
    lateinit var factory: ViewModelProviderFactory
    private lateinit var viewModel: FeedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFeedBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this, factory)[FeedViewModel::class.java]

        return binding.root
    }
}