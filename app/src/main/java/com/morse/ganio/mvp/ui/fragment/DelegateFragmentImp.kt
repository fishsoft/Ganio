package com.morse.ganio.mvp.ui.fragment

import com.morse.ganio.mvp.IPresenter
import com.morse.ganio.mvp.IView
import com.morse.ganio.mvp.ui.MVPCallback
import com.morse.ganio.mvp.ui.MVPCallbackImp

/**
 * Fragment生命周期代理
 */
class DelegateFragmentImp<V : IView, P : IPresenter<V>> : DelegateFragment {

    private var callback: MVPCallbackImp<V, P>? = null

    constructor(callback: MVPCallback<V, P>) {
        this.callback = MVPCallbackImp(callback)
    }

    override fun onCreateView() {
        callback!!.createPresenter()
        callback!!.attach()
    }

    override fun onDestroy() {
        callback!!.dettach()
    }
}