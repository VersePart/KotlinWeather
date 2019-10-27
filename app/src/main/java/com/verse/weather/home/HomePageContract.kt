package com.verse.weather.home

import com.verse.weather.base.BasePresenter
import com.verse.weather.base.BaseView
import com.verse.weather.data.bean.MiWeather

interface HomePageContract {

    interface View<T> : BaseView<T> {
        fun displayWeather(weather: MiWeather)
    }

    interface Presenter : BasePresenter{
        fun loadWeather()
    }

}