package com.morse.ganio.main.fragment

import com.morse.ganio.entries.BaseResponse
import com.morse.ganio.entries.Result
import com.morse.ganio.http.Api
import com.morse.ganio.http.RetrofitCreateHelper
import com.morse.ganio.http.RxHelper
import io.reactivex.Observable

class FragmentModel : IFragmentModel {

    override fun getFragmentInfo(type: Int, page: Int): Observable<BaseResponse<Result>> {
        return RetrofitCreateHelper.get()
                .createApi(Api::class.java)
                .getContent(type, page)
                .compose(RxHelper.rxSchedulerHelper())
    }
}