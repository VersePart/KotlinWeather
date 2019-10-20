package com.verse.weather.home

import com.verse.weather.R
import com.verse.weather.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_home_page.*

class HomePageFragment : BaseFragment() {
    override fun getLayout(): Int {
        return R.layout.fragment_home_page
    }

    companion object {
        fun getIntance(): HomePageFragment {
            return HomePageFragment()
        }
    }
}