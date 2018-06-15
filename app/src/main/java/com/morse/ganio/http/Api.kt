package com.morse.ganio.http;

import com.morse.ganio.entries.BaseResponse
import com.morse.ganio.entries.Result
import io.reactivex.Observable
import retrofit2.http.GET

interface Api {

    companion object {
        var HOST: String = ""
    }

    @GET()
    open fun getContent(type:Int,page:Int):Observable<BaseResponse<Result>>

}
