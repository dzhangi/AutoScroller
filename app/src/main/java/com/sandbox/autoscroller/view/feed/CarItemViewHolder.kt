package com.sandbox.autoscroller.view.feed

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.sandbox.autoscroller.R
import com.sandbox.autoscroller.model.models.Car

class CarItemViewHolder(itemView: View) : ViewHolder(itemView) {
    private val image: ImageView = itemView.findViewById<ImageView>(R.id.image_car_iv)
    private val info: TextView = itemView.findViewById<TextView>(R.id.car_short_info_tv)

    fun bind(model: Car) {
        Glide
            .with(itemView)
            .load(model.thumbnail)
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.baseline_error_outline_108)
            .centerCrop()
            .into(image)

        info.text = "${model.brandName} ${model.modelName} ${model.engineName} ${model.year}"
    }
}