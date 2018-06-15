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

    private var mContext: Context? = null

    private fun getDelegateFragment(): DelegateFragmentImp<V, P> {
        delegateFragment = DelegateFragmentImp(this)
        return this!!.delegateFragment!!
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        getDelegateFragment()
        isCreate = true
        delegateFragment!!.onCreateView()
        super.onCreate(savedInstanceState)
    }

    override fun createPresenter(): P {
        return this!!.p!!
    }

    override fun getPresenter(): P {
        return this!!.p!!
    }

    override fun setPresenter(p: P?) {
        if (null == this) {
            Log.d("morse", "this is null")
        }
        if (null == this!!.p) {
            Log.d("morse", "this.p is null")
        }
        if (null == p) {
            Log.d("morse", "p is null")
        }
        this!!.p = p!!
    }

    override fun getMVPView(): V {
        return this as V
    }

    override fun onDestroyView() {
        delegateFragment!!.onDestroy()
        super.onDestroyView()
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        if (isCreate!! && isShow!!) {
            getDatas()
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mContext = context
    }

    override fun onFailed(msg: String?) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show()
    }

    abstract fun getDatas()
}