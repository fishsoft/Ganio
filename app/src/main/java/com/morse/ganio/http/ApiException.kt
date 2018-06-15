package com.morse.ganio.http;

/**
 * Created by admin on 2018/1/18.
 */

class ApiException : RuntimeException {


    /**
     * 由于服务器传递过来的错误信息直接给用户看的话，用户未必能够理解
     * 需要根据错误码对错误信息进行一个转换，在显示给用户
     *
     * @param code
     * @return
     */
    constructor(message: String?) : super(message)

    constructor(code: Int) : super(getApiExceptionMessage(code))

    companion object {
        fun getApiExceptionMessage(code: Int): String? {
            return null
        }
    }
}
