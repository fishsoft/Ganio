package com.morse.ganio.main.fragment

import com.morse.ganio.entries.BaseResponse
import com.morse.ganio.entries.GrilResult
import io.reactivex.Observable

interface IFragmentModel {

    fun getFragmentInfo(type: String, pageSize: Int, page: Int): Observable<BaseResponse<GrilResult>>?
}