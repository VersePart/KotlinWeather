package com.verse.weather.data.adapter

import com.verse.weather.data.bean.*
import com.verse.weather.util.DateConvertUtils

import java.util.ArrayList


/**
 * @author baronzhang (baron[dot]zhanglei[at]gmail[dot]com)
 * 2017/7/5
 */
class CloudWeatherAdapter(
    private val cloudWeatherLive: EnvironmentCloudWeatherLive,
    private val cloudForecast: EnvironmentCloudForecast,
    private val cloudCityAirLive: EnvironmentCloudCityAirLive
) : WeatherAdapter() {

    override val cityId: String
        get() = cloudWeatherLive.citycode

    override val cityName: String
        get() = cloudForecast.cityname

    override val cityNameEn: String
        get() = ""

    override val weatherLive: WeatherLive
        get() {

            val weatherLive = WeatherLive()
            weatherLive.airPressure = cloudWeatherLive.airpressure
            weatherLive.cityId = cloudWeatherLive.citycode
            weatherLive.feelsTemperature = cloudWeatherLive.feelst
            weatherLive.humidity = cloudWeatherLive.humidity
            weatherLive.rain = cloudWeatherLive.rain
            weatherLive.temp = cloudWeatherLive.temperature
            weatherLive.time = DateConvertUtils.dateToTimeStamp(cloudWeatherLive.updatetime, "yyyy-MM-dd HH:mm")
            weatherLive.weather = cloudWeatherLive.phenomena
            weatherLive.wind = cloudWeatherLive.winddirect
            weatherLive.windPower = cloudWeatherLive.windpower
            weatherLive.windSpeed = cloudWeatherLive.windspeed

            return weatherLive
        }

    override//            weatherForecast.setWeather();
    val weatherForecasts: List<WeatherForecast>
        get() {

            val weatherForecasts = ArrayList<WeatherForecast>()

            for ((astro, cond, date, hum, pcpn, pop, pres, tmp, uv, vis, wind) in cloudForecast.forecast) {

                val weatherForecast = WeatherForecast()
                weatherForecast.wind = wind.dir
                weatherForecast.cityId = cityId
                weatherForecast.humidity = hum
                weatherForecast.moonrise = astro.mr
                weatherForecast.moonset = astro.ms
                weatherForecast.pop = pop
                weatherForecast.precipitation = pcpn
                weatherForecast.pressure = pres
                weatherForecast.sunrise = astro.sr
                weatherForecast.sunset = astro.ss
                weatherForecast.tempMax = Integer.parseInt(tmp.max)
                weatherForecast.tempMin = Integer.parseInt(tmp.min)
                weatherForecast.uv = uv
                weatherForecast.visibility = vis
                weatherForecast.weatherDay = cond.cond_d
                weatherForecast.weatherNight = cond.cond_n
                weatherForecast.week = DateConvertUtils.convertDataToWeek(date)
                weatherForecast.date = DateConvertUtils.convertDataToString(date)
                weatherForecasts.add(weatherForecast)
            }

            return weatherForecasts
        }

    override val lifeIndexes: List<LifeIndex>
        get() {

            val (air, comf, cw, drs, flu, sport, trav, uv) = cloudForecast.suggestion

            val indexList = ArrayList<LifeIndex>()

            val index1 = LifeIndex()
            index1.cityId = cloudForecast.citycode
            index1.name = "空气质量"
            index1.index = air.brf
            index1.details = air.txt
            indexList.add(index1)

            val index2 = LifeIndex()
            index2.cityId = cloudForecast.citycode
            index2.name = "舒适度"
            index2.index = comf.brf
            index2.details = comf.txt
            indexList.add(index2)

            val index3 = LifeIndex()
            index3.cityId = cloudForecast.citycode
            index3.name = "穿衣"
            index3.index = drs.brf
            index3.details = drs.txt
            indexList.add(index3)

            val index4 = LifeIndex()
            index4.cityId = cloudForecast.citycode
            index4.name = "感冒"
            index4.index = flu.brf
            index4.details = flu.txt
            indexList.add(index4)

            val index5 = LifeIndex()
            index5.cityId = cloudForecast.citycode
            index5.name = "运动"
            index5.index = sport.brf
            index5.details = sport.txt
            indexList.add(index5)

            val index6 = LifeIndex()
            index6.cityId = cloudForecast.citycode
            index6.name = "旅游"
            index6.index = trav.brf
            index6.details = trav.txt
            indexList.add(index6)

            val index7 = LifeIndex()
            index7.cityId = cloudForecast.citycode
            index7.name = "紫外线"
            index7.index = uv.brf
            index7.details = uv.txt
            indexList.add(index7)

            val index8 = LifeIndex()
            index8.cityId = cloudForecast.citycode
            index8.name = "洗车"
            index8.index = cw.brf
            index8.details = cw.txt
            indexList.add(index8)

            return indexList
        }

    override//        airQualityLive.setAdvice("");
    //        airQualityLive.setCityRank("");
    val airQualityLive: AirQualityLive
        get() {

            val airQualityLive = AirQualityLive()
            airQualityLive.aqi = Integer.parseInt(cloudCityAirLive.AQI)
            airQualityLive.cityId = cloudCityAirLive.citycode
            airQualityLive.co = cloudCityAirLive.CO
            airQualityLive.no2 = cloudCityAirLive.NO2
            airQualityLive.o3 = cloudCityAirLive.o3
            airQualityLive.pm10 = Integer.parseInt(cloudCityAirLive.PM10)
            airQualityLive.pm25 = Integer.parseInt(cloudCityAirLive.PM25)
            airQualityLive.primary = cloudCityAirLive.primary
            airQualityLive.publishTime = cloudCityAirLive.time
            airQualityLive.quality = getAqiQuality(airQualityLive.aqi)
            airQualityLive.so2 = cloudCityAirLive.SO2
            return airQualityLive
        }

    private fun getAqiQuality(aqi: Int): String? {

        if (aqi <= 50) {
            return "优"
        } else if (aqi > 50 && aqi <= 100) {
            return "良"
        } else if (aqi > 100 && aqi <= 150) {
            return "轻度污染"
        } else if (aqi > 150 && aqi <= 200) {
            return "中度污染"
        } else if (aqi > 200 && aqi <= 300) {
            return "重度污染"
        } else if (aqi > 300 && aqi < 500) {
            return "严重污染"
        } else if (aqi >= 500) {
            return "污染爆表"
        }
        return null
    }
}
