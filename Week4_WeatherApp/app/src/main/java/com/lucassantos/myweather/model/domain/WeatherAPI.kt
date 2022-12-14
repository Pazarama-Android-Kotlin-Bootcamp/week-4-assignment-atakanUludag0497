package com.lucassantos.myweather.model.domain

import com.google.gson.annotations.SerializedName

/**
 * Class used to complement the Weather class.
 */

data class WeatherAPI(
    @SerializedName("main")
    val main: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("icon")
    val icon: String
)