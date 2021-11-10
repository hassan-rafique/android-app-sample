package com.devcrew.baseproject.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity
data class Plant(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @SerializedName("name")
    val name: String = "",

    @SerializedName("imageUrl")
    val image: String = "",

    @SerializedName("description")
    val description: String = ""
) : Serializable
