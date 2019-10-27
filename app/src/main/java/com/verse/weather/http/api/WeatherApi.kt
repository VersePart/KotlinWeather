package com.verse.weather.http.api

import com.verse.weather.data.bean.MiWeather
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

interface WeatherApi {

    /**
     * http://weatherapi.market.xiaomi.com/wtr-v2/weather?cityId=101010100
     *
     * @param cityId 城市ID
     * @return 天气数据
     */
    @GET("weather")
    abstract fun getMiWeather(@Query("cityId") cityId: String): Observable<MiWeather>

    /**
     * http://knowweather.duapp.com/v1.0/weather/101010100
     *
     * @param cityId 城市ID
     * @return 天气数据
     */
//    @GET("v1.0/weather/{cityId}")
//    abstract fun getKnowWeather(@Path("cityId") cityId: String): Observable<KnowWeather>

}