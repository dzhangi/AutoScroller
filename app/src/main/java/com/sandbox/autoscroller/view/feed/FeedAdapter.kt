package com.sandbox.autoscroller.view.feed

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.sandbox.autoscroller.R
import com.sandbox.autoscroller.model.models.Car

class FeedAdapter() : ListAdapter<Car, CarItemViewHolder>(DIFF_CALLBACK) {
    private var listener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarItemViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_car, parent, false)
        return CarItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarItemViewHolder, position: Int) {
        val car = currentList[position]
        holder.bind(car)

        holder.itemView.setOnClickListener {
            listener?.onItemClick(position, car)
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Car>() {
            override fun areItemsTheSame(oldItem: Car, newItem: Car): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Car, newItem: Car): Boolean {
                return oldItem == newItem
            }
        }
    }
}