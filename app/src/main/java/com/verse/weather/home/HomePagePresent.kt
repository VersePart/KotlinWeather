package com.verse.weather.home

import com.verse.weather.data.bean.MiWeather
import com.verse.weather.http.api.WeatherApi
import com.verse.weather.http.helper.RetrofitHelper
import com.verse.weather.util.RxSchedulerUtils
import rx.Observer

class HomePagePresent(val view: HomePageContract.View<HomePagePresent>) : HomePageContract.Presenter {
    override fun loadWeather() {
        RetrofitHelper.getRetrofitHelper("", WeatherApi::class.java)
            .getMiWeather("")
            .compose(RxSchedulerUtils.getTransformer())


            .subscribe(object :Observer<MiWeather>{
                override fun onCompleted(){

                }

                override fun onError(e: Throwable?){

                }

                override fun onNext(response: MiWeather?){
                    response?.let { view.displayWeather(it) }
                }
            })
    }

    override fun subscribe() {
    }

    override fun unSubscribe() {
    }
}