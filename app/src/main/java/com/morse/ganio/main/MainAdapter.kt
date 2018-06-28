package com.morse.ganio.main

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.morse.ganio.main.fragment.GankFragment
import kotlin.properties.Delegates


class MainAdapter(manager: FragmentManager, num: Int) : FragmentPagerAdapter(manager) {

    private var fragments: ArrayList<Fragment> by Delegates.notNull()
    private var num: Int = 0

    init {
        this.num = num
        fragments = ArrayList()
        for (i in 0..num) fragments!!.add(GankFragment.getInstance(i))
    }

    override fun getItem(position: Int): Fragment? {
        return fragments?.let {
            it[position]
        }
    }

    override fun getCount(): Int {
        return num
    }
}