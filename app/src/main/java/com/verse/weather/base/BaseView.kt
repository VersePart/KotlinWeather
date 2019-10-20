package com.verse.weather.base

interface BaseView<T> {

    fun setPresenter(presenter: T)

}