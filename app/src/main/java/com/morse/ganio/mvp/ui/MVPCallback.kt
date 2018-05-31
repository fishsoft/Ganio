package com.morse.ganio.mvp.ui

import com.morse.ganio.mvp.IPresenter
import com.morse.ganio.mvp.IView

interface MVPCallback<V : IView, P : IPresenter<V>> {

    fun createPresenter(): P

    fun getPresenter(): P

    fun setPresenter(p: P?)

    fun getMVPView(): V

}