package com.morse.ganio.http;

import com.morse.ganio.entries.BaseResponse
import com.morse.ganio.entries.GrilResult
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    companion object {
        var HOST: String = "http://gank.io/api/data/"
    }

    @GET("{type}/{pageSize}/{page}")
    open fun getContent(@Path("type") type: String, @Path("pageSize") pageSize: Int, @Path("page") page: Int): Observable<BaseResponse<GrilResult>>

}
