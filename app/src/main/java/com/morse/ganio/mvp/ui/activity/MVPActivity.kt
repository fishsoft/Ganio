package com.morse.ganio.mvp.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.morse.ganio.mvp.IPresenter
import com.morse.ganio.mvp.IView
import com.morse.ganio.mvp.ui.MVPCallback

open abstract class MVPActivity<V : IView, P : IPresenter<V>> : AppCompatActivity(), IView, MVPCallback<V, P> {

    private var p: P? = null
    private var delegateActivity: DelegateActivityImp<V, P>? = null

    private fun getActivityDelegate(): DelegateActivityImp<V, P> {
        delegateActivity = DelegateActivityImp(this)
        return delegateActivity!!
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        getActivityDelegate()
        delegateActivity!!.onCreate()
        super.onCreate(savedInstanceState)
    }

    override fun onDestroy() {
        delegateActivity!!.onDestory()
        super.onDestroy()
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