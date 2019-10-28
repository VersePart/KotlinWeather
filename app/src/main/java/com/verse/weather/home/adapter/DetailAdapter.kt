package com.verse.weather.home.adapter

import android.widget.ImageView
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.verse.weather.R
import com.verse.weather.data.bean.WeatherDetail

class DetailAdapter(var layoutResId: Int = R.layout.item_detail, data: MutableList<WeatherDetail>?) :
    BaseQuickAdapter<WeatherDetail, BaseViewHolder>(layoutResId, data) {

    override fun convert(helper: BaseViewHolder, item: WeatherDetail?) {
        val imageView: ImageView = helper.getView(R.id.detail_icon_image_view)
        val detailKeyTextView: TextView = helper.getView(R.id.detail_key_text_view)
        val detailValueTextView: TextView = helper.getView(R.id.detail_value_text_view)

        item?.iconResourceId?.let { imageView.setImageResource(it) }
        item?.key?.let { detailKeyTextView.setText(it) }
        item?.value?.let { detailValueTextView.setText(it) }


    }
}