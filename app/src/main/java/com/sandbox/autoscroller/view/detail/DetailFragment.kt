package com.sandbox.autoscroller.view.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.sandbox.autoscroller.R
import com.sandbox.autoscroller.di.module.viewmodel.ViewModelProviderFactory
import com.sandbox.autoscroller.viewmodel.detail.DetailViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class DetailFragment : DaggerFragment() {

    @Inject
    lateinit var factory: ViewModelProviderFactory
    private lateinit var viewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        return inflater.inflate(R.layout.fragment_detail, container, false)
    }
}