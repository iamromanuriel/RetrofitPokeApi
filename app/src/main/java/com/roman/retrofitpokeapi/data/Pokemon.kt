package com.roman.retrofitpokeapi.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Pokemon (
    @Expose @SerializedName("id") val id: Int,
    @Expose @SerializedName("name") val name: String,
    @Expose @SerializedName("url") val url: String,
    @Expose @SerializedName("order") val order: Int,
    @Expose @SerializedName("is_default") val is_default: Boolean,
    @Expose @SerializedName("height") val height: Int,
    @Expose @SerializedName("weight") val weight: Int
)
