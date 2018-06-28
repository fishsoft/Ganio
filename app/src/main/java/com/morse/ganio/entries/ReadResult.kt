package com.morse.ganio.entries

import java.io.Serializable

data class ReadResult(var _id: String?, var en_name: String?, var name: String?, var rank: Int) : Serializable {

    /**
     * "_id": "57c83777421aa97cbd81c74d",
     * "en_name": "wow",
     * "name": "\u79d1\u6280\u8d44\u8baf",
     * "rank": 1
     */
    override fun toString(): String {
        return "ReadResult{" +
                "_id='" + _id + '\''.toString() +
                ", en_name='" + en_name + '\''.toString() +
                ", name='" + name + '\''.toString() +
                ", rank=" + rank +
                '}'.toString()
    }
}
