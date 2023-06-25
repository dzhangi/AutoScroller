package com.sandbox.autoscroller.model.models

import com.google.gson.annotations.SerializedName

data class UserX(
    val about: String,
    @SerializedName("auto_count")
    val autoCount: Int,
    val avatar: AvatarX,
    val email: String,
    val id: Int,
    @SerializedName("main_auto_name")
    val mainAutoName: String,
    val username: String
)