package com.morse.ganio.entries;

import java.io.Serializable;

public class ReadResult implements Serializable {

    /**
     * "_id": "57c83777421aa97cbd81c74d",
     * "en_name": "wow",
     * "name": "\u79d1\u6280\u8d44\u8baf",
     * "rank": 1
     */

    private String _id;
    private String en_name;
    private String name;
    private int rank;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getEn_name() {
        return en_name;
    }

    public void setEn_name(String en_name) {
        this.en_name = en_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "ReadResult{" +
                "_id='" + _id + '\'' +
                ", en_name='" + en_name + '\'' +
                ", name='" + name + '\'' +
                ", rank=" + rank +
                '}';
    }
}
