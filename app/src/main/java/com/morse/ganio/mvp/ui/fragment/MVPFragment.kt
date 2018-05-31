package com.morse.ganio.mvp.ui.fragment

import android.support.v4.app.Fragment
import com.morse.ganio.mvp.IPresenter
import com.morse.ganio.mvp.IView
import com.morse.ganio.mvp.ui.MVPCallback

open abstract class MVPFragment<V : IView, P : IPresenter<V>> : Fragment(), IView, MVPCallback<V, P> {

    private var p: P? = null
    private var delegateFragment: DelegateFragmentImp<V, P>? = null

    private fun getDelegateFragment(): DelegateFragmentImp<V, P> {
        delegateFragment = DelegateFragmentImp(this)
        return this!!.delegateFragment!!
    }

    override fun createPresenter(): P {
        return this!!.p!!
    }

    override fun getPresenter(): P {
        return this!!.p!!
    }

    override fun setPresenter(p: P?) {
        this!!.p = p
    }

    override fun getMVPView(): V {
        return this as V
    }
}