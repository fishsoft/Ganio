package com.morse.ganio.main.fragment

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.morse.ganio.R
import com.morse.ganio.entries.GrilResult
import com.morse.ganio.mvp.ui.fragment.MVPFragment
import kotlinx.android.synthetic.main.fragment_noraml.*

class GankFragment : MVPFragment<IFragment, FragmentPresenter>(), IFragment {

    private var titles: Array<String>? = arrayOf("全部", "Android", "IOS", "休息视频", "福利", "拓展资源", "前端", "瞎推荐", "App", "闲读")

    private var mPage: Int? = 1

    override fun onSuccess(results: List<GrilResult>?) {
        refresh.isRefreshing = false
        (rv_normal.adapter as FragmentAdapter).addItems(results)
        Toast.makeText(mContext, "获取数据成功", Toast.LENGTH_SHORT).show()
    }

    override fun onFailed(msg: String?) {
        refresh.isRefreshing = false
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show()
    }

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
        return inflater.inflate(R.layout.fragment_noraml, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rv_normal.adapter = FragmentAdapter()
        rv_normal.layoutManager = LinearLayoutManager(context)
        refresh.setOnRefreshListener(object : SwipeRefreshLayout.OnRefreshListener {
            override fun onRefresh() {
                //todo 刷新
                getDatas(mPage!!)
            }
        })

        getDatas(mPage!!)
    }

    override fun createPresenter(): FragmentPresenter {
        Log.d("morse", "createPresenter")
        return FragmentPresenter()
    }

    override fun getDatas(page: Int) {
        getPresenter()!!.getFragmentMsg(getType()!!, 10, page)
    }

    fun getType(): String? {
        return titles!![arguments!!.getInt(ID)]
    }

}