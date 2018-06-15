package com.morse.ganio.http.okhttp

import com.morse.ganio.http.utils.AppUtils
import com.morse.ganio.http.utils.HttpUtils
import com.morse.ganio.http.utils.NetworkConnectionUtils
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class CacheInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain?): Response {
        var request: Request? = chain!!.request()
        if (NetworkConnectionUtils.isNetworkConnected(AppUtils.getContext()!!)) {
            var maxAge: Int = 60 * 60
            request = request!!.newBuilder()
                    .removeHeader("User-Agent")
                    .header("User-Agent", HttpUtils.getUserAgent())
                    .build()

            var response: Response? = chain.proceed(request)
            return response!!.newBuilder()
                    .removeHeader("Pragma")
                    .removeHeader("Cache-Control")
                    .header("Cache-Control", "public, max-age=" + maxAge)
                    .build()
        } else {
            val maxSize: Int = 60 * 60 * 24 * 28
            request = request!!.newBuilder()
                    .cacheControl(CacheControl.FORCE_CACHE)
                    .removeHeader("User-Agent")
                    .header("User-Agent", HttpUtils.getUserAgent())
                    .build()

            val response: Response? = chain.proceed(request)
            return response!!.newBuilder()
                    .removeHeader("Pragma")
                    .removeHeader("Cache-Control")
                    .header("Cache-Control", "public, only-if-cached, max-stale=" + maxSize)
                    .build()
        }
    }
}