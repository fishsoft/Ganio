package com.morse.ganio.mvp.ui

import android.util.Log
import com.morse.ganio.mvp.IPresenter
import com.morse.ganio.mvp.IView

/**
 * MVP生命周期代理
 */
class MVPCallbackImp<V : IView, P : IPresenter<V>> : MVPCallback<V, P> {

    private var callback: MVPCallback<V, P>? = null
    private var p: P? = null

    constructor(callback: MVPCallback<V, P>) {
        this.callback = callback
    }

    override fun createPresenter(): P {
        if (null == p) {
            p = callback!!.createPresenter();
        }
        if (null == p) {
            throw NullPointerException("p is null")
        }
        Log.d("morse","createPresenter success")
        setPresenter(p)
        return getPresenter()
    }

    override fun getPresenter(): P {
        return callback!!.getPresenter()
    }

    override fun setPresenter(p: P?) {
        callback!!.setPresenter(p)
    }

    override fun getMVPView(): V {
        return callback!!.getMVPView()
    }

    /**
     * 绑定View
     */
    fun attach() {
        callback!!.getPresenter().attachView(callback!!.getMVPView())
    }

    /**
     * 解绑View
     */
    fun dettach() {
        callback!!.getPresenter().dettechView()
    }
}