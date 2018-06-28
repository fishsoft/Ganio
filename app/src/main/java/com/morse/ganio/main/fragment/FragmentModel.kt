package com.morse.ganio.main.fragment

import com.morse.ganio.entries.BaseResponse
import com.morse.ganio.entries.GrilResult
import com.morse.ganio.http.Api
import com.morse.ganio.http.RetrofitCreateHelper
import com.morse.ganio.http.RxHelper
import io.reactivex.Observable

class FragmentModel : IFragmentModel {

    override fun getFragmentInfo(type: String, pageSize: Int, page: Int): Observable<BaseResponse<GrilResult>>? {
        return RetrofitCreateHelper.INSTANCE
                .createApi(Api::class.java)?.getContent(type, pageSize, page)?.compose(RxHelper.rxSchedulerHelper())
    }
}