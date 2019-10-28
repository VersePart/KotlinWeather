package com.verse.weather.home.adapter

import android.text.TextUtils
import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.verse.weather.R
import com.verse.weather.data.bean.WeatherDetail
import com.verse.weather.data.bean.WeatherForecast

class ForecastAdapter(var layoutResId: Int = R.layout.item_forecast, data: MutableList<WeatherForecast>?) :
    BaseQuickAdapter<WeatherForecast, BaseViewHolder>(layoutResId, data)  {

    override fun convert(helper: BaseViewHolder, item: WeatherForecast?) {
        val imageView: ImageView = helper.getView(R.id.weather_icon_image_view)
        imageView.setImageResource(R.mipmap.ic_launcher)

        helper.setText(R.id.week_text_view, item?.week)
            .setText(R.id.date_text_view, item?.date)
            .setText(R.id.weather_text_view, if (TextUtils.isEmpty(item?.weather)) (if (item?.weatherDay === item?.weatherNight) item?.weatherDay else item?.weatherDay + "转" + item?.weatherNight) else item?.weather)
            .setText(R.id.temp_max_text_view, item?.tempMax.toString() + "°")
            .setText(R.id.temp_min_text_view, item?.tempMin.toString() + "°")

    }
}