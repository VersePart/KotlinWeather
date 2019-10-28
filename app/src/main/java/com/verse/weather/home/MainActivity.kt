package com.verse.weather.home

import android.graphics.Color
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import com.scwang.smartrefresh.layout.header.ClassicsHeader
import com.verse.weather.R
import com.verse.weather.base.BaseActivity
import com.verse.weather.data.bean.Weather
import com.verse.weather.util.DateConvertUtils
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_app_bar_main.*

class MainActivity : BaseActivity(), HomePageFragment.OnFragmentInteractionListener {

    override fun getLayout() = R.layout.activity_main

    override fun initView() {
//        setSupportActionBar(toolbar)

        //设置 Header 为 Material风格
        val header = ClassicsHeader(this)
        header.setPrimaryColors(this.resources.getColor(R.color.colorPrimary), Color.WHITE)
        refresh_layout.setRefreshHeader(header)
        refresh_layout.setOnRefreshListener {
            //下拉刷新
            var homePageFragemnt: Fragment? = supportFragmentManager.findFragmentById(R.id.fragment_container)
            if (homePageFragemnt == null) {
                homePageFragemnt = HomePageFragment.getIntance()
                supportFragmentManager.beginTransaction().add(R.id.fragment_container,
                    homePageFragemnt as HomePageFragment
                ).commit()
            } else{
                if (homePageFragemnt is HomePageFragment) {
                    (homePageFragemnt as HomePageFragment).update()
                }
            }
        }

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        var homePageFragemnt: Fragment? = supportFragmentManager.findFragmentById(R.id.fragment_container)
        if (homePageFragemnt == null) {
            homePageFragemnt = HomePageFragment.getIntance()
            supportFragmentManager.beginTransaction().add(R.id.fragment_container, homePageFragemnt as HomePageFragment).commit()
        }
    }

    override fun updatePageTitle(weather: Weather) {
        refresh_layout.finishLoadMore()
        collapsing_toolbar.title =weather.cityName
        toolbar.title =weather.cityName

        temp_text_view.text = weather.weatherLive.temp
        publish_time_text_view.text = getString(R.string.string_publish_time) + DateConvertUtils.timeStampToDate(weather.getWeatherLive().getTime(), DateConvertUtils.DATA_FORMAT_PATTEN_YYYY_MM_DD_HH_MM)
        weather_text_view.text =weather.weatherLive.weather

    }

    override fun addOrUpdateCityListInDrawerMenu(weather: Weather) {
    }
}
