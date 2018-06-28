package com.morse.ganio.entries

import java.io.Serializable

data class BaseResponse<T>(var results: List<T>?, var error: Boolean?, var code: Int) : Serializable {

    override fun toString(): String {
        return "BaseResponse{" +
                "data=" + results +
                ", msg='" + error + '\''.toString() +
                ", code=" + code +
                '}'.toString()
    }
}
