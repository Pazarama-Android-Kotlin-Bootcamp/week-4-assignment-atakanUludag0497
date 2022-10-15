package com.lucassantos.myweather.model.domain

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * The only entity from the database, it will be obtained by the services layer and later saved in the database.
 */

@Entity
data class Weather(

    @PrimaryKey
    val idWeather: Long = 1,

    @SerializedName("name")
    val location: String,

    @SerializedName("weather")
    val weatherAPI: List<WeatherAPI>,

    @SerializedName("main")
    @Embedded val main: Main,

    @SerializedName("wind")
    @Embedded val wind: Wind
)