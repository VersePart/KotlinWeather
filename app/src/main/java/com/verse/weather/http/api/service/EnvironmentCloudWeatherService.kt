package com.verse.weather.http.api.service

import com.verse.weather.data.bean.EnvironmentCloudCityAirLive
import com.verse.weather.data.bean.EnvironmentCloudForecast
import com.verse.weather.data.bean.EnvironmentCloudWeatherLive
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable

interface EnvironmentCloudWeatherService {

    /**
     * 获取指定城市的实时天气
     *
     *
     * API地址：http://service.envicloud.cn:8082/v2/weatherlive/YMFYB256AGFUZZE0ODQ3MZM1MZE2NTU=/101020100
     *
     * @param cityId 城市id
     * @return Observable
     */
    @GET("/v2/weatherlive/YMFYB256AGFUZZE0ODQ3MZM1MZE2NTU=/{cityId}")
    abstract fun getWeatherLive(@Path("cityId") cityId: String): Observable<EnvironmentCloudWeatherLive>

    /**
     * 获取指定城市7日天气预报
     *
     *
     * API地址：http://service.envicloud.cn:8082/v2/weatherforecast/YMFYB256AGFUZZE0ODQ3MZM1MZE2NTU=/101020100
     *
     * @param cityId 城市id
     * @return Observable
     */
    @GET("/v2/weatherforecast/YMFYB256AGFUZZE0ODQ3MZM1MZE2NTU=/{cityId}")
    abstract fun getWeatherForecast(@Path("cityId") cityId: String): Observable<EnvironmentCloudForecast>

    /**
     * 获取指定城市的实时空气质量
     *
     *
     * API地址：http://service.envicloud.cn:8082/v2/cityairlive/YMFYB256AGFUZZE0ODQ3MZM1MZE2NTU=/101020100
     *
     * @param cityId 城市id
     * @return Observable
     */
    @GET("/v2/cityairlive/YMFYB256AGFUZZE0ODQ3MZM1MZE2NTU=/{cityId}")
    abstract fun getAirLive(@Path("cityId") cityId: String): Observable<EnvironmentCloudCityAirLive>
}