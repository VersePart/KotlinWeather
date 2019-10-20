package com.verse.weather.home

import com.verse.weather.http.api.WeatherApi
import com.verse.weather.http.helper.RetrofitHelper
import com.verse.weather.util.RxSchedulerUtils

class HomePagePresent : HomePageContract.Presenter {
    override fun loadWeather() {
        RetrofitHelper.getRetrofitHelper("", WeatherApi::class.java)
            .getMiWeather("")
    }

    override fun subscribe() {
    }

    override fun unSubscribe() {
    }
}