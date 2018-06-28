package com.morse.ganio.entries

import java.io.Serializable

data class ReadSubResult(var _id: String?, var created_at: String?, var icon: String?, var id: String?, var title: String?) : Serializable {
    /**
     * "_id": "57c83792421aa97cada9b79d",
     * "created_at": "2016-09-01T22:13:38.420Z",
     * "icon": "http://ww2.sinaimg.cn/large/610dc034gw1f9sg2pq9ufj202s02s0sj.jpg",
     * "id": "qdaily",
     * "title": "\u597d\u5947\u5fc3\u65e5\u62a5"
     */
    override fun toString(): String {
        return "ReadSubResult{" +
                "_id='" + _id + '\''.toString() +
                ", created_at='" + created_at + '\''.toString() +
                ", icon='" + icon + '\''.toString() +
                ", id='" + id + '\''.toString() +
                ", title='" + title + '\''.toString() +
                '}'.toString()
    }
}
