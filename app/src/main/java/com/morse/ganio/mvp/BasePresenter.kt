package com.morse.ganio.mvp

import java.lang.ref.WeakReference

/**
 * Presenter基类
 */
abstract class BasePresenter<V : IView> : IPresenter<V> {

    var v: WeakReference<V>?? = null
    var proxy: V? = null

    fun getView(): IView? {
        return proxy?.let { it }
    }

    override fun attachView(v: V?) {
        v?.let {
            this@BasePresenter?.v = WeakReference(v!!)
            proxy = this@BasePresenter?.v?.get()
        }
    }

    override fun dettechView() {
        v = null
    }

}
