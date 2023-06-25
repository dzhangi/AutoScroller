package com.sandbox.autoscroller.viewmodel.detail

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sandbox.autoscroller.R
import com.sandbox.autoscroller.model.models.Post

class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val image = itemView.findViewById<ImageView>(R.id.image_post_iv)
    private val post = itemView.findViewById<TextView>(R.id.post_text_tv)
    private val likes = itemView.findViewById<TextView>(R.id.likes_count_tv)
    private val comments = itemView.findViewById<TextView>(R.id.comments_count_tv)

    fun bind(model: Post) {
        Glide
            .with(itemView)
            .load(model.img)
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.baseline_error_outline_108)
            .centerCrop()
            .into(image)

        post.text = model.text
        likes.text = model.likeCount.toString()
        comments.text = model.commentCount.toString()
    }
}