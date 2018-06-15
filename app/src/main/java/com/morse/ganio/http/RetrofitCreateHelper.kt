package com.morse.ganio.http;

import com.morse.ganio.http.okhttp.CacheInterceptor
import com.morse.ganio.http.okhttp.HttpCache
import com.morse.ganio.http.okhttp.TrustManager
import com.morse.ganio.http.utils.Custom
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.apache.http.conn.ssl.SSLSocketFactory
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.util.concurrent.TimeUnit

class RetrofitCreateHelper {

    private var retrofit: Retrofit? = null;

    private constructor() {
        val okHttpClient: OkHttpClient = OkHttpClient.Builder()
                //SSL证书
                .sslSocketFactory(TrustManager.getUnsafeOkHttpClient())
//            .sslSocketFactory(TrustManager.getSafeOkHttpClient())
                .hostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER)
                //打印日志
                .addInterceptor(HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BODY))
                //设置Cache拦截器
                .addNetworkInterceptor(CacheInterceptor())
                .addInterceptor(CacheInterceptor())
                .cache(HttpCache.getCache())
                //time out
                .connectTimeout(Custom.TIMEOUT_CONNECTION, TimeUnit.SECONDS)
                .readTimeout(Custom.TIMEOUT_READ, TimeUnit.SECONDS)
                .writeTimeout(Custom.TIMEOUT_READ, TimeUnit.SECONDS)
                //失败重连
                .retryOnConnectionFailure(true)
                .build()

        retrofit = Retrofit.Builder()
                .baseUrl(Api.HOST)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(ResponseConvertFactory.create())
                .build()
    }

    companion object {
        fun get(): RetrofitCreateHelper {
            return Instance.user
        }
    }

    private object Instance {
        val user = RetrofitCreateHelper()
    }

    fun <T : Any?> createApi(clazz: Class<T>): T {
        return retrofit!!.create(clazz)
    }
}

