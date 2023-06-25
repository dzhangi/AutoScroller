package com.sandbox.autoscroller.model.models

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("auto_count")
    val autoCount: Int,
    val avatar: Avatar,
    val id: Int,
    @SerializedName("main_auto_name")
    val mainAutoName: String,
    val username: String
)