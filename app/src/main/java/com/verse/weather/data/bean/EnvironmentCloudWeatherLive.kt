package com.verse.weather.data.bean

data class EnvironmentCloudWeatherLive(
    val airpressure: String,
    val citycode: String,
    val feelst: String,
    val humidity: String,
    val phenomena: String,
    val rain: String,
    val rcode: Int,
    val rdesc: String,
    val temperature: String,
    val updatetime: String,
    val winddirect: String,
    val windpower: String,
    val windspeed: String
)