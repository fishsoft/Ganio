package com.morse.ganio.mvp.ui

import com.morse.ganio.mvp.IPresenter
import com.morse.ganio.mvp.IView

/**
 * MVP生命周期代理
 */
class MVPCallbackImp<V : IView, P : IPresenter<V>> : MVPCallback<V, P> {

    private var callback: MVPCallback<V, P>? = null
    private var p: P? = null

    constructor(callback: MVPCallback<V, P>?) {
        this.callback = callback
    }

    override fun createPresenter(): P? {
        p = callback?.createPresenter()
        setPresenter(p)
        return getPresenter()
    }

    override fun getPresenter(): P? {
        return callback?.getPresenter()
    }

    override fun setPresenter(p: P?) {
        callback?.setPresenter(p)
    }

    override fun getMVPView(): V? {
        return callback?.getMVPView()
    }

    /**
     * 绑定View
     */
    fun attach() {
        callback?.getMVPView()?.let { callback?.getPresenter()?.attachView(it) }
    }

    /**
     * 解绑View
     */
    fun dettach() {
        callback?.getPresenter()?.dettechView()
    }
}