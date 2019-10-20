package com.verse.weather.widget

/**
 * @author baronzhang (baron[dot]zhanglei[at]gmail[dot]com)
 */
interface IndicatorValueChangeListener {

    fun onChange(currentIndicatorValue: Int, stateDescription: String, indicatorTextColor: Int)
}
