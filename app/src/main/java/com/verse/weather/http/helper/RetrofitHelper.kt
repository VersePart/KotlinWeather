package com.verse.weather.http.helper

import com.verse.weather.http.api.WeatherApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitHelper {

    companion object {
        fun <T> getRetrofitHelper(baseUrl: String, clazz: Class<T>): T {
            val builder = OkHttpClient().newBuilder()
            val client = builder.build()

            val retrofit = Retrofit.Builder()
                .client(client)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
            return retrofit.create(clazz)
        }
    }
}