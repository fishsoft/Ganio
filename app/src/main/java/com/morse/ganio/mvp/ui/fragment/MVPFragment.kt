package com.morse.ganio.mvp.ui.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.View
import android.widget.Toast
import com.morse.ganio.mvp.IPresenter
import com.morse.ganio.mvp.IView
import com.morse.ganio.mvp.ui.MVPCallback

/**
 * 集成MVP的frgament
 */
open abstract class MVPFragment<V : IView, P : IPresenter<V>> : Fragment(), IView, MVPCallback<V, P> {

    private var p: P? = null
    private var delegateFragment: DelegateFragmentImp<V, P>? = null

    private var mView: View? = null

    private var isCreate: Boolean? = false
    private var isShow: Boolean? = false

    protected var mContext: Context? = null

    private fun getDelegateFragment(): DelegateFragmentImp<V, P> {
        delegateFragment = DelegateFragmentImp(this)
        return delegateFragment!!
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        getDelegateFragment()
        isCreate = true
        delegateFragment!!.onCreateView()
        super.onCreate(savedInstanceState)
    }

    override fun createPresenter(): P? {
        return p
    }

    override fun getPresenter(): P? {
        return p
    }

    override fun setPresenter(p: P?) {
        this?.p=p
    }

    override fun getMVPView(): V? {
        return this as V
    }

    override fun onDestroyView() {
        delegateFragment!!.onDestroy()
        super.onDestroyView()
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        if (isCreate!! && isShow!!) {
            getDatas(1)
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mContext = context
    }

    override fun onFailed(msg: String?) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show()
    }

    abstract fun getDatas(page: Int)
}