package com.sandbox.autoscroller.viewmodel.feed

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class FeedViewModel @Inject constructor() : ViewModel() {
    fun testPrint() {
        println("FeedViewModel test DI...")
    }
}