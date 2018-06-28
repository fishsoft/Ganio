package com.morse.ganio.http.okhttp

import com.morse.ganio.http.utils.AppUtils
import com.morse.ganio.http.utils.HttpUtils.Companion.getUserAgent
import com.morse.ganio.http.utils.NetworkConnectionUtils
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class NetInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain?): Response {
        val maxAge = 60
        var request: Request? = chain!!.request()

        if (NetworkConnectionUtils.isNetworkConnected(AppUtils.getContext()!!)) {
            request = request!!.newBuilder()
                    .removeHeader("User-Agent")
                    .header("User-Agent", getUserAgent())
                    .build()

            var response: Response? = chain.proceed(request)
            return response?.let {
                it.newBuilder()
                        .removeHeader("Pragma")
                        .removeHeader("Cache-Control")
                        .header("Cache-Control", "public, max-age=" + maxAge)
                        .build()
            }!!
        } else {
            throw NullPointerException("")
        }
    }
}