package com.verse.weather.home

import android.content.Context
import android.text.TextUtils
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.verse.weather.R
import com.verse.weather.base.BaseFragment
import com.verse.weather.data.bean.LifeIndex
import com.verse.weather.data.bean.Weather
import com.verse.weather.data.bean.WeatherDetail
import com.verse.weather.data.bean.WeatherForecast
import com.verse.weather.home.adapter.DetailAdapter
import com.verse.weather.home.adapter.ForecastAdapter
import com.verse.weather.home.adapter.LifeAdapter
import com.verse.weather.widget.IndicatorValueChangeListener
import com.verse.weather.widget.TitleView
import kotlinx.android.synthetic.main.layout_title_view.view.*
import kotlinx.android.synthetic.main.fragment_home_page.*

class HomePageFragment : BaseFragment(), HomePageContract.View<HomePagePresent> {


//    @BindView(R.id.detail_recycler_view) lateinit var detail_recycler_view: RecyclerView

    private var mWeather: Weather? = null
    private var detailAdapter: DetailAdapter? = null
    private var forecastAdapter: ForecastAdapter? = null
    private var lifeAdapter: LifeAdapter? = null
    private var mHomePagePresent: HomePagePresent? = null
    private var mDetailList: MutableList<WeatherDetail> = mutableListOf()
    private var mForecastList: MutableList<WeatherForecast> = mutableListOf()
    private var mLifeList: MutableList<LifeIndex> = mutableListOf()

    private var mListener: OnFragmentInteractionListener? = null

    override fun getLayout(): Int {
        return R.layout.fragment_home_page
    }

    override fun initView(view: View) {
        setPresenter(HomePagePresent(this))
        var detail_title: TitleView = view.findViewById<TitleView>(R.id.detail_title)
        detail_title.title_text_view.setText("wangyang")


        detail_recycler_view.layoutManager = GridLayoutManager(activity, 3)
        detailAdapter = DetailAdapter(data = mDetailList)
        detail_recycler_view.adapter = detailAdapter

        forecast_recycler_view.layoutManager = LinearLayoutManager(activity)
        forecastAdapter = ForecastAdapter(data = mForecastList)
        forecast_recycler_view.adapter = forecastAdapter

        indicator_view_aqi.setIndicatorValueChangeListener(object : IndicatorValueChangeListener{
            override fun onChange(currentIndicatorValue: Int, stateDescription: String, indicatorTextColor: Int) {
                tv_aqi.setText(currentIndicatorValue.toString())
                if (mWeather?.airQualityLive?.quality == null) {
                    tv_quality.setText(stateDescription)
                } else {
                    tv_quality.setText(mWeather?.airQualityLive?.quality)
                }
                tv_aqi.setTextColor(indicatorTextColor)
                tv_quality.setTextColor(indicatorTextColor)
            }

        })

        life_index_recycler_view.layoutManager = GridLayoutManager(activity, 4)
        lifeAdapter = LifeAdapter(data = mLifeList)
        life_index_recycler_view.adapter = lifeAdapter


        mHomePagePresent?.loadWeather()
    }

    override fun displayWeather(weather: Weather) {
        mDetailList.clear()
        mDetailList.addAll(createDetails(weather))
        detailAdapter?.notifyDataSetChanged()

        mForecastList.clear()
        mForecastList.addAll(weather.weatherForecasts)
        forecastAdapter?.notifyDataSetChanged()

        val airQualityLive = weather.airQualityLive
        indicator_view_aqi.setIndicatorValue(airQualityLive.aqi)
        tv_advice.text = airQualityLive.advice

        val rank = airQualityLive.cityRank
        tv_city_rank.setText(if (TextUtils.isEmpty(rank)) "首要污染物: " + airQualityLive.primary else rank)

        mLifeList.clear()
        mLifeList.addAll(weather.lifeIndexes)
        lifeAdapter?.notifyDataSetChanged()

        mListener?.updatePageTitle(weather)
    }

    private fun createDetails(weather: Weather): Collection<WeatherDetail> {
        var details: MutableList<WeatherDetail> = mutableListOf()
        details.add(WeatherDetail(R.drawable.ic_index_sunscreen, "体感温度", weather.weatherLive.feelsTemperature + "°C"))
        details.add(WeatherDetail(R.drawable.ic_index_sunscreen, "湿度", weather.weatherLive.humidity + "%"))
//        details.add(new WeatherDetail(R.drawable.ic_index_sunscreen, "气压", (int) Double.parseDouble(weather.getWeatherLive().getAirPressure()) + "hPa"));
        details.add(WeatherDetail(R.drawable.ic_index_sunscreen, "紫外线指数", weather.weatherForecasts[0].uv))
        details.add(WeatherDetail(R.drawable.ic_index_sunscreen, "降水量", weather.weatherLive.rain + "mm"))
        details.add(WeatherDetail(R.drawable.ic_index_sunscreen, "降水概率", weather.weatherForecasts[0].pop + "%"))
        details.add(WeatherDetail(R.drawable.ic_index_sunscreen, "能见度", weather.weatherForecasts[0].visibility + "km"))
        return details
    }

    override fun setPresenter(presenter: HomePagePresent) {
        mHomePagePresent = presenter
    }

    override fun onResume() {
        super.onResume()
        mHomePagePresent?.subscribe()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener){
            mListener = context
        }
    }

    fun update() {
        mHomePagePresent?.subscribe()
    }

    companion object {
        fun getIntance(): HomePageFragment {
            return HomePageFragment()
        }
    }

    interface OnFragmentInteractionListener{
        abstract fun updatePageTitle(weather: Weather)

        /**
         * 更新完天气数据同时需要刷新侧边栏的已添加的城市列表
         *
         * @param weather 天气数据
         */
        abstract fun addOrUpdateCityListInDrawerMenu(weather: Weather)
    }
}