package com.morse.ganio.mvp.ui.activity

import com.morse.ganio.mvp.IPresenter
import com.morse.ganio.mvp.IView
import com.morse.ganio.mvp.ui.MVPCallback
import com.morse.ganio.mvp.ui.MVPCallbackImp

/**
 * Activity代理
 */
class DelegateActivityImp<V : IView, P : IPresenter<V>> : DelegateActivity {

    private var callback: MVPCallbackImp<V, P>? = null

    constructor(callback: MVPCallback<V, P>) {
        this!!.callback = MVPCallbackImp(callback)
    }

    override fun onCreate() {
        callback!!.createPresenter()
        callback!!.attach()
    }

    override fun onDestory() {
        callback!!.dettach()
    }

}