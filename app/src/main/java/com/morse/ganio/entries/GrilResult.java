package com.morse.ganio.entries;

import java.io.Serializable;

public class GrilResult implements Serializable {
    /**
     * "_id": "5b1fec10421aa9793930bf99",
     "createdAt": "2018-06-12T23:51:44.815Z",
     "desc": "2018-06-13",
     "publishedAt": "2018-06-14T00:00:00.0Z",
     "source": "web",
     "type": "\u798f\u5229",
     "url": "http://ww1.sinaimg.cn/large/0065oQSqly1fs8tym1e8ej30j60ouwhz.jpg",
     "used": true,
     "who": "lijinshanmx"
     */

    protected String _id;
    protected String createdAt;
    protected String desc;
    protected String publishedAt;
    protected String source;
    protected String url;
    protected String type;
    protected boolean used;
    protected String who;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    @Override
    public String toString() {
        return "GrilResult{" +
                "_id='" + _id + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", desc='" + desc + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", source='" + source + '\'' +
                ", url='" + url + '\'' +
                ", type='" + type + '\'' +
                ", used=" + used +
                ", who='" + who + '\'' +
                '}';
    }
}
