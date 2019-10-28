package com.verse.weather.home

import com.verse.weather.base.BasePresenter
import com.verse.weather.base.BaseView
import com.verse.weather.data.bean.Weather

interface HomePageContract {

    interface View<T> : BaseView<T> {
        fun displayWeather(weather: Weather)
    }

    interface Presenter : BasePresenter{
        fun loadWeather()
    }

}