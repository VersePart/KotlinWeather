package com.verse.weather.home.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.verse.weather.R
import com.verse.weather.data.bean.WeatherDetail

class DetailAdapter(var layoutResId: Int = R.layout.item_detail, data: MutableList<WeatherDetail>?) :
    BaseQuickAdapter<WeatherDetail, BaseViewHolder>(layoutResId, data) {
    override fun convert(helper: BaseViewHolder, item: WeatherDetail?) {

    }
}