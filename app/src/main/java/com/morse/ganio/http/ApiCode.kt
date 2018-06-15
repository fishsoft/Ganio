package com.morse.ganio.http;

/**
 * Created by admin on 2018/1/18.
 */

interface ApiCode {
    companion object {
        /**
         * 默认的错误
         */
        var CODE_ERROR: Int = 0
        /**
         * 参数错误
         */
        var CODE_PARAM_NULL_ERROR: Int = 1
        /**
         * 参数类型错误
         */
        var CODE_ACCOUNT_OR_TOKEN_ERROR: Int = 2

        /**
         * 网络异常
         */
        var CODE_NET_ERROR: Int = 4
    }
}
