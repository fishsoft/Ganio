package com.morse.ganio.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.morse.ganio.mvp.ui.fragment.MVPFragment

class GankFragment : MVPFragment<IFragment, FragmentPresenter>() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun createPresenter(): FragmentPresenter {
        return FragmentPresenter()
    }

}