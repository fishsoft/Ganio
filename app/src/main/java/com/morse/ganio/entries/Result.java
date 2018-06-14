package com.morse.ganio.entries;

import java.io.Serializable;
import java.util.List;

public class Result extends GrilResult implements Serializable {
    /**
     * "_id": "5b20a86b421aa97934d42ffd",
     * "createdAt": "2018-06-14T12:22:32.573Z",
     * "desc": "android\u56fe\u7247\u6d82\u9e26\uff0c\u5177\u6709\u8bbe\u7f6e\u753b\u7b14\uff0c\u64a4\u9500\uff0c\u7f29\u653e\u79fb\u52a8\u7b49\u529f\u80fd\u3002",
     * "images": [
     * "http://img.gank.io/e666e3c0-3606-4107-a515-4e3a96a6cfdd",
     * "http://img.gank.io/648431b0-10f3-40da-bfc8-dacf2eb34ace",
     * "http://img.gank.io/2086cfd0-39f9-4ae3-b32e-5c90e3fefa2a"
     * ],
     * "publishedAt": "2018-06-14T00:00:00.0Z",
     * "source": "web",
     * "type": "Android",
     * "url": "https://github.com/1993hzw/Graffiti",
     * "used": true,
     * "who": "joker"
     */
    private List<String> images;

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "Result{" +
                "_id='" + _id + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", desc='" + desc + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", images=" + images +
                ", source='" + source + '\'' +
                ", url='" + url + '\'' +
                ", type='" + type + '\'' +
                ", used=" + used +
                ", who='" + who + '\'' +
                '}';
    }
}
