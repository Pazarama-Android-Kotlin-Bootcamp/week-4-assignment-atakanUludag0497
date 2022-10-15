package com.lucassantos.myweather.model.domain

import com.google.gson.annotations.SerializedName

/**
 * Class used to complement the Weather class.
 */

data class Main(
    @SerializedName("temp")
    val temperature: Double,
    @SerializedName("feels_like")
    val feels_like: Double,
    @SerializedName("humidity")
    val humidity: String,
    @SerializedName("pressure")
    val pressure: Int,
)