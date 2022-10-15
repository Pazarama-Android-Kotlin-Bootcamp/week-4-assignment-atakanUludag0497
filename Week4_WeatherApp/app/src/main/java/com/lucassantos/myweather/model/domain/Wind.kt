package com.lucassantos.myweather.model.domain

import com.google.gson.annotations.SerializedName

/**
 * Class used to complement the Weather class.
 */

data class Wind(
    @SerializedName("wind")
    val wind: Int
)