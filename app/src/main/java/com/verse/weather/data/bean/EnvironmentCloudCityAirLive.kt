package com.verse.weather.data.bean

data class EnvironmentCloudCityAirLive(
    val AQI: String,
    val CO: String,
    val NO2: String,
    val PM10: String,
    val PM25: String,
    val SO2: String,
    val citycode: String,
    val o3: String,
    val primary: String,
    val rcode: Int,
    val rdesc: String,
    val time: String
)