package com.verse.weather.data.bean

data class EnvironmentCloudForecast(
    val citycode: String,
    val cityname: String,
    val forecast: List<Forecast>,
    val rcode: Int,
    val rdesc: String,
    val suggestion: Suggestion
) {
    data class Forecast(
        val astro: Astro,
        val cond: Cond,
        val date: String,
        val hum: String,
        val pcpn: String,
        val pop: String,
        val pres: String,
        val tmp: Tmp,
        val uv: String,
        val vis: String,
        val wind: Wind
    ) {
        data class Astro(
            val mr: String,
            val ms: String,
            val sr: String,
            val ss: String
        )

        data class Cond(
            val cond_d: String,
            val cond_n: String
        )

        data class Tmp(
            val max: String,
            val min: String
        )

        data class Wind(
            val deg: String,
            val dir: String,
            val sc: String,
            val spd: String
        )
    }

    data class Suggestion(
        val air: Air,
        val comf: Comf,
        val cw: Cw,
        val drs: Drs,
        val flu: Flu,
        val sport: Sport,
        val trav: Trav,
        val uv: Uv
    ) {
        data class Air(
            val brf: String,
            val txt: String
        )

        data class Comf(
            val brf: String,
            val txt: String
        )

        data class Cw(
            val brf: String,
            val txt: String
        )

        data class Drs(
            val brf: String,
            val txt: String
        )

        data class Flu(
            val brf: String,
            val txt: String
        )

        data class Sport(
            val brf: String,
            val txt: String
        )

        data class Trav(
            val brf: String,
            val txt: String
        )

        data class Uv(
            val brf: String,
            val txt: String
        )
    }
}