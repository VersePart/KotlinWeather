package com.verse.weather.data.adapter

import com.verse.weather.data.bean.*

/**
 * @author baronzhang (baron[dot]zhanglei[at]gmail[dot]com)
 * 16/2/25
 */
abstract class WeatherAdapter {

    abstract val cityId: String

    abstract val cityName: String

    abstract val cityNameEn: String

    abstract val weatherLive: WeatherLive

    abstract val weatherForecasts: List<WeatherForecast>

    abstract val lifeIndexes: List<LifeIndex>

    abstract val airQualityLive: AirQualityLive

    val weather: Weather
        get() {

            val weather = Weather()
            weather.cityId = cityId
            weather.cityName = cityName
            weather.cityNameEn = cityNameEn
            weather.airQualityLive = airQualityLive
            weather.weatherForecasts = weatherForecasts
            weather.lifeIndexes = lifeIndexes
            weather.weatherLive = weatherLive
            return weather
        }
}
