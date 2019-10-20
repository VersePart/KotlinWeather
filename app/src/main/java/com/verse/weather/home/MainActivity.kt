package com.verse.weather.home

import android.graphics.Color
import androidx.appcompat.app.ActionBarDrawerToggle
import com.scwang.smartrefresh.layout.header.ClassicsHeader
import com.verse.weather.R
import com.verse.weather.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_app_bar_main.*

class MainActivity : BaseActivity() {

    override fun getLayout() = R.layout.activity_main

    override fun initView() {
        setSupportActionBar(toolbar)

        //设置 Header 为 Material风格
        val header = ClassicsHeader(this)
        header.setPrimaryColors(this.resources.getColor(R.color.colorPrimary), Color.WHITE)
        refresh_layout.setRefreshHeader(header)
        refresh_layout.setOnRefreshListener {
            //下拉刷新
        }

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        var homePageFragemnt: HomePageFragment  = supportFragmentManager.findFragmentById(R.id.fragment_container) as HomePageFragment
        if (homePageFragemnt == null) {
            homePageFragemnt = HomePageFragment.getIntance()
            supportFragmentManager.beginTransaction().add(R.id.fragment_container, homePageFragemnt)
        }

    }
}
