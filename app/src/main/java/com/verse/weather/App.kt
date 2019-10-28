package com.verse.weather

import android.app.Application

class App : Application() {


    override fun onCreate() {
        super.onCreate()
        instance = this
//        applicationComponent = DaggerApplicationComponent.builder()
//            .applicationModule(ApplicationModule(this))
//            .build()

    }

    companion object {
        lateinit var instance: App
    }

}