package com.morse.ganio.mvp.ui

import com.morse.ganio.mvp.IPresenter
import com.morse.ganio.mvp.IView

class MVPCallbackImp<V : IView, P : IPresenter<V>> : MVPCallback<V, P> {

    private var callback: MVPCallback<V, P>? = null

    constructor(callback: MVPCallback<V, P>) {
        this.callback = callback
    }

    override fun createPresenter(): P {
        val p: P = callback!!.createPresenter()
        setPresenter(p)
        return getPresenter()
    }

    override fun getPresenter(): P {
        return callback!!.getPresenter()
    }

    override fun setPresenter(p: P?) {
        callback!!.setPresenter(p)
    }

    override fun getView(): V {
        return callback!!.getView()
    }

    /**
     * 绑定View
     */
    fun attach() {
        callback!!.getPresenter().attachView(callback!!.getView())
    }

    /**
     * 解绑View
     */
    fun dettach() {
        callback!!.getPresenter().dettechView()
        callback!!.setPresenter(null)
    }
}