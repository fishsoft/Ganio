package com.morse.ganio.http;

import android.util.Log
import com.google.gson.Gson
import com.morse.ganio.entries.BaseResponse
import okhttp3.ResponseBody
import retrofit2.Converter
import java.io.IOException
import java.lang.reflect.Type

/**
 * Created by admin on 2018/1/18.
 */

class GsonResponseBodyConverter<T> : Converter<ResponseBody, T> {
    private val gson: Gson
    private val type: Type

    constructor(gson: Gson, type: Type) {
        this.gson = gson
        this.type = type
    }

    @Throws(IOException::class)
    override fun convert(value: ResponseBody): T {
        var response: String = value.string()
        Log.d("Network", "response>>" + response)
        //httpResult 只解析result字段

        val httpResult: BaseResponse<*>? = gson.fromJson(response, BaseResponse::class.java)
        //
        if (httpResult?.error!!) {
//            throw ApiException(httpResult.code)
            throw NullPointerException("获取数据失败") as Throwable
        }
        return gson.fromJson(response, type)
    }
}
