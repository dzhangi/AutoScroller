package com.sandbox.autoscroller.view.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sandbox.autoscroller.R
import com.sandbox.autoscroller.model.models.CarDetails
import com.sandbox.autoscroller.model.models.Post

class DetailAdapter(
    private val header: CarDetails,
    private val posts: List<Post>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_HEADER = 0
        private const val TYPE_POST = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_HEADER -> {
                val headerView = LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.item_detail_header, parent, false)
                HeaderViewHolder(headerView)
            }

            TYPE_POST -> {
                val postView = LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.item_detail_post, parent, false)
                PostViewHolder(postView)
            }

            else -> throw IllegalArgumentException("Unknown view type: $viewType")
        }
    }

    override fun getItemCount(): Int {
        return posts.size + 1
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is HeaderViewHolder -> holder.bind(header)
            is PostViewHolder -> holder.bind(posts[position - 1])
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) TYPE_HEADER else TYPE_POST
    }
}