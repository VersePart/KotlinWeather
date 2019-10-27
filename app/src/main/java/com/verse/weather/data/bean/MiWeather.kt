package com.verse.weather.data.bean

data class MiWeather(
    val accu_cc: AccuCc,
    val accu_f5: AccuF5,
    val alert: List<Any>,
    val aqi: Aqi,
    val forecast: Forecast,
    val index: List<Index>,
    val realtime: Realtime,
    val today: Today,
    val yestoday: Yestoday
) {
    data class AccuCc(
        val EpochTime: String,
        val LocalObservationDateTime: String,
        val Pressure: String,
        val RealFeelTemperature: String,
        val RelativeHumidity: String,
        val UVIndex: String,
        val Visibility: String,
        val WindDirectionDegrees: String,
        val WindSpeed: String
    )

    data class AccuF5(
        val DailyForecasts: List<DailyForecast>,
        val EffectiveDate: String,
        val EffectiveEpochDate: String
    ) {
        data class DailyForecast(
            val Date: String,
            val EpochDate: String,
            val PrecipitationProbability: String,
            val Sun_EpochRise: String,
            val Sun_EpochSet: String,
            val Sun_Rise: String,
            val Sun_Set: String
        )
    }

    class Aqi(
    )

    data class Forecast(
        val city: String,
        val city_en: String,
        val cityid: String,
        val date: String,
        val date_y: String,
        val fchh: String,
        val fl1: String,
        val fl2: String,
        val fl3: String,
        val fl4: String,
        val fl5: String,
        val fl6: String,
        val fx1: String,
        val fx2: String,
        val img1: String,
        val img10: String,
        val img11: String,
        val img12: String,
        val img2: String,
        val img3: String,
        val img4: String,
        val img5: String,
        val img6: String,
        val img7: String,
        val img8: String,
        val img9: String,
        val img_single: String,
        val img_title1: String,
        val img_title10: String,
        val img_title11: String,
        val img_title12: String,
        val img_title2: String,
        val img_title3: String,
        val img_title4: String,
        val img_title5: String,
        val img_title6: String,
        val img_title7: String,
        val img_title8: String,
        val img_title9: String,
        val img_title_single: String,
        val index: String,
        val index48: String,
        val index48_d: String,
        val index48_uv: String,
        val index_ag: String,
        val index_cl: String,
        val index_co: String,
        val index_d: String,
        val index_ls: String,
        val index_tr: String,
        val index_uv: String,
        val index_xc: String,
        val st1: String,
        val st2: String,
        val st3: String,
        val st4: String,
        val st5: String,
        val st6: String,
        val temp1: String,
        val temp2: String,
        val temp3: String,
        val temp4: String,
        val temp5: String,
        val temp6: String,
        val tempF1: String,
        val tempF2: String,
        val tempF3: String,
        val tempF4: String,
        val tempF5: String,
        val tempF6: String,
        val weather1: String,
        val weather2: String,
        val weather3: String,
        val weather4: String,
        val weather5: String,
        val weather6: String,
        val week: String,
        val wind1: String,
        val wind2: String,
        val wind3: String,
        val wind4: String,
        val wind5: String,
        val wind6: String
    )

    data class Index(
        val code: String,
        val details: String,
        val index: String,
        val name: String,
        val otherName: String
    )

    data class Realtime(
        val SD: String,
        val WD: String,
        val WS: String,
        val WSE: String,
        val city: String,
        val cityid: String,
        val isRadar: String,
        val radar: String,
        val temp: String,
        val time: String,
        val weather: String
    )

    data class Today(
        val cityCode: String,
        val date: String,
        val humidityMax: Int,
        val humidityMin: Int,
        val precipitationMax: Int,
        val precipitationMin: Int,
        val tempMax: Int,
        val tempMin: Int,
        val weatherEnd: String,
        val weatherStart: String,
        val windDirectionEnd: String,
        val windDirectionStart: String,
        val windMax: Int,
        val windMin: Int
    )

    data class Yestoday(
        val cityCode: String,
        val date: String,
        val humidityMax: Int,
        val humidityMin: Int,
        val precipitationMax: Int,
        val precipitationMin: Int,
        val tempMax: Int,
        val tempMin: Int,
        val weatherEnd: String,
        val weatherStart: String,
        val windDirectionEnd: String,
        val windDirectionStart: String,
        val windMax: Int,
        val windMin: Int
    )
}