package com.verse.weather.home

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import com.verse.weather.R
import com.verse.weather.base.BaseFragment
import com.verse.weather.data.bean.MiWeather
import com.verse.weather.data.bean.WeatherDetail
import com.verse.weather.widget.TitleView
import kotlinx.android.synthetic.main.layout_title_view.view.*

class HomePageFragment : BaseFragment(), HomePageContract.View<HomePagePresent> {


    @BindView(R.id.detail_recycler_view) lateinit var detail_recycler_view: RecyclerView

    private lateinit var mHomePagePresent: HomePagePresent
    private var mDetailList: MutableList<WeatherDetail> = mutableListOf()

    override fun getLayout(): Int {
        return R.layout.fragment_home_page
    }

    override fun initView(view: View) {
        setPresenter(HomePagePresent(this))
        var detail_title: TitleView = view.findViewById<TitleView>(R.id.detail_title)
        detail_title.title_text_view.setText("wangyang")


        mHomePagePresent.loadWeather()
    }

    override fun displayWeather(weather: MiWeather) {
        mDetailList.clear()
        mDetailList.addAll(createDetails(weather))


    }

    private fun createDetails(weather: MiWeather): Collection<WeatherDetail> {
        var list: MutableList<WeatherDetail> = mutableListOf()
//        list.add(WeatherDetail(R.drawable.ic_index_sunscreen, "体感温度", weather.))
        return list
    }

    override fun setPresenter(presenter: HomePagePresent) {
        mHomePagePresent = presenter
    }

    companion object {
        fun getIntance(): HomePageFragment {
            return HomePageFragment()
        }
    }
}