package com.morse.ganio.http;

import com.morse.ganio.mvp.IView
import io.reactivex.functions.Consumer
import java.net.SocketTimeoutException

/**
 * Created by admin on 2018/1/22.
 * 处理异常信息
 */

class ConsumerError : Consumer<Throwable> {

    private var view: IView? = null

    constructor(v: IView) {
        view = v
    }

    @Throws(Exception::class)
    override fun accept(t: Throwable?) {
        if (t is SocketTimeoutException) {
            view?.onFailed("连接服务器超时")
        } else if (t is ApiException) {
            view?.onFailed(t.message)
        }
    }
}
