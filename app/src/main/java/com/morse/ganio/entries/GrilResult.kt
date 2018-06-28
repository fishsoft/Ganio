package com.morse.ganio.entries

import java.io.Serializable

open class GrilResult(var _id: String, var createdAt: String, var desc: String, var publishedAt: String,
                           var source: String, var url: String, var type: String, var isUsed: Boolean, var who: String) : Serializable {
    /**
     * "_id": "5b1fec10421aa9793930bf99",
     * "createdAt": "2018-06-12T23:51:44.815Z",
     * "desc": "2018-06-13",
     * "publishedAt": "2018-06-14T00:00:00.0Z",
     * "source": "web",
     * "type": "\u798f\u5229",
     * "url": "http://ww1.sinaimg.cn/large/0065oQSqly1fs8tym1e8ej30j60ouwhz.jpg",
     * "used": true,
     * "who": "lijinshanmx"
     */
    override fun toString(): String {
        return "GrilResult{" +
                "_id='" + _id + '\''.toString() +
                ", createdAt='" + createdAt + '\''.toString() +
                ", desc='" + desc + '\''.toString() +
                ", publishedAt='" + publishedAt + '\''.toString() +
                ", source='" + source + '\''.toString() +
                ", url='" + url + '\''.toString() +
                ", type='" + type + '\''.toString() +
                ", used=" + isUsed +
                ", who='" + who + '\''.toString() +
                '}'.toString()
    }
}
