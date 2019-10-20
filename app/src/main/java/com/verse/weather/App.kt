package com.verse.weather

import android.app.Application

class App : Application() {

    lateinit var instance: App

    override fun onCreate() {
        super.onCreate()
        instance = this
//        applicationComponent = DaggerApplicationComponent.builder()
//            .applicationModule(ApplicationModule(this))
//            .build()

    }

}