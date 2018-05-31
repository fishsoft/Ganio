package com.morse.ganio.main

import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import com.morse.ganio.R
import com.morse.ganio.mvp.ui.activity.MVPActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : MVPActivity<IMain, MainPresenter>(), IMain {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewPager()
    }

    fun initViewPager() {
        tabLayout.tabMode = TabLayout.MODE_SCROLLABLE
        viewpage.adapter = MainAdapter(manager = supportFragmentManager, num = 10)
        tabLayout?.setupWithViewPager(viewpage)

        tabLayout.setSelectedTabIndicatorColor(Color.BLUE)
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewpage.currentItem = tab!!.position
            }

        })
        viewpage.addOnPageChangeListener(object :ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                tabLayout.setSelectedTabIndicatorColor(Color.WHITE)
                tabLayout.getTabAt(position)
            }

        })
    }

    override fun createPresenter(): MainPresenter {
        return MainPresenter()
    }
}
