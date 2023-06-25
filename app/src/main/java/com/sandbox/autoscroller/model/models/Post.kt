package com.sandbox.autoscroller.model.models

import com.google.gson.annotations.SerializedName

data class Post(
    val author: Author,
    @SerializedName("comment_count")
    val commentCount: Int,
    @SerializedName("created_at")
    val createdAt: String,
    val id: Int,
    val img: String,
    @SerializedName("like_count")
    val likeCount: Int,
    val text: String
)