package com.morse.ganio.main.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.morse.ganio.R
import com.morse.ganio.mvp.ui.fragment.MVPFragment

class GankFragment : MVPFragment<IFragment, FragmentPresenter>(), IFragment {

    private var rvNormal: RecyclerView? = null

    companion object {
        val ID = "fragment_id"
        fun getInstance(tag: Int): GankFragment {
            var fragment = GankFragment()
            var bundle = Bundle()
            bundle.putInt(ID, tag)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_noraml, container, false)
        rvNormal = view.findViewById(R.id.rv_normal)
        rvNormal!!.adapter = FragmentAdapter()
        rvNormal!!.layoutManager = LinearLayoutManager(context)

        getDatas()
        return view
    }

    override fun createPresenter(): FragmentPresenter {
        Log.d("morse","createPresenter")
        return FragmentPresenter()
    }

    override fun getDatas() {
        getPresenter()!!.getFragmentMsg(arguments!!.getInt(ID))
    }

}