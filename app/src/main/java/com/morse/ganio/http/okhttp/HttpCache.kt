package com.morse.ganio.http.okhttp

import com.morse.ganio.GanApp
import com.morse.ganio.http.utils.AppUtils
import okhttp3.Cache
import java.io.File

class HttpCache {

    companion object {
        var HTTP_RESPONSE_DISK_CACHE_MAX_SIZE: Long? = 50 * 1024 * 1024

        fun getCache(): Cache {
            return GanApp.getApp()?.let {
                Cache(File(it.getCacheDir().getAbsolutePath() + File
                        .separator + "data/NetCache"), HttpCache.HTTP_RESPONSE_DISK_CACHE_MAX_SIZE!!)
            }!!
        }
    }

}