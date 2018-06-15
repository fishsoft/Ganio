package com.morse.ganio.main.fragment

import com.morse.ganio.http.RxManager
import com.morse.ganio.mvp.BasePresenter
import io.reactivex.functions.Consumer

class FragmentPresenter : BasePresenter<IFragment>() {

    private var model: FragmentModel? = null

    init {
        model = FragmentModel()
    }

    fun getFragmentMsg(type: Int, page: Int) {
        RxManager().register(model!!.getFragmentInfo(type, page).subscribe(Consumer() {
            if (null != it && null != it.results) {
                (getView() as IFragment).onSuccess(it.results)
            }
        }))
    }
}