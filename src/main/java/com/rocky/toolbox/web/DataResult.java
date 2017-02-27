package com.rocky.toolbox.web;

/**
 * Created by rocky on 17/2/23.
 */
public class DataResult {
    private int code;
    private Object data;
    private String msg;

    public DataResult() {
    }


    public DataResult(int code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
