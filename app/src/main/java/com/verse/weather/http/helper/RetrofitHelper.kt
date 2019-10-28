package com.verse.weather.http.helper

import com.verse.weather.http.api.ApiConstants
import com.verse.weather.http.api.service.EnvironmentCloudWeatherService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitHelper private constructor(){

    companion object {

        val service: EnvironmentCloudWeatherService by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED){
            val builder = OkHttpClient().newBuilder()
            val client = builder.build()

            val retrofit = Retrofit.Builder()
                .client(client)
                .baseUrl(ApiConstants.ENVIRONMENT_CLOUD_WEATHER_API_HOST)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
            retrofit.create(EnvironmentCloudWeatherService::class.java)
        }

//        fun <T> getRetrofitHelper(baseUrl: String, clazz: Class<T>): T {
//            val builder = OkHttpClient().newBuilder()
//            val client = builder.build()
//
//            val retrofit = Retrofit.Builder()
//                .client(client)
//                .baseUrl(baseUrl)
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .build()
//            return retrofit.create(EnvironmentCloudWeatherService)
//        }
    }
}