package com.verse.weather.home

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import com.verse.weather.R
import com.verse.weather.base.BaseFragment
import com.verse.weather.widget.TitleView
import kotlinx.android.synthetic.main.layout_title_view.view.*

class HomePageFragment : BaseFragment(), HomePageContract.View<HomePagePresent> {


    @BindView(R.id.detail_recycler_view) lateinit var detail_recycler_view: RecyclerView

    private lateinit var mHomePagePresent: HomePagePresent

    override fun getLayout(): Int {
        return R.layout.fragment_home_page
    }

    override fun initView(view: View) {
        setPresenter(HomePagePresent())
        var detail_title: TitleView = view.findViewById<TitleView>(R.id.detail_title)
        detail_title.title_text_view.setText("wangyang")

        mHomePagePresent.loadWeather()
    }

    override fun displayWeather() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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