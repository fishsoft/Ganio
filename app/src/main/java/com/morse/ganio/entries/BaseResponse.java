package com.morse.ganio.entries;

import java.io.Serializable;
import java.util.List;

public class BaseResponse<T> implements Serializable {

    private List<T> results;
    private String error;
    private int code;

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "data=" + results +
                ", msg='" + error + '\'' +
                ", code=" + code +
                '}';
    }
}
