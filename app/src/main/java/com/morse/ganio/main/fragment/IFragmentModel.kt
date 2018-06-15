package com.morse.ganio.main.fragment

import com.morse.ganio.entries.BaseResponse
import com.morse.ganio.entries.Result
import io.reactivex.Observable

interface IFragmentModel {

    fun getFragmentInfo(type: Int, page: Int):Observable<BaseResponse<Result>>
}