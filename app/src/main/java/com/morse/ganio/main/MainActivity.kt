package com.morse.ganio.main

import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.GravityCompat
import android.support.v4.view.ViewPager
import android.support.v7.app.ActionBarDrawerToggle
import com.morse.ganio.R
import com.morse.ganio.mvp.ui.activity.MVPActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : MVPActivity<IMain, MainPresenter>(), IMain {

    private var titles: Array<String>? = arrayOf("全部", "Android", "IOS", "休息视频", "福利", "拓展资源", "前端", "瞎推荐", "App", "闲读")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewPager()

        toolbar.title = ""
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        /*设置ToolBar标题，使用TestView显示*/
        tv_bar_title.text = titles?.get(0)

        val mToggle = ActionBarDrawerToggle(this, drawer_layout, toolbar, 0, 0)
        drawer_layout.addDrawerListener(mToggle)
        /*同步drawerlayout的状态*/
        mToggle.syncState()

        setListener()
    }

    fun initViewPager() {
        tabLayout.tabMode = TabLayout.MODE_SCROLLABLE
        for (i in titles!!.indices) {
            tabLayout.addTab(tabLayout.newTab())
        }
        viewpage.adapter = MainAdapter(manager = supportFragmentManager, num = tabLayout.tabCount)
        tabLayout?.setupWithViewPager(viewpage)
        //初始化标题
        for (i in titles!!.indices) {
            tabLayout.getTabAt(i)?.text = titles!![i]
        }

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
        viewpage.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
//                tabLayout.setSelectedTabIndicatorColor(Color.WHITE)
                tabLayout.getTabAt(position)?.select()
                tv_bar_title.text = tabLayout.getTabAt(position)?.text
            }

        })
    }

    override fun createPresenter(): MainPresenter {
        return MainPresenter()
    }

    /**
     * 设置监听器
     */
    private fun setListener() {
        nav.setNavigationItemSelectedListener { item ->
            tv_bar_title.text = item.title
            when (item.itemId) {
                R.id.nav_item0 -> {
                    viewpage.currentItem = 0
                }
                R.id.nav_item1 -> {
                    viewpage.currentItem = 0
                }
                R.id.nav_item2 -> {
                    viewpage.currentItem = 1
                }
                R.id.nav_item3 -> {
                    viewpage.currentItem = 2
                }
                R.id.nav_item4 -> {
                    viewpage.currentItem = 3
                }
                R.id.nav_item5 -> {
                    viewpage.currentItem = 4
                }
                R.id.nav_item6 -> {
                    viewpage.currentItem = 5
                }
                R.id.nav_item7 -> {
                    viewpage.currentItem = 6
                }
                R.id.nav_item8 -> {
                    viewpage.currentItem = 7
                }
                R.id.nav_item9 -> {
                    viewpage.currentItem = 8
                }
                R.id.nav_item10 -> {
                    viewpage.currentItem = 9
                }
            }
            drawer_layout.closeDrawer(GravityCompat.START)
            true
        }
    }
}
