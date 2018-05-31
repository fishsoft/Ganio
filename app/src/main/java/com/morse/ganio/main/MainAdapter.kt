package com.morse.ganio.main

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter


class MainAdapter(manager: FragmentManager, num: Int) : FragmentPagerAdapter(manager) {

    private var fragments: List<Fragment>? = null
    private var num: Int = 0

    init {
        this.num = num
        fragments = ArrayList(num)
    }

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null

        return fragment!!
    }

    override fun getCount(): Int {
        return num
    }
}