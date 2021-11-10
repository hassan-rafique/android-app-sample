package com.devcrew.baseproject.domain.entity

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @SerializedName("Status")
    val status: Int,

    @SerializedName("Message")
    val message: String,

    @SerializedName("data")
    val data: T
)
