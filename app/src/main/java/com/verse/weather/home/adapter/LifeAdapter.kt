package com.verse.weather.home.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.verse.weather.App
import com.verse.weather.R
import com.verse.weather.data.bean.LifeIndex
import com.verse.weather.data.bean.WeatherForecast

class LifeAdapter(var layoutResId: Int = R.layout.item_life_index, data: MutableList<LifeIndex>?) :
    BaseQuickAdapter<LifeIndex, BaseViewHolder>(layoutResId, data)  {
    override fun convert(helper: BaseViewHolder, item: LifeIndex?) {
        helper.setImageDrawable(R.id.index_icon_image_view, item?.name?.let { getIndexDrawable(App.instance, it) })
        helper.setText(R.id.index_level_text_view, item?.index)
            .setText(R.id.index_name_text_view, item?.name)
    }

    private fun getIndexDrawable(context: Context, indexName: String): Drawable {
        var colorResourceId = R.drawable.ic_index_sunscreen
        if (indexName.contains("防晒")) {
            colorResourceId = R.drawable.ic_index_sunscreen
        } else if (indexName.contains("穿衣")) {
            colorResourceId = R.drawable.ic_index_dress
        } else if (indexName.contains("运动")) {
            colorResourceId = R.drawable.ic_index_sport
        } else if (indexName.contains("逛街")) {
            colorResourceId = R.drawable.ic_index_shopping
        } else if (indexName.contains("晾晒")) {
            colorResourceId = R.drawable.ic_index_sun_cure
        } else if (indexName.contains("洗车")) {
            colorResourceId = R.drawable.ic_index_car_wash
        } else if (indexName.contains("感冒")) {
            colorResourceId = R.drawable.ic_index_clod
        } else if (indexName.contains("广场舞")) {
            colorResourceId = R.drawable.ic_index_dance
        }
        return context.resources.getDrawable(colorResourceId)
    }
}