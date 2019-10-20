package com.verse.weather.home

import com.verse.weather.base.BasePresenter
import com.verse.weather.base.BaseView

interface HomePageContract {

    interface View<T> : BaseView<T> {
        fun displayWeather()
    }

    interface Presenter : BasePresenter{
        fun loadWeather()
    }

}