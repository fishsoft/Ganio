package com.morse.ganio.main.fragment

import com.morse.ganio.mvp.BasePresenter

class FragmentPresenter : BasePresenter<IFragment>() {

    private var model: FragmentModel? = null

    init {
        model = FragmentModel()
    }

    fun getFragmentMsg() {
        model!!.getFragmentInfo()
    }
}