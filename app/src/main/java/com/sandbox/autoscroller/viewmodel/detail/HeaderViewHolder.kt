package com.sandbox.autoscroller.viewmodel.detail

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sandbox.autoscroller.R
import com.sandbox.autoscroller.model.models.CarDetails

class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val avatar = itemView.findViewById<ImageView>(R.id.avatar_iv)
    private val userName = itemView.findViewById<TextView>(R.id.username_tv)
    private val carImage = itemView.findViewById<ImageView>(R.id.image_car_iv)
    private val carModel = itemView.findViewById<TextView>(R.id.car_model_info_tv)
    private val engine = itemView.findViewById<TextView>(R.id.engine_info_tv)

    fun bind(model: CarDetails) {
        loadImages(model)
        userName.text = model.user.username
        carModel.text = "${model.car.brandName} ${model.car.modelName}"
        engine.text = "${model.car.engineName} ${model.car.year}"
    }

    private fun loadImages(model: CarDetails) {
        Glide
            .with(itemView)
            .load(model.user.avatar.url)
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.baseline_error_outline_108)
            .circleCrop()
            .into(avatar)

        Glide
            .with(itemView)
            .load(model.car.images[0].url)
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.baseline_error_outline_108)
            .centerCrop()
            .into(carImage)
    }
}