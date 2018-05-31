package com.morse.ganio.mvp.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.morse.ganio.mvp.IPresenter
import com.morse.ganio.mvp.IView
import com.morse.ganio.mvp.ui.MVPCallback

/**
 * 集成MVP的frgament
 */
open abstract class MVPFragment<V : IView, P : IPresenter<V>> : Fragment(), IView, MVPCallback<V, P> {

    private var p: P? = null
    private var delegateFragment: DelegateFragmentImp<V, P>? = null

    private fun getDelegateFragment(): DelegateFragmentImp<V, P> {
        delegateFragment = DelegateFragmentImp(this)
        return this!!.delegateFragment!!
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        getDelegateFragment()
        delegateFragment!!.onCreateView()
        return super.onCreateView(inflater, container, savedInstanceState)
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

    override fun onDestroyView() {
        delegateFragment!!.onDestroy()
        super.onDestroyView()
    }
}