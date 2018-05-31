package com.morse.ganio.mvp

import java.lang.ref.WeakReference
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy

/**
 * Presenter基类
 */
open abstract class BasePresenter<V : IView> : IPresenter<V> {

    var v: WeakReference<V>? = null
    var proxy: IView? = null

    fun getView(): IView? {
        return this!!.proxy
    }

    override fun attachView(v: V) {
        this.v = WeakReference(v)
        proxy = Proxy.newProxyInstance(v.javaClass.classLoader, v.javaClass.interfaces) { proxy, method, args -> method!!.invoke(v, args) } as IView?
    }

    override fun dettechView() {
        v = null
    }

}