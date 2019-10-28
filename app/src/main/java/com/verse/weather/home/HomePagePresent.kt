package com.verse.weather.home

import android.util.Log
import com.verse.weather.data.adapter.CloudWeatherAdapter
import com.verse.weather.data.bean.*
import com.verse.weather.http.api.ApiConstants
import com.verse.weather.http.api.service.WeatherService
import com.verse.weather.http.helper.RetrofitHelper
import com.verse.weather.util.RxSchedulerUtils
import com.verse.weather.util.SPUtils
import rx.Observable
import rx.Observer
import rx.functions.Func3

class HomePagePresent(val view: HomePageContract.View<HomePagePresent>) : HomePageContract.Presenter {
    override fun loadWeather() {
        val cityId = SPUtils.getString(ApiConstants.CURRENT_CITY_ID, "101020100")
        var weatherLiveObservable: Observable<EnvironmentCloudWeatherLive> = RetrofitHelper.service.getWeatherLive(cityId)
        var forecastObservable: Observable<EnvironmentCloudForecast> = RetrofitHelper.service.getWeatherForecast(cityId)
        var airLiveObservable: Observable<EnvironmentCloudCityAirLive> = RetrofitHelper.service.getAirLive(cityId)

        Observable.combineLatest(weatherLiveObservable, forecastObservable, airLiveObservable, object : Func3<EnvironmentCloudWeatherLive, EnvironmentCloudForecast, EnvironmentCloudCityAirLive, Weather> {
            override fun call(
                weatherLive: EnvironmentCloudWeatherLive,
                forecast: EnvironmentCloudForecast,
                airLive: EnvironmentCloudCityAirLive
            ): Weather {
                return CloudWeatherAdapter(weatherLive, forecast, airLive).weather
            }

        }).compose(RxSchedulerUtils.getTransformer())
            .subscribe(object : Observer<Weather>{
                override fun onError(e: Throwable?) {
                    Log.d("wangyang", " onError   e = "+e?.toString())
                }

                override fun onNext(weather: Weather?) {
                    Log.d("wangyang", " onNext   weather = "+weather)
                    weather?.let { view.displayWeather(it) }
                }

                override fun onCompleted() {
                }

            })
    }

    override fun subscribe() {
        loadWeather()
    }

    override fun unSubscribe() {
    }
}