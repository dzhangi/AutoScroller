package com.sandbox.autoscroller.view.feed

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

open class PaginationScrollListener(
    private val layoutManager: LinearLayoutManager,
    private val loadMoreItems: () -> Unit
) : RecyclerView.OnScrollListener() {

    private var isLoading = false

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        val totalItemCount = layoutManager.itemCount
        val lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition()

        if (lastVisibleItemPosition == totalItemCount - 1 && !isLoading) {
            loadMoreItems.invoke()
            isLoading = true
        }
    }

    fun setLoaded() {
        isLoading = false
    }
}