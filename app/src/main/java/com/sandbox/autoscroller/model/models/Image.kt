package com.sandbox.autoscroller.model.models

import com.google.gson.annotations.SerializedName

data class Image(
    val id: Int,
    @SerializedName("image100")
    val image100: String,
    @SerializedName("image500")
    val image500: String,
    val index: Int,
    @SerializedName("is_primary")
    val isPrimary: Boolean,
    val size: Int,
    @SerializedName("thumbnail_url")
    val thumbnailUrl: String,
    val url: String
)