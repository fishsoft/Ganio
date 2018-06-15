package com.morse.ganio.http.okhttp

import android.content.Context
import com.morse.ganio.http.utils.AppUtils
import okhttp3.Cache
import java.io.File

class HttpCache {

    companion object {
        var HTTP_RESPONSE_DISK_CACHE_MAX_SIZE: Long? = 50 * 1024 * 1024

        fun getCache(): Cache {
            return Cache(File(AppUtils.getContext()!!.getCacheDir().getAbsolutePath() + File
                    .separator + "data/NetCache"), HttpCache.HTTP_RESPONSE_DISK_CACHE_MAX_SIZE!!)
        }
    }

}