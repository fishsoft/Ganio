package com.morse.ganio.main.fragment

import com.morse.ganio.http.ConsumerError
import com.morse.ganio.http.RxManager
import com.morse.ganio.mvp.BasePresenter
import io.reactivex.functions.Consumer

class FragmentPresenter : BasePresenter<IFragment>() {

    private var model: FragmentModel? = null

    init {
        model = FragmentModel()
    }

    fun getFragmentMsg(type: String, pageSize: Int, page: Int) {
        val t = when (type) {
            "全部" -> "all"
            "IOS" -> "iOS"
            else -> type
        }
        RxManager().register(model?.getFragmentInfo(t, pageSize, page)?.subscribe(Consumer() {
            if (null != it && null != it.results) {
                (getView() as IFragment).onSuccess(it.results)
            }
        }, ConsumerError(getView() as IFragment)))
//        model?.getFragmentInfo(t, pageSize, page)?.subscribe(Consumer() {
//            (getView() as? IFragment)?.onSuccess(it?.results)
//        }, ConsumerError(getView() as IFragment))?.let { RxManager().register(it) }
    }
}