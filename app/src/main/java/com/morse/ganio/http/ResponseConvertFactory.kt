package com.morse.ganio.http;

import com.google.gson.Gson;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created by admin on 2018/1/18.
 */

class ResponseConvertFactory private constructor(val gson: Gson) : Converter.Factory() {

    private var mGson: Gson? = gson

    companion object {

        fun create(): ResponseConvertFactory {
            return create(Gson())
        }

        fun create(gson: Gson): ResponseConvertFactory {
            return ResponseConvertFactory(gson)
        }
    }

    override fun responseBodyConverter(type: Type?, annotations: Array<out kotlin.Annotation>?, retrofit: Retrofit?): Converter<ResponseBody, *>? {
        return GsonResponseBodyConverter<Any>(gson = Gson()!!, type = type!!)
    }
}
